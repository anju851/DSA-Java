package Arrays;

public class BuySellStocks {
	
	public static void main(String[] args) {
		int[] prices = {7,1,5,3,6,4};
		int max_profit=0;
		int minCP = prices[0];
		// since we can't and compare and sell with single value so we
		// are not using 1st index in iteration and starting with the second position
		for(int i=1;i<prices.length;i++) {
			int profit;
			if(minCP < prices[i]) {
				profit = prices[i] - minCP;
				max_profit = profit > max_profit ? profit : max_profit;
			}else {
			minCP = prices[i];
			}
		}
		System.out.println("max profit: " + max_profit + ", minCP: " + minCP + ", minSP :" + (max_profit+minCP));
	}

}
