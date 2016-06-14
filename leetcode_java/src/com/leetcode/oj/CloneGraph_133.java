package com.leetcode.oj;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CloneGraph_133 {

  /**
   * Definition for undirected graph. class UndirectedGraphNode { int label; List
   * <UndirectedGraphNode> neighbors; UndirectedGraphNode(int x) { label = x; neighbors = new
   * ArrayList<UndirectedGraphNode>(); } };
   */
  class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;

    UndirectedGraphNode(int x) {
      label = x;
      neighbors = new ArrayList<UndirectedGraphNode>();
    }
  }

  public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    if (node == null) {
      return null;
    }
    Queue<UndirectedGraphNode> queue = new LinkedList<>();
    queue.add(node);
    Map<UndirectedGraphNode, UndirectedGraphNode> mp = new HashMap<>();
    while (!queue.isEmpty()) {
      UndirectedGraphNode tmp = queue.poll();
      mp.put(tmp, new UndirectedGraphNode(tmp.label));
      for (UndirectedGraphNode t : tmp.neighbors) {
        if (!mp.containsKey(t)&&!queue.contains(t)) {
          queue.add(t);
        }
      }
    }
    UndirectedGraphNode head = mp.get(node);
    queue.add(node);
    List<UndirectedGraphNode> visited = new ArrayList<>();
    while (!queue.isEmpty()) {
      UndirectedGraphNode t = queue.poll();
      UndirectedGraphNode rt = mp.get(t);
      visited.add(t);
      for (UndirectedGraphNode n : t.neighbors) {
        rt.neighbors.add(mp.get(n));
        if (!visited.contains(n)&&!queue.contains(n)) {        
          queue.add(n);
        }
      }
    }
    return head;
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
