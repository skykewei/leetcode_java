package com.leetcode.oj;

import java.util.HashMap;


// https://leetcode.com/problems/lru-cache/
public class LRUCache {

  /**
   * cache
   */
  private HashMap<Integer, CacheNode<Entry<Integer, Integer>>> cache = new HashMap<>();
  /**
   * current number of elements
   */
  transient int size = 0;
  /**
   * Invariant: capacity > 0
   */
  transient int capacity = 0;
  /**
   * most old key, keylist.first Pointer to first node. Invariant: (first == null && last == null)
   * || (first.prev == null && first.item != null)
   */
  transient CacheNode<Entry<Integer, Integer>> first;

  /**
   * most new key,keylist.last Pointer to last node. Invariant: (first == null && last == null) ||
   * (last.next == null && last.item != null)
   */
  transient CacheNode<Entry<Integer, Integer>> last;

  public LRUCache(int capacity) {
    if (capacity <= 0) {
      throw new IllegalArgumentException("capacity must be positive");
    }
    this.capacity = capacity;
  }

  public int get(int key) {
    if (cache.containsKey(key)) {
      // move the key to TimeNodeList head
      CacheNode<Entry<Integer, Integer>> curNode = cache.get(key);
      Entry<Integer, Integer> ele = curNode.item;
      unlink(curNode);
      // insert new TimeNode
      linkFirst(ele);
      cache.put(key, first);
      return ele.value;
    }
    return -1;

  }

  public void set(int key, int value) {
    if (cache.containsKey(key)) {
      // move the key to TimeNodeList head
      CacheNode<Entry<Integer, Integer>> curNode = cache.get(key);
      Entry<Integer, Integer> ele = curNode.item;
      ele.value = value;
      unlink(curNode);
      linkFirst(ele);
      cache.put(key, first);
    } else {
      // when cap is full,remove the oldest.
      if (cache.size() >= capacity) {
        // remove the oldest element in Node list
        Entry<Integer, Integer> k = unlinkLast(last);
        cache.remove(k.key);     
      }
      Entry<Integer, Integer> newNode = new Entry<Integer, Integer>(key, value);
      linkFirst(newNode);
      cache.put(key, first);
    } 
  }

  /**
   * Links e as first element.
   */
  private void linkFirst(Entry<Integer, Integer> e) {
    final CacheNode<Entry<Integer, Integer>> f = first;
    final CacheNode<Entry<Integer, Integer>> newNode = new CacheNode<Entry<Integer, Integer>>(null, e, f);
    first = newNode;
    if (f == null)
      last = newNode;
    else
      f.prev = newNode;
    size++;
  }

  /**
   * Unlinks non-null last node l.
   */
  private Entry<Integer, Integer> unlinkLast(CacheNode<Entry<Integer, Integer>> l) {
    // assert l == last && l != null;
    final Entry<Integer, Integer> element = l.item;
    final CacheNode<Entry<Integer, Integer>> prev = l.prev;
    l.item = null;
    l.prev = null; // help GC
    last = prev;
    if (prev == null)
      first = null;
    else
      prev.next = null;
    size--;
    return element;
  }

  /**
   * Unlinks non-null node x.
   */
  private Entry<Integer, Integer> unlink(CacheNode<Entry<Integer, Integer>> x) {
    // assert x != null;
    final Entry<Integer, Integer> element = x.item;
    final CacheNode<Entry<Integer, Integer>> next = x.next;
    final CacheNode<Entry<Integer, Integer>> prev = x.prev;

    if (prev == null) {
      first = next;
    } else {
      prev.next = next;
      x.prev = null;
    }

    if (next == null) {
      last = prev;
    } else {
      next.prev = prev;
      x.next = null;
    }

    x.item = null;
    size--;
    return element;
  }

  private static class Entry<K,V>{
    K key;
    V value;
    public Entry(K k,V v) {
      key = k;
      value = v;
    }
  }
  private static class CacheNode<E> {
    E item;
    CacheNode<E> next;
    CacheNode<E> prev;

    CacheNode(CacheNode<E> prev, E element, CacheNode<E> next) {
      this.item = element;
      this.next = next;
      this.prev = prev;
    }
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
