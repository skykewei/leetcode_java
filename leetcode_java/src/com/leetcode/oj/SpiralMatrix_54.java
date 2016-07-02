package com.leetcode.oj;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
// 54 https://leetcode.com/problems/spiral-matrix/
public class SpiralMatrix_54 {

  private Map<Character, Integer> map = new HashMap<Character, Integer>() {
    {
      put('I', 1);
      put('V', 5);
      put('X', 10);
      put('L', 50);
      put('C', 100);
      put('D', 500);
      put('M', 1000);
    }
  };

  public int romanToInt(String s) {
    int prev = 0, total = 0;
    for (char c : s.toCharArray()) {
      int curr = map.get(c);
      total += (curr > prev) ? (curr - 2 * prev) : curr;
      prev = curr;
    }
    return total;
  }

  public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> ret = new ArrayList<>();
    if (matrix == null) {
      return ret;
    }

    int re = matrix.length - 1;
    if (matrix.length <= 0) {
      return ret;
    }
    int ce = matrix[0].length - 1;
    int cs = 0;
    int rs = 0;
    while (rs <= re && cs <= ce) {
      for (int i = cs; i <= ce; i++) {
        ret.add(matrix[rs][i]);
      }
      for (int i = rs + 1; i <= re; i++) {
        ret.add(matrix[i][ce]);
      }
      for (int i = ce - 1; i >= cs && re > rs; i--) {
        ret.add(matrix[re][i]);
      }
      for (int i = re - 1; i >= rs + 1 && cs < ce; i--) {
        ret.add(matrix[i][cs]);
      }
      rs++;
      cs++;
      re--;
      ce--;
    }
    return ret;
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    int[][] ma = new int[][] {{3}, {2}};
    new SpiralMatrix_54().spiralOrder(ma);
  }

}
