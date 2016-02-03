package main.superSimpleStocks.jpmorgan;

import java.util.ArrayList;
import java.util.List;

/**
 * Helper class for performing calculations on stocks and trades.
 * 
 * @author Marko Mihokovic
 *
 */
public class StockCalculator {

	/**
	 * Calculates Global Beverages Corporation Exchange shares index.
	 * @param trades All performed trades on exchange
	 * @return Share index
	 */
	public static double CalculateGbceAllShareIndex(List<Trade> trades) {
		List<Double> tradePrices = new ArrayList<Double>();
		for (Trade trade : trades) {
			tradePrices.add(trade.getPrice());
		}

		return calculateGeometricMean(tradePrices);
	}

	/**
	 * Calculates stock dividend based on stock type and stock price.
	 * @param stock Stock for calculation
	 * @param price Stock price
	 * @return Stock dividend.
	 */
	public static double CalculateDividend(Stock stock, double price) {
		if (stock.getType() == StockType.COMMON)
			return calculateDividendYieldCommon(stock.getLastDividend(), price);
		else
			return calculateDividentYieldPreffered(stock.getFixedDividend(), stock.getParValue(), price);
	}

	/**
	 * Calculates stock prices-earnings ratio.
	 * @param stock Stock for calculation
	 * @param price Stock price
	 * @return Stock price-earnings ratio
	 */
	public static double CalculatePeRatio(Stock stock, double price) {
		return calculatePeRatio(stock.getLastDividend(), price);
	}

	/**
	 * Calculates stock price based on previous stock trades
	 * @param stock Stock for calculating price
	 * @param trades All trades on market.
	 * @return Stock price
	 */
	public static double CalculateStockPrice(Stock stock, List<Trade> trades) {
		double sumPriceAndQuantity = 0;
		double sumQuantity = 0;

		for (Trade trade : trades) {
			if (trade.getStock() != stock)
				continue;

			sumPriceAndQuantity += trade.getPrice() * trade.getQuantity();
			sumQuantity += trade.getQuantity();
		}

		return sumPriceAndQuantity / sumQuantity;
	}

	private static double calculateDividendYieldCommon(double lastDividend, double ticketPrice) {
		return lastDividend / ticketPrice;
	}

	private static double calculateDividentYieldPreffered(double fixedDividend, double parValue, double tickerPrice) {
		return (fixedDividend * parValue) / tickerPrice;
	}

	private static double calculatePeRatio(double dividend, double tickedPrice) {
		return dividend != 0 ? tickedPrice / dividend : 0;
	}

	private static double calculateGeometricMean(List<Double> tradePrices) {
		if (tradePrices == null || tradePrices.isEmpty()) {
			return 0;
		}

		double sum = 0;
		for (double tradePrice : tradePrices) {
			sum += Math.log(tradePrice) / Math.log(2);
		}

		sum *= 1.0 / tradePrices.size();
		double geometricMean = Math.pow(2.0, sum);

		return geometricMean;
	}
}
