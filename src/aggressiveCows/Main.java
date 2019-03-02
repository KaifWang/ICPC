package aggressiveCows;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int numT = Integer.parseInt(sc.nextLine());
			for(int i = 0; i < numT; i ++) {
				int s = sc.nextInt();
				int[] stalls = new int[s];
				int numCows = sc.nextInt();
				for(int j = 0; j < s; j ++) {
					stalls[j] = sc.nextInt();
				}
				Arrays.sort(stalls);
				System.out.println(binarySearch(stalls, numCows));
			}
	}
	public static boolean isDistanceValid(int d, int numCow, int[] stalls) {
		int fitCows = 1;
		int prevCow = stalls[0];
		for(int i = 0; i < stalls.length; i ++) {
			if(stalls[i] - prevCow >= d) {
				prevCow = stalls[i];
				fitCows ++;
			}
			if(fitCows == numCow){
				return true;
			}
		}
		return false;
	}
	public static int binarySearch(int stalls[], int numCow) {
		int start = 0;
		int end = stalls[stalls.length - 1] - stalls[0];
		int maxDistance = 0;
		while(start <= end) {
			int mid = (start + end) / 2;
			if(isDistanceValid(mid, numCow, stalls)) {
				start = mid + 1;
				maxDistance = mid;
			}
			else {
				end = mid - 1;
			}
		}
		return maxDistance;
	}

}
