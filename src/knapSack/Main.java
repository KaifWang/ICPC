package knapSack;


import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
				int capacity = sc.nextInt();
				int n = sc.nextInt();
				int[] val = new int[n];
				int[] wt = new int[n];
				for(int i = 0; i < n; i ++) {
					wt[i] = sc.nextInt();
					val[i] = sc.nextInt();
				}
				System.out.println(knapSack(capacity, val, wt));
		}
	
	public static int knapSack(int capacity, int[] val, int[] wt) {
		int[][] k = new int[val.length + 1][capacity + 1];
		for(int i = 0; i <= val.length; i ++) {
			for(int w = 0; w <= capacity; w ++) {
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
		return k[val.length][capacity];
	}

}
