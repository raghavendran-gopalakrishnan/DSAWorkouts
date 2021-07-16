package com.dsa.challenges.arrays;

public class StockPrices {
	/*
	 * Given a list of daily stock prices (integers for simplicity), return the buy and sell prices for making the maximum profit.

		We need to maximize the single buy/sell profit. If we can’t make any profit, we’ll try to minimize the loss.
	 */
	public static Tuple findBuySellStockPrices(int[] stockPrice) {
		int current_profit = Integer.MIN_VALUE;
		int current_buy = stockPrice[0];
		int global_sell = stockPrice[1];
		int global_profit = global_sell - current_buy;
		for(int i=1; i<stockPrice.length; i++) {
			current_profit = stockPrice[i] - current_buy;
			if(current_profit > global_profit) {
				global_profit = current_profit;
				global_sell = stockPrice[i];
			}
			if(stockPrice[i] < current_buy)
				current_buy = stockPrice[i];
		}
		Tuple<Integer, Integer> result = new Tuple<Integer, Integer>(global_sell-global_profit, global_sell);
		return result;
	}

	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 3, 2, 1, 2, 5};
		Tuple result = null;
		result = findBuySellStockPrices(array);
		System.out.println(String.format("Buy Price: %d, Sell Price: %d", result.x, result.y));

		int[] array2 = {8, 6, 5, 4, 3, 2, 1};
		result = findBuySellStockPrices(array2);
		System.out.println(String.format("Buy Price: %d, Sell Price: %d", result.x, result.y));

	}
}


class Tuple<X, Y> { 
	public X x; 
	public Y y; 

	public Tuple(X x, Y y) { 
		this.x = x; 
		this.y = y; 
	} 
}