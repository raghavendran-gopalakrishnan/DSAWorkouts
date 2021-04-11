package com.graphs;

import com.doublyLinkedList.DoublyLinkedList;

public class RemoveEdge {

	public static void main(String[] args) {
		 Graph g=new Graph(5);
	        g.addEdge(0,1);
	        g.addEdge(0,2);
	        g.addEdge(1,3); 
	        g.addEdge(3,4); 
	        g.addEdge(1,4);
	        g.printGraph();
	        removeEdge(g,1,4);
	        g.printGraph();
	}

	public static void removeEdge(Graph g, int source, int destination) {
		g.adjacencyList[source].deleteByValue(destination);
	}

}
