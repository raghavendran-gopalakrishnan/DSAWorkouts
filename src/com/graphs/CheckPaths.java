package com.graphs;

import java.util.ArrayList;
import java.util.Iterator;

import com.doublyLinkedList.DoublyLinkedList;

public class CheckPaths {

	public static void main(String[] args) {
		Graph g1 = new Graph(9);
		g1.addEdge(0,2);
		g1.addEdge(0,5);
		g1.addEdge(2,3);
		g1.addEdge(2,4);
		g1.addEdge(5,3);
		g1.addEdge(5,6);
		g1.addEdge(3,6);
		g1.addEdge(6,7);
		g1.addEdge(6,8);
		g1.addEdge(6,4);
		g1.addEdge(7,8);
		g1.printGraph();
		boolean visited[] = new boolean[g1.vertices];
		System.out.println("Path exists: " + checkPath(g1, 0, 7,visited));
		System.out.println("Path exists: " + checkPath1(g1, 0, 7));
		System.out.println();
		Graph g2 = new Graph(4);
		g2.addEdge(0,1);
		g2.addEdge(1,2);
		g2.addEdge(1,3);
		g2.addEdge(2,3);
		boolean visited1[] = new boolean[g2.vertices];
		g2.printGraph();
		System.out.println("Path exists: " + checkPath(g2, 3, 0, visited1));
		System.out.println("Path exists: " + checkPath1(g2, 0, 7));
	}

	public static boolean checkPath(Graph g, int source, int destination,boolean[] visited) {
		visited[source] = true;
		ArrayList<Integer> list = null;
		if (g.arrayList.get(source)!=null)
			list = g.arrayList.get(source);
		Iterator<Integer> itr = list.listIterator();
		while(itr.hasNext()) {
			int temp = itr.next();
			if(!visited[temp]) {
				if(destination == temp) {
					return true;
				}else {
					return checkPath(g, temp, destination, visited);
				}
			}
		}
		return false;
	}

	public static boolean checkPath1(Graph g, int source, int destination) {
		boolean[] visited = new boolean[g.vertices];
		return DFS(g,source,destination,visited);
	}

	private static boolean DFS(Graph g, int source, int destination, boolean[] visited) {
		visited[source] = true;
		DoublyLinkedList<Integer>.Node node = null;
		if(g.adjacencyList[source] != null)
			node = g.adjacencyList[source].headNode;
		while(node != null) {
			int tmp = node.data;
			if(!visited[tmp]) {
				if(tmp == destination) {
					return true;
				} else {
					return DFS(g, tmp, destination, visited);
				}
			}
			node = node.nextNode;	
		}
		return false;
	}

}
