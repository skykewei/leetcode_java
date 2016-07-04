package com.leetcode.oj;

import java.util.Arrays;

//135 https://leetcode.com/problems/candy/
public class Candy_135 {

  public int candy(int[] ratings) {
    if(ratings==null||ratings.length==0){
      return -1;
    }
    int[] candy = new int[ratings.length];
    for(int i=1,inc=1;i<ratings.length;i++){
      if(ratings[i]>ratings[i-1]){
        candy[i]= Math.max(inc, candy[i]);
        inc++;
      }else{
        inc=1;
      }
    }
    for(int i=ratings.length-2,inc=1;i>=0;i--){
      if(ratings[i]>ratings[i+1]){
        candy[i] = Math.max(inc, candy[i]);
        inc++;
      }else{
        inc=1;
      }
    }
    int total = Arrays.stream(candy).sum()+ratings.length;
    return total;
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    int[] a = new int[0];
  }

}
