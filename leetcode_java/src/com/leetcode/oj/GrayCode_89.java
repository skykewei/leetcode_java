package com.leetcode.oj;

import java.util.ArrayList;
import java.util.List;

public class GrayCode_89 {

  public List<Integer> grayCode(int n) {
      final int cnt = 1<<n;
      List<Integer> ret = new ArrayList<Integer>(cnt);
      ret.add(0);
      for(int i=0;i<n;i++){
        final int highestBit = 1<<i;
        for(int j=ret.size()-1;j>=0;j--){
          ret.add(highestBit|ret.get(j));
        }
      }
      return ret;
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
