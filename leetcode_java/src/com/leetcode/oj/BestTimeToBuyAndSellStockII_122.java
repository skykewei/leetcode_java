package com.leetcode.oj;

public class BestTimeToBuyAndSellStockII_122 {

  public int maxProfit(int[] prices) {
    if (prices == null) {
      return 0;
    }
    int sum = 0;
    for (int i = 1; i < prices.length; i++) {
      int diff = prices[i] - prices[i - 1];
      if (diff > 0) {
        sum += diff;
      }
    }
    return sum;
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
