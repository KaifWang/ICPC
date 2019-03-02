package jackOfAllTrades;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;


class Main {

	
	public static void main(String[] args) {
		try {
			int tc = 0;
			String tradeInWant = "";
			String tradeOutWant = "";
			Scanner sc = new Scanner(new File("C:\\Users\\kai97\\eclipse-workspace\\ICPC\\src\\jackOfAllTrades\\input.txt"));
			tc = Integer.parseInt(sc.nextLine());
			System.out.println(tc);
			while(sc.hasNext()) {
				for(int i = 0; i < tc; i ++) {
					int numLines = 0;
					String s = sc.nextLine();
					System.out.println(s);
					String[] set = s.trim().split("\\s");
					for(String k : set) {
						System.out.println("element  " + k);
					}
					LinkedList<Trade> allTrades = new LinkedList<Trade>();
					PrintWriter pw = new PrintWriter("output5.txt");
					pw.println("start");
					tradeInWant = set[0];
					tradeOutWant = set[1];
					numLines = Integer.parseInt(set[2]);
					for(int j = 0; j < numLines; j ++) {
						String s1 = sc.nextLine();
						System.out.println(s1);
						String[] set1 = s1.trim().split("\\s");
						for(String k : set1) {
							System.out.println(k);
						}
						int tradeIn = Integer.parseInt(set1[0]);
						String st1 = set1[1];
						int tradeOut =Integer.parseInt(set1[2]);
						String st2 = set1[3];
						allTrades.add(new Trade(st1, st2, tradeOut/tradeIn)); 
						for(int m = 0; m < allTrades.size(); m ++) {
							for(int n = 0; n < allTrades.size(); n ++)
							{
								if(allTrades.get(m).getTradeIn().equals(allTrades.get(n).getTradeOut())) {
									allTrades.add(new Trade(allTrades.get(n).getTradeIn(), allTrades.get(m).getTradeOut(), allTrades.get(m).getRatio() * allTrades.get(n).getRatio()));
								}
							}
						}
						/*for(Trade t : allTrades) {
							for (Trade tOthers : allTrades) {
								if(t.getTradeIn().equals(tOthers.getTradeOut()))
									allTrades.add(new Trade(tOthers.getTradeIn(), t.getTradeOut(), t.getRatio() * tOthers.getRatio()));
							}
						}*/
					}
					double min = Integer.MAX_VALUE;
					int numWays = 0;
					for(Trade t : allTrades) {
						if(t.getTradeIn().equals(tradeInWant) && t.getTradeOut().equals(tradeOutWant) && t.getRatio() < min) {
							min = t.getRatio();
						}
					}
					for(Trade t : allTrades) {
						if(t.getRatio() == min)
							numWays ++;
					}
					pw.println("case " + i + ": " + min + " " + numWays);
					pw.close();
				}
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			System.out.println("Output problem");
		}
	}
}
