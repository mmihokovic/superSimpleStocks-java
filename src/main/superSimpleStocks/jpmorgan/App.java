package main.superSimpleStocks.jpmorgan;

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
		GlobalBeverageCorporationExchange exchange = new GlobalBeverageCorporationExchange(stocks, exchangeStartTime,
				exchangeStopTime);

		List<Trade> trades = exchange.Trade();
		System.out.println(String.format("Exchange opened at: %1s", exchangeStartTime));
		System.out.println(String.format("Exchange closed at: %1s with %2d trades.", exchangeStopTime, trades.size()));
		System.out.println(String.format("\nLast 5 trades are:"));
		for (Trade trade : trades.subList(Math.max(trades.size() - 5, 0), trades.size())) {
			System.out.println(String.format("Stock %1s %2s at %3s with price %4.2f", trade.getStock().getSimbol(),
					trade.getAction(), trade.getTradeTime(), trade.getPrice()));
		}

		System.out.println("\nStatistics:");
		System.out.println("|Stock name\t|Dividend yield\t|P\\E ratio\t|Stock price\t|");
		for (Stock stock : stocks) {
			double stockPrice = StockCalculator.CalculateStockPrice(stock, trades);
			double dividendYield = StockCalculator.CalculateDividend(stock, stockPrice);
			double peRatio = StockCalculator.CalculatePeRatio(stock, stockPrice);

			System.out.println(String.format("|%1s\t\t|%2.2f\t\t|%3.2f\t\t|%4.2f\t\t|", stock.getSimbol(),
					dividendYield, peRatio, stockPrice));
		}

		double gbceAllShareIndex = StockCalculator.CalculateGbceAllShareIndex(trades);
		System.out.println(
				String.format("\nGlobal Beverage Corporation Exchange All share index: %1.2f", gbceAllShareIndex));
	}

}
