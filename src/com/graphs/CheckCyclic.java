package com.graphs;

import java.util.Arrays;

import com.doublyLinkedList.DoublyLinkedList;

public class CheckCyclic {

	public static void main(String[] args) {
		 Graph g1 = new Graph(5);
	       
	        g1.addEdge(1,2);
	        g1.addEdge(1,0);
	        g1.addEdge(2,3);
	        g1.addEdge(3,1);
	        g1.addEdge(0,4);
	       // g1.addEdge(4,3);
	        g1.printGraph();
	        System.out.println(detectCycle(g1));

	}

	private static boolean detectCycle(Graph g) {
		int numOfVertices = g.vertices;
		boolean visited[] = new boolean[numOfVertices];
		boolean stackFlag[] = new boolean[numOfVertices];
		for(int i=0;i<numOfVertices; i++) {
			if(cyclic(g,i,visited,stackFlag)) {
				return true;	
			}
		}
		return false;
	}

	private static boolean cyclic(Graph g, int V, boolean[] visited, boolean[] stackFlag) {
		System.out.println(Arrays.toString(stackFlag));
		if(stackFlag[V])
			return true;
		if(visited[V])
			return false;
		visited[V] = true;
		stackFlag[V] = true;
		
		DoublyLinkedList<Integer>.Node temp = null;
		if(g.adjacencyList[V]!=null)
			temp = g.adjacencyList[V].headNode;
		System.out.println("Processing "+V);
		while(temp != null) {
			if(cyclic(g, temp.data, visited, stackFlag)) {
				return true;
			}
			temp = temp.nextNode;
		}
		
		stackFlag[V] = false;
		return false;
	}

}
