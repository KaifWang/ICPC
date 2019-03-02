package algorithms;

public class BinarySearch {

	public int binarySearch(int[] arr, int x) {
		int start = arr[0];
		int end = arr[arr.length - 1];
		while(start <= end) {
			int mid = (start + end) / 2;
			if(arr[mid] == x) {
				return mid;
			}
			else if(arr[mid] > x) {
				end = mid - 1;
			}
			else {
				start = mid + 1;
			}
		}
		return -1;
	}
}
