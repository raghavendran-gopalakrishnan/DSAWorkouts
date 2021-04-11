/**
 * 
 */
package com.graphs;

import java.util.ArrayList;
import java.util.Iterator;

import com.doublyLinkedList.DoublyLinkedList;
import com.stackAndQueue.Stack;

/**
 * @author ragg
 *
 */
public class DFSTraversal {

	public static String dfsTraversal(Graph g, int source) {
        String result = "";
        int num_of_vertices = g.vertices;

        //Boolean Array to hold the history of visited nodes (by default-false)
        //Make a node visited whenever you push it into stack
        boolean[] visited = new boolean[num_of_vertices];

        //Create Stack(Implemented in previous lesson) for Depth First Traversal and Push source in it
        Stack<Integer> stack = new Stack<Integer>(num_of_vertices);

        stack.push(source);
        visited[source] = true;
        //Traverse while stack is not empty
        while (!stack.isEmpty()) {

            //Pop a vertex/node from stack and add it to the result
            int current_node = stack.pop();
           // if(visited[current_node])
            	result += String.valueOf(current_node);
            
            //Get adjacent vertices to the current_node from the array,
            //and if they are not already visited then push them in the stack
            DoublyLinkedList<Integer>.Node temp = null;
            if(g.adjacencyList[current_node] !=null)
                temp = g.adjacencyList[current_node].headNode;
            System.out.println("Processing node "+current_node);
            while (temp != null) {
                if (!visited[temp.data]) {
                    stack.push(temp.data);
                    visited[temp.data] = true;
                }
                System.out.print("   "+temp.data);
                temp = temp.nextNode;
            }
            System.out.println();
        }//end of while
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
			//g.addEdge(5,6);
		//System.out.println(dfsTraversal(g, 0));
		boolean[] visited = new boolean[7];
		DFS(0, visited, g);
		System.out.println();
		visited = new boolean[7];
		DFSal(0, visited, g);
	}
	
	public static void DFS(int V, boolean[] visited, Graph g) {
		visited[V] = true;
		System.out.print(V);
		DoublyLinkedList<Integer>.Node temp = null;
		if(g.adjacencyList[V] != null)
			temp = g.adjacencyList[V].headNode;
		
		while(temp != null) {
			if(!visited[temp.data])
				DFS(temp.data, visited, g);
			temp = temp.nextNode;
		}
	}
	
	public static void DFSal(int V, boolean[] visited, Graph g) {
		visited[V] = true;
		System.out.print(V);
		ArrayList list = null;
		if(g.arrayList.get(V) != null)
			list = g.arrayList.get(V);
		Iterator<Integer> it = list.listIterator();
		while(it.hasNext()) {
			int tmp = it.next();
			if(!visited[tmp])
				DFSal(tmp, visited, g);
		}
	}

}
