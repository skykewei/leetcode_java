package com.leetcode.oj;

import java.util.ArrayList;
import java.util.List;


// 95 https://leetcode.com/problems/unique-binary-search-trees-ii/
public class UniqueBinarySearchTreesII_95 {

  // Definition for a binary tree node.
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }
  
  public List<TreeNode> generateTrees(int n) {
    return generate(1, n);
  }

  public List<TreeNode> generate(int start, int end) {
    List<TreeNode> ret = new ArrayList<>();
    if (start > end) {
      return ret;
    }
    for (int i = start; i <= end; i++) {
      List<TreeNode> leftList = generate(start, i - 1);
      List<TreeNode> rightList = generate(i + 1, end);
      if (leftList.isEmpty()) {
        if (rightList.isEmpty()) {
          TreeNode root = new TreeNode(i);
          ret.add(root);
        } else {
          for (TreeNode right : rightList) {
            TreeNode root = new TreeNode(i);
            root.right = right;
            ret.add(root);
          }
        }
      } else {
        if (rightList.isEmpty()) {
          for (TreeNode left : leftList) {
            TreeNode root = new TreeNode(i);
            root.left = left;
            ret.add(root);
          }
        } else {
          for (TreeNode left : leftList) {
            for (TreeNode right : rightList) {
              TreeNode root = new TreeNode(i);
              root.left = left;
              root.right = right;
              ret.add(root);
            }
          }
        }
      }
    }
    return ret;
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
