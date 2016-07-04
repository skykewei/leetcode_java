package com.leetcode.oj;
// 215 https://leetcode.com/problems/kth-largest-element-in-an-array/
public class KthLargestElementInAnArray_215 {

  public class MaxHeap{
    int[] heap;//from 1...heap.length-1
    int len;
    public MaxHeap(int size){
      heap = new int[size+1];
      len=0;
    }
    public void insert(int v){
      if(len==heap.length-1){
        if(getMax()<=v){
          return;
        }
        heap[1]=v;
        adjust();
        return;
      }
      len++;
      heap[len]=v;
      int k=len;
      while((k>>1)>=1 && v>heap[k>>1]){
         heap[k] = heap[k>>1];
         k >>=1;
      }
      heap[k] = v;
    }
    public int getMax(){
      return heap[1];
    }
    public void adjust(){
      int v = heap[1];
      int k=1;
      while((k<<1)<=len){
        int oldk = k;
        k <<=1;
        if(k+1<=len&&heap[k]<heap[k+1]){
          k++;
        }
        if(heap[k]>v){
          heap[k>>1]=heap[k];
        }else{
          k=oldk;
          break;
        }
      }
      heap[k] = v;
    }
  }
  
  public class MinHeap{
    int[] heap;//from 1...heap.length-1
    int len;
    public MinHeap(int size){
      heap = new int[size+1];
      len=0;
    }
    public void insert(int v){
      if(len==heap.length-1){
        if(getMin()>=v){
          return;
        }
        heap[1]=v;
        adjust();
        return;
      }
      len++;
      heap[len]=v;
      int k=len;
      while((k>>1)>=1 && v<heap[k>>1]){
         heap[k] = heap[k>>1];
         k >>=1;
      }
      heap[k] = v;
    }
    public int getMin(){
      return heap[1];
    }
    public void adjust(){
      int v = heap[1];
      int k=1;
      while((k<<1)<=len){
        int oldk = k;
        k<<=1;
        if(k+1<=len&&heap[k]>heap[k+1]){
          k++;
        }
        if(heap[k]<v){
          heap[k>>1]=heap[k];
        }else{
          k=oldk;
          break;
        }
      }
      heap[k] = v;
    }
  }
  public int findKthLargest(int[] nums, int k) {
     MinHeap heap = new MinHeap(k);
     for(int i=0;i<nums.length;i++){
       heap.insert(nums[i]);
     }
     return heap.getMin();
  }
  
  public static void main(String[] argv){
    int[] nums= {3,1,2,4};
    int k=2;
    new KthLargestElementInAnArray_215().findKthLargest(nums, k);
  }
}
