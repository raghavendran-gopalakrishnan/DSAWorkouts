package com.trees;

public class CheckKNodes {

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
		System.out.println(findKNodesWrapper(bsT.getRoot(), 0));
	}
	
	public static String findKNodesWrapper(Node root, int k) {
		StringBuilder result = new StringBuilder();
		result = findKNodes(root,result,k);
		return result.toString();
	}

	private static StringBuilder findKNodes(Node root, StringBuilder result, int k) {
		if(root == null)
			return null;
		if(k==0) {
			result.append(root.getData()+" ");
		} else {
			findKNodes(root.getLeftNode(), result, k-1);
			findKNodes(root.getRightNode(), result, k-1);
		}
		return result;
	}

}
