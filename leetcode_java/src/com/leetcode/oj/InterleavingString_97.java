package com.leetcode.oj;

//https://leetcode.com/problems/interleaving-string/
public class InterleavingString_97 {


  public boolean isInterleave(String s1, String s2, String s3) {
    int n1 = s1.length();
    int n2 = s2.length();
    int n3 = s3.length();
    if(n1+n2!=n3){
      return false;
    }
    boolean[] f=new boolean[n2+1];
    f[0]= true;
    for(int i=1;i<=n2;i++){
      f[i] = f[i-1]&&(s2.charAt(i-1)==s3.charAt(i-1));
    }
    for(int i=1;i<=n1;i++){
      f[0] = f[0]&&(s1.charAt(i-1)==s3.charAt(i-1));
      for(int j=1;j<=n2;j++){
        f[j] = (s1.charAt(i-1)==s3.charAt(i+j-1)&&f[j]) || 
               (s2.charAt(j-1)==s3.charAt(i+j-1)&&f[j-1]);
      }
    }
    return f[n2];
  }
  public boolean isInterleave2(String s1,String s2,String s3){
    int n1 = s1.length();
    int n2 = s2.length();
    int n3 = s3.length();
    if(n1+n2!=n3){
      return false;
    }
    boolean[][] f = new boolean[n1+1][n2+1];
//    for(int i=0;i<=n1;i++){
//      Arrays.fill(f[i], true);
//    }
    f[0][0] = true;
    for(int i=1;i<=n1;i++){
      f[i][0] =  f[i-1][0]&&(s1.charAt(i-1)==s3.charAt(i-1));
    }
    for(int i=1;i<=n2;i++){
      f[0][i] = f[0][i-1]&&(s2.charAt(i-1)==s3.charAt(i-1));
    }
    
    for(int i=1;i<=n1;i++){
      for(int j=1;j<=n2;j++){
        f[i][j] = (f[i-1][j]&&s1.charAt(i-1)==s3.charAt(i+j-1)) ||
                  (f[i][j-1]&&s2.charAt(j-1)==s3.charAt(i+j-1));
      }
    }
    return f[n1][n2];
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
