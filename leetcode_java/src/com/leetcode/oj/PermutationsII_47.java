package com.leetcode.oj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

//47 https://leetcode.com/problems/permutations-ii/
public class PermutationsII_47 {
  public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> retList = new ArrayList<>();
    ArrayList<Integer> path = new ArrayList<>();
    Arrays.sort(nums);
    HashMap<Integer, Integer> countmp = new HashMap<>();
    for(int v:nums){
      if(countmp.containsKey(v)){
        countmp.put(v, countmp.get(v)+1);
      }else{
        countmp.put(v,1);
      }
    }
    Set<Map.Entry<Integer,Integer>> elems=countmp.entrySet();
    ArrayList<Map.Entry<Integer,Integer>> a = new ArrayList<>(elems);
    permute(nums.length,a,0, path, retList);
   // dfs(nums, 0, path, retList);
    return retList;
  }
  private void permute(int size, ArrayList<Map.Entry<Integer,Integer>> a,
      int from,
      ArrayList<Integer> path,
      List<List<Integer>> retList){
    if(size==path.size()){
      retList.add(new ArrayList<>(path));
    }
    for(int i=from;i<a.size();i++ ){
     
      Map.Entry<Integer, Integer> entry =a.get(i);
      int count=0;
      for(int v:path){
        if(v==entry.getKey()){
          count++;
        }
      }
      if(count<entry.getValue()){
        path.add(entry.getKey());
        permute(size,a,from, path, retList);
        path.remove(path.size()-1);
      }
    }
  }
}
