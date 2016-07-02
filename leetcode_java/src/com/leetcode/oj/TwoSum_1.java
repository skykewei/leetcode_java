package com.leetcode.oj;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
// 1 https://leetcode.com/problems/two-sum/
public class TwoSum_1 {

  public int[] twoSum(int[] num, int target){
    HashMap<Integer, Integer> numMap = new HashMap<Integer,Integer>();
    for(int i=0;i<num.length;i++){
      if(numMap.containsKey(target-num[i])){
        return new int[]{numMap.get(target-num[i]),i};
      }
      numMap.put(num[i], i);
    }
    throw new IllegalArgumentException("No two sum solution");
  }
      
  public static void main(String[] args) {
    // TODO Auto-generated method stub
  }

}
