package com.leetcode.oj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 90 https://leetcode.com/problems/subsets-ii/
public class SubsetsII {
  public List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> retList = new ArrayList<>();
    ArrayList<Integer> lt = new ArrayList<>();
    Arrays.sort(nums);
    generate(nums, 0, lt, retList);
    return retList;
  }

  private void generate(int[] nums, int step, ArrayList<Integer> lt, List<List<Integer>> retList) {

    retList.add(new ArrayList<>(lt));

    for (int i = step; i < nums.length; i++) {
      if (i != step && nums[i] == nums[i - 1]) {
        continue;
      }
      lt.add(nums[i]);
      generate(nums, i + 1, lt, retList);
      lt.remove(lt.size() - 1);
    }
  }
}
