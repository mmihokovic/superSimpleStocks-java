/**
 * 
 */
package main.superSimpleStocks.jpmorgan;

import java.util.List;

/**
 * @author Marko Mihokovi�
 *
 */
public interface IGlobalBeverageCorporationExchange {

	/**
	 * Open stock market and begin trading.
	 * @return Performed trades.
	 */
	public List<Trade> Trade();
}
