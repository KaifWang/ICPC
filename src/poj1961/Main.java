package poj1961;

import java.util.Scanner;

public class Main {


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int next = sc.nextInt();
		int caseNum = 0;
		while(next != 0) {
			caseNum++;
			String s = sc.next();
			System.out.println(solution(s, caseNum, next));
			next = sc.nextInt();
		}

	}

	static String solution( String s, int caseNum, int length) {
		System.out.println("Test Case #" + caseNum);
		for(int i = 0; i < length; i ++) {
			for(int j = 0; j < i; j ++) {
				while(s.charAt(i) == s.charAt(j)) {
					
				}
			}
		}
		return null;
		
	}
}
