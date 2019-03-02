package algorithms;


public class Dijkstra {

	public static void main(String[] args) {
		int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0}, 
            {4, 0, 8, 0, 0, 0, 0, 11, 0}, 
            {0, 8, 0, 7, 0, 4, 0, 0, 2}, 
            {0, 0, 7, 0, 9, 14, 0, 0, 0}, 
            {0, 0, 0, 9, 0, 10, 0, 0, 0}, 
            {0, 0, 4, 14, 10, 0, 2, 0, 0}, 
            {0, 0, 0, 0, 0, 2, 0, 1, 6}, 
            {8, 11, 0, 0, 0, 0, 1, 0, 7}, 
            {0, 0, 2, 0, 0, 0, 6, 7, 0}
		};
        int[] dist = dij(graph, 0);
        for(int i = 0; i < graph.length; i ++) {
        	System.out.println("From 0 to " + i + "   :   " + dist[i]);
        }
	}

	/*
	 * General Version of Dijkstra
	 * Input a graph and a source
	 * output shortest distance to all vertices
	 */
	static int[] dij(int[][] g, int s) {
		
		int[] dist = new int[g.length];
		boolean[] isVisited = new boolean[g.length];
		
		for(int i = 0; i < g.length; i ++) {
			dist[i] = Integer.MAX_VALUE;
			isVisited[i] = false;
		}
		
		dist[s] = 0;
		
		for(int i = 0; i < g.length; i ++) {
			
			int min = Integer.MAX_VALUE;
			int minIndex = 0;
			for(int j = 0; j < g.length; j ++) {
				if(!isVisited[j] && dist[j] < min) {
					min = dist[j];
					minIndex = j;
				}
			}
			isVisited[minIndex] = true;
			
			for(int j = 0; j < g.length; j ++) {
				if(g[minIndex][j] != 0 && !isVisited[j] && g[minIndex][j] + dist[minIndex] < dist[j]) {
					dist[j] = g[minIndex][j] + dist[minIndex];
				}
			}
		}
		return dist;
	}
}
