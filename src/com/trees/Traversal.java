package com.trees;

public class Traversal {

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
		preOrderTraverse(bsT.getRoot());
		System.out.println();
		inOrderTraverse(bsT.getRoot());
		System.out.println();
		postOrderTraverse(bsT.getRoot());
	}

	private static void preOrderTraverse(Node<Integer> currentNode) {
		if(currentNode==null)
			return;
		System.out.print(currentNode.getData()+" ");
		preOrderTraverse(currentNode.getLeftNode());
		preOrderTraverse(currentNode.getRightNode());
		
	}
	
	private static void inOrderTraverse(Node<Integer> currentNode) {
		if(currentNode==null)
			return;
		inOrderTraverse(currentNode.getLeftNode());
		System.out.print(currentNode.getData()+" ");
		inOrderTraverse(currentNode.getRightNode());
	}
	
	private static void postOrderTraverse(Node<Integer> currentNode) {
		if(currentNode==null)
			return;
		postOrderTraverse(currentNode.getLeftNode());
		postOrderTraverse(currentNode.getRightNode());
		System.out.print(currentNode.getData()+" ");
	}

}
