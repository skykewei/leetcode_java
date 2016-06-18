package com.leetcode.oj;
// 121 https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
public class BestTimeToBuyAndSellStock_121 {

  public int maxProfit(int[] prices) {
    if(prices.length<2){
      return 0;
    }
    int curMin = prices[0];
    int profit = 0;
    for(int i=1;i<prices.length;i++){
      profit = Math.max(profit, prices[i]-curMin);
      curMin = Math.min(curMin, prices[i]);
    }
    return profit;
  }
    
    
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
