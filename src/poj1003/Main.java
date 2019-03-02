	package poj1003;
	
	import java.util.Scanner;
	
	public class Main {
	
	
	
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			float next = sc.nextFloat();
			while (next != 0.00) {
				System.out.println(countCards(next));
				next = sc.nextFloat();
			}
	
		}
		
		static String countCards(float length) {
			int numCards = 0;
			float curLength = 0;
			while(curLength < length) {
				curLength = 0;
				numCards ++;
				for(int i = 0; i < numCards; i ++) {
					curLength += 1.0/(i+2);
				}
			}
			return numCards + "  card (s)";
			
		}
	
	}
