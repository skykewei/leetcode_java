package com.leetcode.oj;

import java.util.ArrayList;
import java.util.List;

//93 https://leetcode.com/problems/restore-ip-addresses/
public class RestoreIPAddresses_93 {
  public List<String> restoreIpAddresses(String s) {
    List<String> result = new ArrayList<String>();
    ArrayList<String> path = new ArrayList<>();
    if(s==null||s.length()==0){
      return result;
    }
    dfs(s, 0, path, result);
    return result;
  }
  private void dfs(String s,int k,ArrayList<String> path,List<String> result){
    if(path.size()==4&&k==s.length()){
      result.add(path.get(0)+"."+path.get(1)+"."+path.get(2)+"."+path.get(3));
      return;
    }
    if(k==s.length()||path.size()==4||4-path.size()>s.length()-k){
      return;
    }
    if(s.charAt(k)=='0'){
      path.add("0");
      dfs(s, k+1, path, result);
      path.remove(path.size()-1);
      return;
    }
    int v=0;
    for(int j=k;j<=k+2;j++){
      if(j>=s.length()){
        break;
      }
      v *=10;
      v += s.charAt(j)-'0';
      if(!isValid(v)){
        break;
      }
      path.add(s.substring(k,j+1));
      dfs(s, j+1, path, result);
      path.remove(path.size()-1);
    }
  }
  private boolean isValid(int v){
    return v>=0&&v<=255;
  }
}
