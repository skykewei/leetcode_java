package com.leetcode.oj;

import java.util.ArrayList;
import java.util.List;

// 78 https://leetcode.com/problems/subsets/
public class Subsets_78 {
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> retList = new ArrayList<>();
    ArrayList<Integer> lt = new ArrayList<>();
    generate(nums, 0, lt, retList);
    return retList;
  }

  private void generate(int[] nums, int step, ArrayList<Integer> lt, List<List<Integer>> retList) {
    if (step == nums.length) {
      retList.add(new ArrayList<>(lt));
      return;
    }
    generate(nums, step + 1, lt, retList);
    lt.add(nums[step]);
    generate(nums, step + 1, lt, retList);
    lt.remove(lt.size() - 1);
  }
}
