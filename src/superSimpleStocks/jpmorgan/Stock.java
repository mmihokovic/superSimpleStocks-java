package superSimpleStocks.jpmorgan;

public class Stock {

	private String simbol;
	private StockType type;
	private double lastDividend;
	private double fixedDividend;
	private double parValue;
	
	public Stock(String simbol, StockType type, double lastDividend, double fixedDividend, double parValue) {
		super();
		this.simbol = simbol;
		this.type = type;
		this.lastDividend = lastDividend;
		this.fixedDividend = fixedDividend;
		this.parValue = parValue;
	}
	
	public String getSimbol() {
		return simbol;
	}
	public void setSimbol(String simbol) {
		this.simbol = simbol;
	}
	public StockType getType() {
		return type;
	}
	public void setType(StockType type) {
		this.type = type;
	}
	public double getLastDividend() {
		return lastDividend;
	}
	public void setLastDividend(double lastDividend) {
		this.lastDividend = lastDividend;
	}
	public double getFixedDividend() {
		return fixedDividend;
	}
	public void setFixedDividend(double fixedDividend) {
		this.fixedDividend = fixedDividend;
	}
	public double getParValue() {
		return parValue;
	}
	public void setParValue(double parValue) {
		this.parValue = parValue;
	}

}
