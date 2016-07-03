package com.leetcode.oj;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
//127 https://leetcode.com/problems/word-ladder/
public class WordLadder_127 {


  public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
    if(beginWord==null){
      return 0;
    }
    if(beginWord.equals(endWord)){
      return 1;
    }
    wordList.add(beginWord);
    wordList.add(endWord);
    HashSet<String> visited = new HashSet<>();
    Queue<String> queue = new LinkedList<>();
    queue.offer(beginWord);
    visited.add(beginWord);
    int length =1;
    while(!queue.isEmpty()){
      length++;
      int size = queue.size();
      for(int i=0;i<size;i++){
        String word = queue.poll();
        for(String nextWord:getNextWords(word,wordList)){
          if(visited.contains(nextWord)){
            continue;
          }
          if(nextWord.equals(endWord)){
            return length;
          }
          visited.add(nextWord);
          queue.offer(nextWord);
        }
      }
    }
    return 0;
  }

 private String replace(String s,int index,char c){
   char[] chars = s.toCharArray();
   chars[index]=c;
   return new String(chars);
 }
 private ArrayList<String> getNextWords(String word,Set<String> wordList){
   ArrayList<String> nextWords = new ArrayList<>();
   for(char c='a';c<='z';c++){
     for(int i=0;i<word.length();i++){
       if(c==word.charAt(i)){
         continue;
       }
       String nextWord = replace(word, i, c);
       if(wordList.contains(nextWord)){
         nextWords.add(nextWord);
       }
     }
   }
   return nextWords;
 }
  public static void main(String[] argv){
    Set<String> wordList = new HashSet<>();
    wordList.add("a");
    wordList.add("b");
    wordList.add("c");
    new WordLadder_127().ladderLength("a", "c", wordList);
  }
}
