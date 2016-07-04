package com.leetcode.oj;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//49 https://leetcode.com/problems/anagrams/
public class GroupAnagrams_49 {

  public List<List<String>> groupAnagrams(String[] strs) {
    HashMap<Integer, List<String>> ret = new HashMap<Integer, List<String>>();
    for(String s:strs){
      int h = hash(s);
      if(ret.containsKey(h)){
        ret.get(h).add(s);
      }else {
        ArrayList<String> lt = new ArrayList<String>();
        lt.add(s);
        ret.put(h, lt);
      }
    }
    List<List<String>> retList = new ArrayList<List<String>>();
    for(Map.Entry<Integer,List<String>> lt:ret.entrySet()){
      retList.add(lt.getValue());
    }
    return retList;
  }
  // string s contain only lower case
  public int hash(String s){
    if(s==null||s.length()==0){
      return 0;
    }
    final int[] mp = new int[26];
    for(int i=0;i<s.length();i++){
      mp[s.charAt(i)-'a']++;
    }
    int hash = 0;
    for(int i=0;i<mp.length;i++){
      hash = 31*hash+(i+1)*mp[i];
    }
    return hash;
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
