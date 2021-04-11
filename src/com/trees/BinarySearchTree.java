package com.trees;

public class BinarySearchTree {
	private Node<Integer> root;


	public Node<Integer> getRoot() {
		return root;
	}


	public void setRoot(Node<Integer> root) {
		this.root = root;
	}
	
	public boolean delete (int value, Node<Integer> currentNode) {
		if(root == null)
			return false;
		Node<Integer> parentNode = null;
		//Find the Node to be deleted and its parent node
		while(currentNode != null && currentNode.getData() != value) {
			parentNode = currentNode;
			if(currentNode.getData() > value) {
				currentNode = currentNode.getLeftNode();
			} else {
				currentNode = currentNode.getRightNode();
			}
		}
		//Node is not found
		if(currentNode == null)
			return false;
		//If its a leaf node
		else if (currentNode.getLeftNode() == null && currentNode.getRightNode() == null) {
			// if Node is a root, set to null
			if(root.getData() == currentNode.getData()) {
				setRoot(null);
				return true;
			}
			// if node is a left leaf, set Parent's left child node to null
			else if(parentNode.getData() > currentNode.getData()) {
				parentNode.setLeftNode(null);
				return true;
			} 
			// else the right child to null
			else {
				parentNode.setRightNode(null);
				return true;
			}
		}
		//If the node is a Parent with one child (left)
		else if(currentNode.getRightNode() == null) {
			//if current node is a root, replace with root with its left child 
			if(root.getData() == currentNode.getData()) {
				setRoot(currentNode.getLeftNode());
				return true;
			} else if(parentNode.getData() > currentNode.getData()) {
				parentNode.setLeftNode(currentNode.getLeftNode());
				return true;
			} else {
				parentNode.setRightNode(currentNode.getLeftNode());
				return true;
			}
		}
		//If the node is a Parent with one child (right)
		else if (currentNode.getLeftNode() == null) {
			//if the node is a root
			if(root.getData() == currentNode.getData())
				setRoot(currentNode.getRightNode());
			else if(parentNode.getData() > currentNode.getData()) {
				parentNode.setLeftNode(currentNode.getRightNode());
				return true;
			} else {
				parentNode.setRightNode(currentNode.getRightNode());
				return true;
			}
		} else {
			Node<Integer> leastNode = leastNode(currentNode.getRightNode());
			int temp = leastNode.getData();
			delete(temp, root);
			currentNode.setData(temp);
			return true;
		}
		return false;
	}

	public Node<Integer> leastNode(Node<Integer> currentNode){
		Node<Integer> temp = currentNode;
		while(temp.getLeftNode()!=null) {
			temp = temp.getLeftNode();
		}
		return temp;
	}
	
	public boolean add (int value) {
		if(isEmpty()) {
			root = new Node<Integer>(value);
			return true;
		}

		Node<Integer> currentNode = root;
		while(currentNode != null) {
			Node<Integer> leftChild = currentNode.getLeftNode();
			Node<Integer> rightChild = currentNode.getRightNode();
			if(currentNode.getData() > value) {
				if(leftChild == null) {
					leftChild = new Node<Integer>(value);
					currentNode.setLeftNode(leftChild);
					return true;
				}
				currentNode = leftChild;
			} else {
				if(rightChild == null) {
					rightChild = new Node<Integer>(value);
					currentNode.setRightNode(rightChild);
					return true;
				}
				currentNode = rightChild;
				return true;
			}
		}
		return false;
	}
	
	public void addR(int value) {
		setRoot(recursiveAdd(root, value));
	}
	
	public Node recursiveAdd(Node<Integer> currentNode, int value) {
		if(currentNode == null) {
			return new Node<Integer>(value);
		}
		if(currentNode.getData() > value) {
			currentNode.setLeftNode(recursiveAdd(currentNode.getLeftNode(), value));
		} else if (currentNode.getData() < value) {
			currentNode.setRightNode(recursiveAdd(currentNode.getRightNode(), value));
		} else {
			return currentNode;
		}
		return currentNode;
	}

	public boolean isEmpty() {
		return root == null;
	}

	//Just for Testing purpose 
	public void printTree(Node current) 
	{
		if (current == null) return;

		System.out.print(current.getData() + ",");
		printTree(current.getLeftNode());
		printTree(current.getRightNode());

	}
	
	public Node<Integer> search (int value){
		if(isEmpty()) return null;
		Node<Integer> currentNode = root;
		while(currentNode != null) {
			if(currentNode.getData() == value) {
				return currentNode;
			} else if(currentNode.getData() > value) {
				currentNode = currentNode.getLeftNode();
			} else{
				currentNode = currentNode.getRightNode();
			}
		}
		return currentNode;
	}
	
	
	public Node<Integer> searchR(int value){
		if(isEmpty()) return null;
		return recursiveSearch(root,value);
	}
	
	public Node<Integer> recursiveSearch(Node<Integer> currentNode, int value){
		if(currentNode == null || currentNode.getData() == value) {
			return currentNode;
		}
		if(currentNode.getData() > value) {
			return recursiveSearch(currentNode.getLeftNode(), value);
		} else {
			return recursiveSearch(currentNode.getRightNode(), value);
		}
	}

	public static void main(String[] args) {
		BinarySearchTree bsT = new BinarySearchTree();

		bsT.addR(6);
		bsT.addR(4);
		bsT.addR(9);
		bsT.addR(5);
		bsT.addR(2);
		bsT.addR(8);
		bsT.addR(12);
		bsT.addR(10);
		bsT.addR(14);
		bsT.addR(1);
		bsT.printTree(bsT.getRoot());
		System.out.println();
		try {
		System.out.println(bsT.searchR(11).getData());
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		bsT.addR(15);
		bsT.printTree(bsT.getRoot());
		System.out.println();
		bsT.delete(12, bsT.getRoot());
		bsT.printTree(bsT.getRoot());
		System.out.println();
	}



}
