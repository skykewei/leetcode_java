package com.leetcode.oj;

import java.util.List;

public class Triangle_120 {

  public int minimumTotal(List<List<Integer>> triangle) {
    if (triangle == null) {
      return -1;
    }
    int cnt = triangle.size();
    for (int i = cnt - 2; i >= 0; i--) {
      List<Integer> clt = triangle.get(i);
      List<Integer> clt2 = triangle.get(i + 1);
      int n = clt.size();
      for (int j = 0; j < n; j++) {
        clt.set(j, clt.get(j) + Math.min(clt2.get(j), clt2.get(j + 1)));
      }
    }
    return triangle.get(0).get(0);
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
