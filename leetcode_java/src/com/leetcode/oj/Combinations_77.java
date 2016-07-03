package com.leetcode.oj;

import java.util.ArrayList;
import java.util.List;

//77 https://leetcode.com/problems/combinations/
public class Combinations_77 {
  public List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> retList = new ArrayList<List<Integer>>();
    ArrayList<Integer> path = new ArrayList<>();
    dfs(n, 1, k, path, retList);
    return retList;
  }
  private void dfs(int n,int from,int k,ArrayList<Integer> path,List<List<Integer>> retList){
    if(k==0){
      retList.add(new ArrayList<>(path));
      return;
    }
    if(n-from+1<k){
      return;
    }
    dfs(n, from+1, k, path, retList);
    path.add(from);
    dfs(n, from+1, k-1, path, retList);
    path.remove(path.size()-1);
  }
}
