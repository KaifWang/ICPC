package algorithms;

import java.util.LinkedList;
import java.util.Queue;

public class MaxFlow {

	public static int maxFlow(int[][] graph, int s, int t) {
		int numVer = graph.length;
		int[][] rGraph = new int[numVer][numVer];
		for(int i = 0; i < numVer; i++) {
			for(int j = 0; j < numVer; j ++) {
				rGraph[i][j] = graph[i][j];
			}
		}

		int[] parent = new int[numVer];
		int flow = 0;
		
		while(bfs(rGraph, s, t, parent)) {
			int pathFlow = Integer.MAX_VALUE;
			for(int i = t; i != s; i = parent[i]) {
				int prev = parent[i];
				pathFlow = Integer.min(rGraph[prev][i], pathFlow);
			}
			for(int i = t; i != s; i = parent[i]) {
				int prev = parent[i];
				rGraph[prev][i] -= pathFlow;
				rGraph[i][prev] += pathFlow; //Allow reverse
			}
			flow += pathFlow;
		}
		return flow;
	}
	
	private static boolean bfs(int[][] graph, int s, int t, int[] parent) {
		int numVer = graph.length;
		boolean[] visited = new boolean[numVer];
		for(int i = 0; i < numVer; i ++) {
			visited[i] = false;
		}
		visited[s] = true;
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(s);
		while(!q.isEmpty()) {
			int temp = q.poll();
			visited[temp] = true;
			for(int i = 0; i < numVer; i ++) {
				if(graph[temp][i] > 0 && !visited[i]) {
					q.add(i);
					parent[i] = temp;
				}
			}
		}
		return visited[t] == true;
	}
	
}
