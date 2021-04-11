package com.trees;

public class CheckMinMax {

	
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
		System.out.println(findKthMaxWrapper(bsT.getRoot(), 4));

	}
/*
 * Find the minimum element in a binary tree 
 * Iterate till we find the leftmost node in the left child tree
 * 
 */
	public static int findMin(Node<Integer> root) 
	{
		if(root == null)
			return -1;
		else if(root.getLeftNode() == null) {
			return root.getData();
		}
		return findMin(root.getLeftNode());
	}
	
	/*
	 * Find kth Max element in the binary tree
	 */
	
	static int count;
	public static int findKthMaxWrapper(Node<Integer> root, int k) {
		count = 0;
		Node<Integer> node = findKthMax(root, k);
		if(node != null)
			return node.getData();
		return -1;
	}
	
	public static Node<Integer> findKthMax(Node<Integer> root, int k) {
		if(root == null)
			return null;
		//Traverse till rightmost node
		Node<Integer> node = findKthMax(root.getRightNode(), k);
		//increment counter after max element is found
		if(count != k) {
			count++;
			node = root;
		}
		//return node if count is equal to the K
		if(count == k)
			return node;
		// else traverse the left child 
		else
			return findKthMax(root.getLeftNode(), k);
	}

}
