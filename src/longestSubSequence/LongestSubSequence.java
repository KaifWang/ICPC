package longestSubSequence;

import java.util.Scanner;

public class LongestSubSequence {

	public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			while(sc.hasNextLine()) {
				String a = sc.nextLine();
				String b = sc.nextLine();
				System.out.println(longestCommonSubsequence(a, b));
			}
	}
	
	public static int longestCommonSubsequence(String a, String b) {
		int[][] l = new int[a.length() + 1][b.length() + 1];
		for(int i = 0; i <= a.length(); i ++) {
			for(int j = 0; j <= b.length(); j ++) {
				if(i == 0 || j == 0) {
					l[i][j] = 0;
				}
				else if(a.charAt(i - 1) == b.charAt(j - 1)) {
					l[i][j] = l[i - 1][j - 1] + 1;
				}
				else {
					l[i][j] = Integer.max(l[i-1][j], l[i][j-1]);
				}
			}
		}
		return l[a.length()][b.length()];
	}

}
