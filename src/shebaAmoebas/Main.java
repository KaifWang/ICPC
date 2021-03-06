package shebaAmoebas;
import java.util.Scanner;
class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			int count = 0;
			int m = sc.nextInt();
			int n = sc.nextInt();
			char[][] array = new char[m][n];
			boolean[][] visited = new boolean[m][n];
			sc.nextLine();
			for(int i = 0; i < array.length; i ++) {
				String s = sc.nextLine();
				for(int j = 0; j < array[i].length; j ++) {
					array[i][j] = s.charAt(j);
					visited[i][j] = false;
				}
			}
			for(int i = 0; i < array.length; i ++) {
				for(int j = 0; j < array[i].length; j ++) {
					if(array[i][j] == '#' && visited[i][j] == false) {
						Main.recursiveCount(i, j, array, visited);
						count ++;
					}
				}
			}
			System.out.println(count);
		}
		sc.close();
	}
	
	public static void recursiveCount(int i, int j, char[][] array, boolean[][] visited) {
		visited[i][j] = true;
		for(int m = i - 1; m < i + 2; m ++) {
			for(int n = j - 1; n < j + 2; n ++) {
				if(m >= 0 && n >= 0 && m < array.length && n < array[0].length && visited[m][n] == false && array[m][n] == '#') {
					recursiveCount(m, n, array, visited);
				}
			}
		}
	}
}

