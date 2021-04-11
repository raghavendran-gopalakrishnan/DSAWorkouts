/**
 * 
 */
package com.graphs;
import java.util.ArrayList;

import com.doublyLinkedList.DoublyLinkedList;
/**
 * @author ragg
 *
 */
public class Graph {
	int vertices;
	DoublyLinkedList<Integer> adjacencyList[];
	ArrayList<ArrayList<Integer>> arrayList;
	public Graph(int size) {
		this.vertices = size;
		this.adjacencyList = new DoublyLinkedList[size];
		for(int i=0;i<vertices;i++) {
			adjacencyList[i] = new DoublyLinkedList<Integer>();
		}
		arrayList = new ArrayList<ArrayList<Integer>>(size);
		for(int i=0;i<vertices;i++) {
			arrayList.add(new ArrayList<Integer>());
		}
	}
	
	public void addEdge(int source, int destination) {
		this.adjacencyList[source].insertAtEnd(destination);
		//for undirected graphs
		//this.adjacencyList[destination].insertAtEnd(source);
		this.arrayList.get(source).add(destination);
		//this.arrayList.get(destination).add(source);
	}
	
	public void printGraph() {
		for(int i=0;i<vertices;i++) {
			if(adjacencyList[i] != null) {
				DoublyLinkedList<Integer>.Node temp = adjacencyList[i].headNode;
				System.out.print("|"+i+"| ======");
				while(temp!=null) {
					System.out.print(" ["+temp.data+"] -> ");
					temp = temp.nextNode;
				}
				System.out.println(" null");
			} else {
				System.out.print("|"+i+"| -> null");
			}
		}
		System.out.println("===============================");
		for(int i=0;i<vertices;i++) {
			if(arrayList.get(i) != null) {
				System.out.print("|"+i+"| ======");
				for(int j : arrayList.get(i)) {
					System.out.print(" ["+j+"] ->");
				}
				System.out.println(" null");
			} else {
				System.out.print("|"+i+"| -> null");
			}
		}
	}
	
	public static void main(String[] args) {
		Graph graph = new Graph(4);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 3);
		graph.addEdge(2, 3);
		graph.printGraph();
	}

}
