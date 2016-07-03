package com.leetcode.oj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

//126 https://leetcode.com/problems/word-ladder-ii/
public class WordLadderII_126 {
  public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
    List<List<String>> ladders = new ArrayList<>();
    Map<String, List<String>> map = new HashMap<>();
    Map<String, Integer> distance = new HashMap<>();
    wordList.add(beginWord);
    wordList.add(endWord);
    bfs(map, distance, beginWord, endWord, wordList);
    List<String> path = new ArrayList<>();
    dfs(ladders, path, endWord, beginWord, distance, map);
    return ladders;
  }

  private void bfs(Map<String, List<String>> map, Map<String, Integer> distance, String beginWord,
      String endWord, Set<String> wordList) {
    Queue<String> q = new LinkedList<>();
    q.offer(beginWord);
    distance.put(beginWord, 0);
    for (String s : wordList) {
      map.put(s, new ArrayList<>());
    }
    while (!q.isEmpty()) {
      String crt = q.poll();
      List<String> nextList = expand(crt, wordList);
      for (String next : nextList) {
        map.get(next).add(crt);
        if (!distance.containsKey(next)) {
          distance.put(next, distance.get(crt) + 1);
          q.offer(next);
        }
      }
    }

  }

  private void dfs(List<List<String>> ladders, List<String> path, String crt, String start,
      Map<String, Integer> distance, Map<String, List<String>> map) {
    path.add(crt);
    if (crt.equals(start)) {
      Collections.reverse(path);
      ladders.add(new ArrayList<String>(path));
      Collections.reverse(path);
    } else {
      for (String next : map.get(crt)) {
        if (distance.containsKey(next) && distance.get(crt) == distance.get(next) + 1) {
          dfs(ladders, path, next, start, distance, map);
        }
      }
    }
    path.remove(path.size() - 1);
  }

  private List<String> expand(String crt, Set<String> wordList) {
    List<String> expand = new ArrayList<>();
    for (int i = 0; i < crt.length(); i++) {
      for (char ch = 'a'; ch <= 'z'; ch++) {
        if (ch != crt.charAt(i)) {
          String exp = crt.substring(0, i) + ch + crt.substring(i + 1);
          if (wordList.contains(exp)) {
            expand.add(exp);
          }
        }
      }
    }
    return expand;
  }
}
