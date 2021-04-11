/**
 * 
 */
package com.graphs;

import java.util.ArrayList;
import java.util.Iterator;

import com.doublyLinkedList.DoublyLinkedList;
import com.stackAndQueue.Queue;

/**
 * @author ragg
 *
 */
public class BFSTraversal {

	public static String bFSTraversal(Graph g, int source) {
		String result = "";
		int num_of_vertices = g.vertices;
		Queue<Integer> queue = new Queue<Integer>(num_of_vertices);
		boolean[] visited = new boolean[num_of_vertices];
		queue.enqueue(source);
		visited[source] = true;
		while(!queue.isEmpty()) {
			int currentNode = queue.dequeue();
			result += String.valueOf(currentNode) + " ";
			DoublyLinkedList<Integer>.Node tmp = null;
			if(g.adjacencyList[currentNode] != null)
				tmp = g.adjacencyList[currentNode].headNode;
			while(tmp!=null) {
				if(!visited[tmp.data]) {
					queue.enqueue(tmp.data);
					visited[tmp.data] = true;
				}
				tmp = tmp.nextNode;
			}
		}
		return result;
	}
	public static String bFSTraversalArrayList(Graph g, int source) {
		String result = "";
		int num_of_vertices = g.vertices;
		Queue<Integer> queue = new Queue<Integer>(num_of_vertices);
		boolean[] visited = new boolean[num_of_vertices];
		queue.enqueue(source);
		visited[source] = true;
		while(!queue.isEmpty()) {
			int currentNode = queue.dequeue();
			result += String.valueOf(currentNode)+ " ";
			Iterator<Integer> it = g.arrayList.get(currentNode).listIterator();
			while(it.hasNext()) {
				int tmp = it.next();
				if(!visited[tmp]) {
					queue.enqueue(tmp);
					visited[tmp] = true;
				}
			}	
		}
		return result;
	}
	public static void main(String[] args) {
		 Graph g = new Graph(7);
		 g.addEdge(0,1);
			g.addEdge(0,4);
			g.addEdge(1,2);
			g.addEdge(1,3);
			g.addEdge(3,6);
			g.addEdge(4,5);
			g.addEdge(5,6);
		System.out.println(BFSTraversal.bFSTraversal(g, 0));
		System.out.println("===============================");
		System.out.println(BFSTraversal.bFSTraversalArrayList(g, 0));
	}

}
