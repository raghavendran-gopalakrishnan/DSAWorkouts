package com.graphs;

import com.doublyLinkedList.DoublyLinkedList;

public class CheckNumEdges {

	public static void main(String[] args) {
		Graph graph = new Graph(4);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 3);
		graph.addEdge(2, 3);
		System.out.println(numEdges(graph));
	}
	
	public static int numEdges(Graph g) {
		int size=0;
        for(int i=0;i<g.vertices;i++) {
        	DoublyLinkedList<Integer>.Node tmp = null;
        	if(g.adjacencyList[i] != null) {
        		tmp = g.adjacencyList[i].headNode;
        	}
        	while(tmp != null) {
        		++size;
        		tmp = tmp.nextNode;
        	}
        }
        return size/2;
    }

}
