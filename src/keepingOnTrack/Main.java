package keepingOnTrack;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int size = sc.nextInt();
			boolean[][] graph = new boolean[size + 1][size + 1];
			for(int i = 0; i < size; i ++) {
				int m = sc.nextInt();
				int n = sc.nextInt();
				graph[m][n] = true;
				graph[n][m] = true;
			}
		System.out.println(Main.destory(graph));
		System.out.println(Main.add(graph));
		}
	}

	public static boolean bfs(int start, int end, boolean[][] graph) {
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[] visited = new boolean[graph.length];
		visited[start] = true;
		q.add(start);
		while(q.size() != 0) {
			int u = q.poll();
			for(int i = 0; i < graph.length; i ++) {
				if((!visited[i]) && graph[u][i]) {
					q.add(i);
					visited[i] = true;
				}
			}
		}
		return visited[end];
	}
	
	public static int countDisconnection(int criticalJunction, boolean[][] graph) {
		int count = 0;
		for(int i = 0; i < graph.length; i ++) {
			graph[criticalJunction][i] = false;
			graph[i][criticalJunction] = false;
		}
		for(int i = 0; i < graph.length; i ++) {
			if( i != criticalJunction) {
				for(int j = i + 1; j < graph.length; j ++) {
					if(j != criticalJunction && !bfs(i, j, graph))
						count ++;
				}
			}
		}
		//System.out.println("point: " + criticalJunction + " disconnection: " + count);
		return count;
	}
	
	public static int destory(boolean[][] graph) {
		int[] numDisconnection = new int[graph.length];
		int max = 0;
		for(int i = 0; i < graph.length; i ++) {
			boolean[][] tempGraph = new boolean[graph.length][graph.length];
			for(int m = 0; m < graph.length; m ++) {
				for(int n = 0; n < graph.length; n ++) {
					if(graph[m][n])
						tempGraph[m][n] = true;
				}
			}
			numDisconnection[i] = countDisconnection(i, tempGraph);
			if(numDisconnection[i] > max)
				max = numDisconnection[i];
		}
		return max;
	}
	
	public static int add(boolean[][] graph) {
		int[][] numDisconnection = new int[graph.length][graph.length];
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < graph.length; i ++) {
			for(int j = i + 1; j < graph.length; j ++) {
				if(!graph[i][j]) {
					boolean[][] tempGraph = new boolean[graph.length][graph.length];
					for(int m = 0; m < graph.length; m ++) {
						for(int n = 0; n < graph.length; n ++) {
							if(graph[m][n])
								tempGraph[m][n] = true;
						}
					}
					tempGraph[i][j] = true;
					tempGraph[j][i] = true;
					numDisconnection[i][j] = Main.destory(tempGraph);
					if(numDisconnection[i][j] < min)
						min = numDisconnection[i][j];
				}
			}
		}
		return min;
	}
	
}
