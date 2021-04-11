package com.graphs;

import com.doublyLinkedList.DoublyLinkedList;
import com.stackAndQueue.Queue;

public class CheckTree {

	public static void main(String[] args) {
		 Graph g = new Graph(6);
	        g.addEdge(0,1);
	        g.addEdge(0,2);
	        g.addEdge(0,5);
	        g.addEdge(2,3);
	        g.addEdge(2, 4);
	        g.printGraph();
	        System.out.println("isTree : " + isTree(g));

	        Graph g2 = new Graph(4);
	        g2.addEdge(0,1);
	        g2.addEdge(0,2);
	        g2.addEdge(0,3);
	        g2.addEdge(3,2);
	        g2.printGraph();
	        System.out.println("isTree : " + isTree(g2));

	        Graph g3 = new Graph(6);
	        g3.addEdge(0,1);
	        g3.addEdge(0,2);
	        g3.addEdge(0,3);
	        g3.addEdge(4,5);
	        g3.printGraph();
	        System.out.println("isTree : " + isTree(g3));

	}
	public static boolean isTree(Graph g) {
		boolean[] visited = new boolean[g.vertices];
		Queue<Integer> queue = new Queue<Integer>(g.vertices);
		
		int root = 0;
		visited[root] = true;
		queue.enqueue(root);
		int numOfVistedVertices = 1;
		
		while(!queue.isEmpty()) {
			int temp = queue.dequeue();
			DoublyLinkedList<Integer>.Node node = null;
			if(g.adjacencyList[temp] != null)
				node = g.adjacencyList[temp].headNode;
			while(node != null) {
				if(!visited[node.data]) {
					queue.enqueue(node.data);
					visited[node.data] = true;
					++numOfVistedVertices;
				} else {
					return false;
				}
				node = node.nextNode;
			}
		}
		if(numOfVistedVertices == g.vertices)
			return true;
		return false;
	}
}
