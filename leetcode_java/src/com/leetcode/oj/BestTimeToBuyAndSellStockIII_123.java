package com.leetcode.oj;

public class BestTimeToBuyAndSellStockIII_123 {

  public int maxProfit(int[] prices) {
    if(prices==null||prices.length<2){
      return 0;
    }
    int[] f=new int[prices.length];
    int[] g=new int[prices.length];
    int curMin = prices[0];
    for(int i=1;i<prices.length;i++){
      curMin = Math.min(curMin, prices[i]);
      f[i] = Math.max(f[i-1], prices[i]-curMin);
    }
    int curMax = prices[prices.length-1];
    for(int i=prices.length-2;i>=0;i--){
      curMax = Math.max(curMax,prices[i]);
      g[i] = Math.max(g[i+1], curMax-prices[i]);
    }
    int maxProfit = 0;
    for(int i=0;i<prices.length;i++){
      maxProfit = Math.max(maxProfit, f[i]+g[i]);
    }
    return maxProfit;
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
