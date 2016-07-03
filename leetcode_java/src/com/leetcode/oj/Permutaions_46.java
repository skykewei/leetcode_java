package com.leetcode.oj;

import java.util.ArrayList;
import java.util.List;

//46 https://leetcode.com/problems/permutations/
public class Permutaions_46 {

  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> retList = new ArrayList<>();
    ArrayList<Integer> path = new ArrayList<>();
    dfs(nums, 0, path, retList);
    return retList;
  }
  private void dfs(int[] nums,int step,ArrayList<Integer> path, List<List<Integer>> retList){ 
    if(step==nums.length){
      retList.add(new ArrayList<>(path));
      return;
    }
    for(int i=step;i<nums.length;i++){   
        int tmp = nums[step];
        nums[step]=nums[i];
        nums[i] = tmp;
        path.add(nums[step]);
        dfs(nums, step+1, path, retList);
        path.remove(path.size()-1);
        tmp = nums[step];
        nums[step]=nums[i];
        nums[i]=tmp;
      
    }
  }
}
