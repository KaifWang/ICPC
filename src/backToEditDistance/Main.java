package backToEditDistance;

import java.util.Scanner;

class Main {

	public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int numT = sc.nextInt();
			for(int i = 0; i < numT; i ++) {
				int size = sc.nextInt();
				if(size != 0) {
					int[] a = new int[size];
					int[] b = new int[size];
					for(int j = 0   ; j < size; j ++) {
						a[j] = sc.nextInt();
					}
					for(int j = 0 ; j < size; j ++) {
						b[j] = sc.nextInt();
					}
					System.out.println("Case " + (i + 1) + ": " + backToEditDistance(a, b));
				}
			}
		
	}
	
	public static int backToEditDistance(int[] a, int[] b) {
		int[][] v = new int[a.length + 1][b.length + 1];
		int[] v1 = new int[a.length + 1];
		int[] v2 = new int[a.length + 1];
		int[] v3 = new int[a.length + 1];
		int[] v4 = new int[a.length + 1];
		for(int i = 0; i <= a.length; i ++) {
			for(int j = 0; j <= b.length; j ++) {
				if(i == 0) {
					v[i][j] = j;
					v1[j] = j;
				}
				else if(j == 0) {
					v[i][j] = i;
					v2[i] = i;
				}
				else {
					if(a[i - 1] == b[j - 1]) {
						v[i][j] = v[i - 1][j - 1];
					}
					else {
						v[i][j] = 1 + Math.min(v[i - 1][j], v[i][j - 1]);
					}
				}
			}
		}
		return v[a.length][b.length];
	}
}
