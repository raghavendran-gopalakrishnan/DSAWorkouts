package com.graphs;

import java.util.Arrays;

import com.doublyLinkedList.DoublyLinkedList;
import com.stackAndQueue.Queue;

public class ShortestPath {

	public static void main(String[] args) {
		 Graph g=new Graph(5);
	        g.addEdge(0,1);
	        g.addEdge(0,2);
	        g.addEdge(1,3); 
	        g.addEdge(3,4); 
	      //  g.addEdge(1,4);
	        // g.addEdge(0,4);
	        System.out.println(findMin(g, 0, 4));

	}

	private static int findMin(Graph g, int source, int destination) {
		boolean visited[] = new boolean[g.vertices];
		Queue<Integer> queue = new Queue<Integer>(g.vertices);
		int distance[] = new int[g.vertices];
		visited[source] = true;
		queue.enqueue(source);
		while(!queue.isEmpty()) {
			int currentNode = queue.dequeue();
			DoublyLinkedList<Integer>.Node tmpNode = null;
			if(g.adjacencyList[currentNode] != null)
				tmpNode = g.adjacencyList[currentNode].headNode;
			while(tmpNode != null) {
				if(!visited[tmpNode.data]) {
					queue.enqueue(tmpNode.data);
					visited[tmpNode.data] = true;
					distance[tmpNode.data] = distance[currentNode] + 1;
				}
				if(tmpNode.data == destination) {
					return distance[tmpNode.data];
				}
				tmpNode = tmpNode.nextNode;
			}
		}
		return -1;
	}

}
