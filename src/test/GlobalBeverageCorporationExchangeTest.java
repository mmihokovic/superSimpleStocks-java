package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import main.superSimpleStocks.jpmorgan.GlobalBeverageCorporationExchange;
import main.superSimpleStocks.jpmorgan.Stock;
import main.superSimpleStocks.jpmorgan.StockType;
import main.superSimpleStocks.jpmorgan.Trade;

/**
 * 
 * @author Marko Mihokoviæ
 *
 */
public class GlobalBeverageCorporationExchangeTest {

	@Test
	public void testTrade() {
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

		assertFalse(trades == null);
		assertTrue(trades.size() > 0);

		for (Trade trade : trades) {
			assertFalse(trade.getPrice() == 0);
			assertFalse(trade.getQuantity() == 0);
			assertFalse(trade.getStock() == null);
		}
	}
}
