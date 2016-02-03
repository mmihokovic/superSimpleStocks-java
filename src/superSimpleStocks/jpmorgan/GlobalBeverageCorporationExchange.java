package superSimpleStocks.jpmorgan;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class GlobalBeverageCorporationExchange {

	private List<Stock> stocks;
	private Date startDate;
	private Date endDate;
	private Random random;
	
	public GlobalBeverageCorporationExchange(List<Stock> stocks, Date startDate, Date endDate) {
		super();
		this.stocks = stocks;
		this.startDate = startDate;
		this.endDate = endDate;
		this.random = new Random();
	}
	
	public List<Trade> Trade(){
		int maxTradesCount = (int) ((startDate.getTime() - endDate.getTime()) / 1000);
		int tradesCount = random.nextInt(maxTradesCount) + 1;
		
		List<Trade> trades = new ArrayList<Trade>();
		for (int i = 0; i < tradesCount; i++) {
			Stock stock = stocks.get(random.nextInt(stocks.size()));
			
			TradeAction tradeAction = (random.nextDouble() >= 0.5) ? TradeAction.BUY : TradeAction.SELL;
			double price = stock.getParValue()* 0.5 +
                    (random.nextDouble()*(double) (stock.getParValue()*2 - stock.getParValue()* 0.5));
			double quantity = random.nextInt(1000) + 1;
			Date tradeTime = new Date();
			Trade trade = new Trade(stock, tradeTime, quantity, tradeAction, price);
			trades.add(trade);
		}
		
		return trades;
	}
	
	public List<Stock> getStocks() {
		return stocks;
	}
	public void setStocks(List<Stock> stocks) {
		this.stocks = stocks;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	
	
	
}
