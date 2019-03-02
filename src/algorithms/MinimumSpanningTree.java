package algorithms;

import java.util.ArrayList;

public class MinimumSpanningTree {

	public static void main(String[] args) {

		}
	
	static class Edge{
		int s;
		int t;
		int w;
		Edge(int s, int t, int w){
			this.s = s;
			this.t = t;
			this.w = w;
		}
	}
		
	static class Ver{
		int p;
		int r;
		Ver(int p, int r){
			this.p = p;
			this.r = r;
		}
	}
	
	static int findRoot(Ver[] vSet, int v) {
		if(vSet[v].p == v) {
			return v;
		}
		else {
			v = vSet[v].p;
			return findRoot(vSet, v);
		}
	}
	
	static void combine(Ver[] vSet, int v1, int v2) {
		int v1Root = findRoot(vSet, v1);
		int v2Root = findRoot(vSet, v2);
		
		if(vSet[v1Root].r > vSet[v2Root].r) {
			vSet[v2Root].p = v1Root;
		}
		else if(vSet[v1Root].r < vSet[v2Root].r) {
			vSet[v1Root].p = v2Root;
		}
		else {
			vSet[v1Root].p = v2Root;
			vSet[v2Root].r ++;
		}
	}
	
	static int[][] mst(int[][] g){
		int[][] mst = new int[g.length][g.length];
		ArrayList<Edge> mstEdges = new ArrayList<Edge>();
		Ver[] vSet = new Ver[g.length];
		ArrayList<Edge> edges = new ArrayList<Edge>();
		for(int i = 0; i < g.length; i ++) {
			for(int j = 0; j < g.length; j ++) {
				if(g[i][j] != 0) {
					edges.add(new Edge(i, j, g[i][j]));
				}
			}
		}
		edges.sort((e1, e2) -> e1.w - e2.w);
		
		// Initialize vertices
		for(int i = 0; i < g.length; i ++) {
			vSet[i] = new Ver(i, 0);
		}
		
		// Find mstEdges
		int count = 0;
		int edgeIndex = 0;
		while(edgeIndex < edges.size() && count < g.length - 1) {
			Edge edge = edges.get(edgeIndex++);
			int sRoot = findRoot(vSet, edge.s);
			int tRoot = findRoot(vSet, edge.t);
			
			if(sRoot != tRoot) {
				mstEdges.add(edge);
				combine(vSet, sRoot, tRoot);
				count ++;
			}
		}
		
		// Now mstEdges stores all edges in the mst, note if count != g.length -1, the mst is not complete
		//Convert back to graph
		for(Edge e : mstEdges) {
			mst[e.s][e.t] = e.w;
		}
		return mst;
	}
	
}

