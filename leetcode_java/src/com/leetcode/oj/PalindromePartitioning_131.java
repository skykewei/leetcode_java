package com.leetcode.oj;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PalindromePartitioning_131 {

  public List<List<String>> partition(String s) {
   if(s==null||s.length()==0){
     return null;
   }
   int n = s.length();
   boolean[][] pp = new boolean[n][n];
   for(int i=n-1;i>=0;i--){
     for(int j=i;j<n;j++){
       if(s.charAt(j)==s.charAt(i)&&(j-i<2||pp[i+1][j-1])){
         pp[i][j] = true;
       }
       
     }
   }
   HashMap<Integer, List<List<String> > > mp = new HashMap<>(n);
   for(int i=0;i<n;i++){
     List<List<String>> lt = new ArrayList<List<String>>();
     mp.put(i, lt);
   }
   
   for(int i=n-1;i>=0;i--){    
     for(int j=i;j<n;j++){
       if(pp[i][j]){
         String st = s.substring(i, j+1);
         if(j+1<n){
           for(List<String> t:mp.get(j+1)){
             ArrayList<String> at=new ArrayList<>(t);
             at.add(0,st);
             mp.get(i).add(at);
           }
         }else{
           List<String> ltStr = new ArrayList<String>();
           ltStr.add(st);
           mp.get(i).add(ltStr);
         }
       }
     }
   }
   //for 
   return mp.get(0);
  }
  public static void main(String[] args) {
    String s = "aab";
    List<List<String>> ret = new PalindromePartitioning_131().partition(s);
    System.out.println(ret.toString());
  }

}
