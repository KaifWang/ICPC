package aggressiveCowsDynamicProgrammingWrong;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(new File("aggressiveCows.txt"));
			int numT = Integer.parseInt(sc.nextLine());
			for(int i = 0; i < numT; i ++) {
				int s = sc.nextInt();
				int[] stalls = new int[s];
				int numCows = sc.nextInt();
				for(int j = 0; j < s; j ++) {
					stalls[j] = sc.nextInt();
				}
				System.out.println(aggressiveCows(numCows, stalls));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static int aggressiveCows(int numCows, int[] s) {
		int[][] v = new int[s.length + 1][numCows + 1]; //up to ith stall with nth cow
		int[][] lastCow = new int[s.length + 1][numCows + 1];
		for(int i = 0; i <= s.length; i ++) {
			for(int n = 0; n <= numCows; n ++) {
				if(i == 0 || i == 1 || n == 0 || n == 1 || n > i) {
					v[i][n] = 0;
					if(n == 1) {
						lastCow[i][n] = s[0];
					}
					else {
						lastCow[i][n] = 0;
					}
				}
				else if(n == 2) {
					lastCow[i][n] = s[i - 1];
					v[i][n] = s[i - 1] - s[0];
				}
				
				else if(s[i - 1] - lastCow[i - 1][n - 1] <= v[i - 1][n - 1]) {
					v[i][n] = Integer.max(s[i - 1] - lastCow[i - 1][n - 1], v[i - 1][n]);
					if(v[i][n] ==  v[i - 1][n]) {
						lastCow[i][n] = lastCow[i-1][n];
					}
					else {
						lastCow[i][n] = s[i - 1];
					}
				}
				else {
					v[i][n] = v[i - 1][n - 1];
					lastCow[i][n] = s[i - 1];
				}
			}
		}
		return v[s.length][numCows];
	}
}
