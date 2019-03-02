package algorithms;

public class KnapSack {

	public static int knapSack(int capacity, int[] val, int[] wt) {
		int[][] k = new int[capacity + 1][val.length + 1];
		for(int i = 0; i < val.length; i ++) {
			for(int w = 0; w < capacity; w ++) {
				if(i == 0 || w == 0) {
					k[i][w] = 0;
				}
				else if(wt[i - 1] <= w) {
					k[i][w] = Integer.max(k[i - 1][w], k[i - 1][w - wt[i - 1]] + val[i - 1]);
				}
				else {
					k[i][w] = k[i - 1][w];
				}
			}
		}
		return k[capacity][val.length];
	}
}
