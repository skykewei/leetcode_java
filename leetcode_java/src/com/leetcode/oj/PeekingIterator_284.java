package com.leetcode.oj;

import java.util.Iterator;

// 284 https://leetcode.com/problems/peeking-iterator/
public class PeekingIterator_284 {
  // Java Iterator interface reference:
  // https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
  class PeekingIterator implements Iterator<Integer> {

    private Iterator<Integer> iter;
    private Integer peekValue;

    public PeekingIterator(Iterator<Integer> iterator) {
      // initialize any member here.
      iter = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
      if(!hasNext()){
        throw new IllegalStateException("no more elements");
      }
      if(peekValue!=null){
        return peekValue;
      }
      peekValue = iter.next();
      return peekValue;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
      final Integer value = peekValue;
      if (value != null) {
        peekValue = null;
        return value;
      } else {
        return iter.next();
      }
    }

    @Override
    public boolean hasNext() {
      return peekValue!=null || iter.hasNext();
    }
  }
}
