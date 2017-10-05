package com.rohitk.questionaire;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopologicalSort {
	int v;
	List<Integer>[] adjacencyList;

	public TopologicalSort(int v) {
		this.v = v;
		adjacencyList = new ArrayList[v];
		for (int i=0; i<v; i++) {
			adjacencyList[i] = new ArrayList<>();
		}
	}

	public void addEdge(int u, int v) {
		adjacencyList[u].add(v);
	}

	public List<Integer> topologicalSort() {

		int[] indegree = new int[v];
		/*
		 * Indegree of node is computed from the adjacency list representation.
		 */
		for (int i = 0; i < v; i++) {
			List<Integer> adj = adjacencyList[i];
			for (int node : adj)
				indegree[node]++;
		}
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < v; i++) {
			if (indegree[i] == 0)
				queue.add(i);
		}
		List<Integer> result = new ArrayList<>();
		while (!queue.isEmpty()) {
			int n = queue.poll();
			result.add(n);
			List<Integer> nodes = adjacencyList[n];
			for (int val : nodes) {
				if (--indegree[val] == 0)
					queue.add(val);
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		TopologicalSort topologicalSort = new TopologicalSort(9);
		List<Integer> result = topologicalSort.topologicalSort();
		for (int val : result) 
			System.out.print(val + " ");
		
	}
}
