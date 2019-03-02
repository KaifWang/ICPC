package internetBandwidth;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
class Main {

	public static void main(String[] args) {
			Scanner s = new Scanner(System.in);
			int netNum = 0;
			int size = Integer.parseInt(s.nextLine());
				while(size != 0) {
					netNum++;
					int[][] graph = new int[size + 1][size + 1];
					int source = s.nextInt();
					int t = s.nextInt();
					int num = s.nextInt();
					for(int i = 0; i < num; i ++) {
						int a = s.nextInt();
						int b = s.nextInt();
						int weight = s.nextInt();
						graph[a][b] += weight;
						graph[b][a] += weight;
					}
					size = s.nextInt();
				System.out.println("Network " + netNum);
				System.out.println("The bandwidth is " + maxFlow(graph, source, t) + ".");
				System.out.println();
				}
	}
	
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
				pathFlow = Math.min(rGraph[prev][i], pathFlow);
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
			for(int i = 0; i < numVer; i ++) {
				if(graph[temp][i] > 0 && !visited[i]) {
					q.add(i);
					parent[i] = temp;
					visited[i] = true;
				}
			}
		}
		return visited[t];
	}

}
