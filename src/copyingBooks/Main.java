package copyingBooks;

import java.util.Scanner;

public class Main {

	public Main() {
		Scanner sc = new Scanner(System.in);
		int numT = sc.nextInt();
		for(int i = 0; i < numT; i ++) {
			int numB = sc.nextInt();
			int numS = sc.nextInt();
			int[] p = new int[numB];
			for(int j = 0; j < numB; j ++) {
				p[j] = sc.nextInt();
			}
			System.out.println(divide(numS, p));
		}
	}
	
	public String divide( int numS, int[] p) {
		int total = 0;
		for(int i = 0; i < p.length; i ++) {
			total += p[i];
		}
		int average = total/numS;
		StringBuilder sb = new StringBuilder();
		int i = 0;
		int subT = 0;
		while(i < p.length) {
			while( i < p.length && subT + p[i]< average) {
				subT += p[i];
				i ++;
				sb.append(p[i]);
				sb.append(' ');
			}
			if(i < p.length && ((average - subT) > (subT + p[i] - average))){
				sb.append(p[i]);
				sb.append(' ');
				i++;
			}
			sb.append('/');
			sb.append(' ');
		}
		sb.deleteCharAt((p.length + numS) * 2);
		return sb.toString();
	}

}
