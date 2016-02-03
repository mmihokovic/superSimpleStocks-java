/**
 * 
 */
package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import main.superSimpleStocks.jpmorgan.Stock;
import main.superSimpleStocks.jpmorgan.StockCalculator;
import main.superSimpleStocks.jpmorgan.StockType;
import main.superSimpleStocks.jpmorgan.Trade;
import main.superSimpleStocks.jpmorgan.TradeAction;

/**
 * @author Marko Mihokoviæ
 *
 */
public class StockCalculatorTests {

	/**
	 * Test method for {@link main.superSimpleStocks.jpmorgan.StockCalculator#CalculateGbceAllShareIndex(java.util.List)}.
	 */
	@Test
	public void testCalculateGbceAllShareIndex() {
		 Stock stock = new Stock("TEA", StockType.COMMON, 0, 0, 100);
         
         List<Trade> trades = new ArrayList<Trade>();
         trades.add(new Trade(stock, new Date(), 5, TradeAction.BUY, 10));
         trades.add(new Trade(stock, new Date(), 10, TradeAction.BUY, 100));

         double gbceAllShareIndex = StockCalculator.CalculateGbceAllShareIndex(trades);
         assertEquals(31.62277660168379, gbceAllShareIndex, 0.0001);
	}

	/**
	 * Test method for {@link main.superSimpleStocks.jpmorgan.StockCalculator#CalculateDividend(main.superSimpleStocks.jpmorgan.Stock, double)}.
	 */
	@Test
	public void testCalculateDividend() {
		 Stock stockCommon = new Stock("TEA", StockType.COMMON, 10, 0, 100);
         double dividendCommon = StockCalculator.CalculateDividend(stockCommon, 100);
         assertEquals(0.1, dividendCommon, 0.0001);

         Stock stockPreferred = new Stock("TEA", StockType.PREFFERED, 10, 5, 100);
         double dividendPreffered = StockCalculator.CalculateDividend(stockPreferred, 100);
         assertEquals(5, dividendPreffered, 0.0001);
	}

	/**
	 * Test method for {@link main.superSimpleStocks.jpmorgan.StockCalculator#CalculatePeRatio(main.superSimpleStocks.jpmorgan.Stock, double)}.
	 */
	@Test
	public void testCalculatePeRatio() {
		Stock stock = new Stock("TEA", StockType.COMMON, 10, 0, 100);
        double peRatio = StockCalculator.CalculatePeRatio(stock, 105);
        assertEquals(10.5, peRatio, 0.0001 );

        Stock stockWithZeroDividend = new Stock("TEA", StockType.COMMON, 0, 0, 100);
        double peRatioWithZeroDividend = StockCalculator.CalculatePeRatio(stockWithZeroDividend, 105);
        assertEquals(0, peRatioWithZeroDividend, 0.0001);
	}

	/**
	 * Test method for {@link main.superSimpleStocks.jpmorgan.StockCalculator#CalculateStockPrice(main.superSimpleStocks.jpmorgan.Stock, java.util.List)}.
	 */
	@Test
	public void testCalculateStockPrice() {
		Stock stock = new Stock("TEA", StockType.COMMON, 0, 0, 100);

        List<Trade> trades = new ArrayList<Trade>();
        trades.add(new Trade(stock, new Date(), 5, TradeAction.BUY, 50));
        trades.add(new Trade(stock, new Date(), 10, TradeAction.BUY, 100));
        trades.add(new Trade(stock, new Date(), 10, TradeAction.SELL, 100));

        double stockPrice = StockCalculator.CalculateStockPrice(stock, trades);
        assertEquals(90, stockPrice, 0.0001);
	}

}
