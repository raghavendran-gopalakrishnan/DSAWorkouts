package com.trees;

public class CheckAncestors {

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
		//System.out.println(findMin(bsT.getRoot()));
		System.out.println(findAncestorWrapper(bsT.getRoot(), 10));

	}
	static StringBuilder sb = new StringBuilder();
	private static String findAncestorWrapper(Node<Integer> root, int value) {
		// TODO Auto-generated method stub
		return root == null ? "":root.getData() +findAncestor(root,value);
	}

	private static String findAncestor(Node<Integer> root, int value) {
		if(root == null)
			return "";
		if(value > root.getData() && root.getRightNode().getData() != value) {
			sb.append(","+ root.getRightNode().getData() );
			findAncestor(root.getRightNode(), value);
		} else if (value < root.getData() && root.getLeftNode().getData() != value) {
			sb.append(","+ root.getLeftNode().getData() + ",");
			findAncestor(root.getLeftNode(), value);
		} 
		return sb.toString();
	}
	
	private static String findAncestorIterative(Node<Integer> root, int value) {
		String result = "";
		Node<Integer> tempNode = root;
		while(tempNode != null && tempNode.getData() != value) {
			result = result +","+ tempNode.getData();
			if(value > tempNode.getData()) {
				tempNode = tempNode.getRightNode();
			} else {
				tempNode = tempNode.getLeftNode();
			}
		}
		if(tempNode==null)
			return "";
		return result;
	}

}
