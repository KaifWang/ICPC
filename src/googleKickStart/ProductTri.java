package googleKickStart;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class ProductTri {

	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(new File("A-small-practice.in"));
			PrintWriter pw = new PrintWriter("product.txt");
			int numT = sc.nextInt();
			for(int i = 0; i < numT; i ++) {
				int size = sc.nextInt();
				int[] arr = new int[size];
				for(int j = 0 ; j < size; j ++) {
					arr[j] = sc.nextInt();
				}
				pw.println("Case #" + (i+1) + ": " + countTri(arr));
			}
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static int countTri(int[] arr) {
		Arrays.sort(arr);
		int count = 0;
		for(int i = 0; i < arr.length; i ++) {
			for(int j = i + 1; j < arr.length; j ++) {
				int p = arr[i] * arr[j];
				int mid = bs(p, arr, j + 1);
				if(mid >= 0) {
					count ++;
					for(int m = mid - 1; m >= j + 1; m --) {
						if(p == arr[m]) {
							count ++;
						}
						else {
							break;
						}
					}
					for(int m = mid + 1; m < arr.length; m ++) {
						if(p == arr[m]) {
							count ++;
						}
						else {
							break;
						}
					}
				}
			}
		}
		return count;
	}
	
	public static int bs(int num, int[] arr, int k) {
		int start = k;
		int end = arr.length - 1;
		while(start <= end) {
			int mid = (start + end) / 2;
			if(num == arr[mid]) {
				return mid;
			}
			else if(num > arr[mid]) {
				start = mid + 1;
			}
			else {
				end = mid - 1;
			}
		}
		return -1;
	}
}
