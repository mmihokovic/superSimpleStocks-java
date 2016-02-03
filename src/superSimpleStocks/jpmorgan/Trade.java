package superSimpleStocks.jpmorgan;

import java.util.Date;

public class Trade {

	private Stock stock;
	private Date tradeTime;
	private double quantity;
	private TradeAction action;
	private double price;
	
	public Trade(Stock stock, Date tradeTime, double quantity, TradeAction action, double price) {
		super();
		this.stock = stock;
		this.tradeTime = tradeTime;
		this.quantity = quantity;
		this.action = action;
		this.price = price;
	}
	
	public Stock getStock() {
		return stock;
	}
	public void setStock(Stock stock) {
		this.stock = stock;
	}
	public Date getTradeTime() {
		return tradeTime;
	}
	public void setTradeTime(Date tradeTime) {
		this.tradeTime = tradeTime;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	public TradeAction getAction() {
		return action;
	}
	public void setAction(TradeAction action) {
		this.action = action;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
