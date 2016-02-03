package superSimpleStocks.jpmorgan;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class App {

	public static void main(String[] args) {
		List<Stock> stocks = new ArrayList<Stock>();
		stocks.add(new Stock("TEA", StockType.COMMON, 0, 0, 100));
        stocks.add(new Stock("POP", StockType.COMMON, 8, 0, 100));
        stocks.add(new Stock("ALE", StockType.COMMON, 23, 0, 60));
        stocks.add(new Stock("GIN", StockType.PREFFERED, 8, 2, 100));
        stocks.add(new Stock("JOE", StockType.COMMON, 13, 0, 250));
        
        int tradePeriodInMinutes = 15;
        Date exchangeStartTime = new Date();
        Date exchangeStopTime = new Date(exchangeStartTime.getTime() + tradePeriodInMinutes * 60 * 1000);
        GlobalBeverageCorporationExchange exchange = new GlobalBeverageCorporationExchange(stocks, exchangeStartTime, exchangeStopTime);
        
	}

}
