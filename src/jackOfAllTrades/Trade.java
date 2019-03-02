package jackOfAllTrades;

public class Trade {

	private String tradeIn;
	private String tradeOut;
	private double ratio;
	
	public Trade(String tradeIn, String tradeOut, double ratio) {
		this.tradeIn = tradeIn;
		this.tradeOut = tradeOut;
		this.ratio = ratio;
	}
	
	public String getTradeIn() {
		return tradeIn;
	}
	
	public String getTradeOut() {
		return tradeOut;
	}
	
	public double getRatio() {
		return ratio;
	}
	
}
