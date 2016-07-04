package com.leetcode.oj;

import java.util.HashMap;

public class LongestConsecutiveSequence_128 {

  public int longestConsecutive(int[] nums) {
    if(nums==null||nums.length==0){
      return 0;
    }
    HashMap<Integer, Boolean> mp = new HashMap<Integer, Boolean>((int)(nums.length/0.75 +1));
    for(int v:nums){
      mp.put(v, true);
    }
    int ret = 1;
    for(int v:nums){
      if(!(mp.containsKey(v+ret-1)||mp.containsKey(v-(ret-1)))){
        continue;
      }
      int cnt = 1;
      int vc = v+1;
      while(mp.containsKey(vc)){
        cnt++;
        vc++;
      }
      vc = v-1;
      while(mp.containsKey(vc)){
        cnt++;
        vc--;
      }
      ret = Math.max(ret, cnt);
    }
    return ret;
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    
  }

}
