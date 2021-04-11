package com.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class MotherVertex {

	public static void main(String[] args) {
		 Graph g = new Graph(7);
		 g.addEdge(6,0);
		 g.addEdge(0,1);
			g.addEdge(0,4);
			g.addEdge(1,2);
			g.addEdge(1,3);
		//	g.addEdge(3,6);
			g.addEdge(4,5);
			g.printGraph();
		System.out.println(findMotherVertx(g));

	}

	private static int findMotherVertx(Graph g) {
		boolean visited[] = new boolean[g.vertices];
		int lastV = 0;
		for(int i=0; i<g.vertices; i++) {
			if(!visited[i]) {
				DFS(i,visited,g);
				lastV = i;
			}
		}
		System.out.println(lastV);
		System.out.println(Arrays.toString(visited));
		Arrays.fill(visited, false);
		DFS(lastV, visited, g);
		System.out.println(Arrays.toString(visited));
		for(int i=0; i<g.vertices; i++) {
			if(!visited[i]) {
				return -1;
			}
		}
		return lastV;
	}

	private static void DFS(int i, boolean[] visited, Graph g) {
		visited[i] = true;
		ArrayList list = null;
		if(g.arrayList.get(i) !=null)
			list = g.arrayList.get(i);
		Iterator<Integer> itr = list.iterator();
		while(itr.hasNext()) {
			int tmp = itr.next();
			if(!visited[tmp])
				DFS(tmp, visited, g);
		}
	}

}
