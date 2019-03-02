package googleKickStart;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class ProblemA {
	public static void main(String args[]) {
		try {
			Scanner sc = new Scanner(new File("C:\\Users\\kai97\\Downloads\\A-large.in"));
			PrintWriter pw = new PrintWriter("outputK.txt");
			int t = Integer.parseInt(sc.nextLine());
			for(int i = 0; i < t; i ++) {
				int count = 0;
				int l = Integer.parseInt(sc.nextLine());
				String a = sc.nextLine();
				String b = sc.nextLine();
				LinkedList<String> subA = new LinkedList<String>();
				LinkedList<String> subB = new LinkedList<String>();
				for(int m = 0; m < l; m ++) {
					for(int n = 0; n <= m; n ++) {
						subA.add(a.substring(n, m + 1));
						subB.add(b.substring(n, m + 1));
					}
				}
				for(String As : subA) {
					for(String Bs : subB) {
						if(As.length() == Bs.length()) {
							int[] ca = new int[26];
							int[] cb = new int[26];
							boolean isRight = true;
							
							for(int k = 0; k < As.length(); k ++) {
								ca[As.charAt(k) - 'A']++;
								cb[Bs.charAt(k) - 'A']++;
							}
							for(int k = 0; k < ca.length; k++) {
								if(ca[k] != cb[k]) {
									isRight = false;
								}
							}
							if(isRight) {
								count ++;
								break;
							}
						}
					}
				}
				pw.println("case #" + (i + 1) + ": " +  count);
			}
			pw.close();
		} catch (FileNotFoundException e) {
			System.out.println("not found output");
		}

	}
}
