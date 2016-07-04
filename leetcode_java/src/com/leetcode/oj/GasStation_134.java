package com.leetcode.oj;

public class GasStation_134 {

  public int canCompleteCircuit(int[] gas, int[] cost) {
    int total = 0;
    int j = -1;

    for (int i = 0, sum = 0; i < gas.length; i++) {
      sum += gas[i] - cost[i];
      total += gas[i] - cost[i];
      if (sum < 0) {
        sum = 0;
        j = i;
      }
    }
    return total >= 0 ? j + 1 : -1;
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
