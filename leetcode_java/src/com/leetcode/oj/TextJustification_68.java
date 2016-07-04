package com.leetcode.oj;

import java.util.ArrayList;
import java.util.List;

// 68 https://leetcode.com/problems/text-justification/
public class TextJustification_68 {
  public List<String> fullJustify(String[] words, int maxWidth) {
    int wordsCount = words.length;
    ArrayList<String> result = new ArrayList<String>();
    int curLen = 0;
    int lastl = 0;
    for (int i = 0; i <= wordsCount; i++) {
      if (i == wordsCount || curLen + words[i].length() + i - lastl > maxWidth) {
        StringBuilder builder = new StringBuilder();
        int spaceCount = maxWidth - curLen;
        int spaceSlots = i - lastl - 1;
        if (spaceSlots == 0 || i == wordsCount) {
          for (int j = lastl; j < i; j++) {
            builder.append(words[j]);
            if (j != i - 1) {
              appendSpace(builder,1);
            }
          }
          appendSpace(builder, maxWidth-builder.length());
        }else{
          int spaceEach = spaceCount/spaceSlots;
          int spaceExtra = spaceCount%spaceSlots;
          for(int j=lastl;j<i;j++){
            builder.append(words[j]);
            if(j!=i-1){
              appendSpace(builder,spaceEach+(j-lastl<spaceExtra?1:0));
            }
          }
        }
        result.add(builder.toString());
        lastl=i;
        curLen=0;
      }
      if(i<wordsCount){
        curLen+=words[i].length();
      }
    }
    return result;
  }

  private void appendSpace(StringBuilder sb, int count) {
    for (int i = 0; i < count; i++)
      sb.append(' ');
  }
}
