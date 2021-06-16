/*
Arnab is given an array of N elements and Q queries. In each query he is given two 
values l and r.Arnab has to find a maximum positive integer x where
arr[l]%x = arr[l+1]%x = 0.
*/

import java.util.*;
  import java.io.*;
  
  public class Main 
  {
    static int gcd(int a,int b)
    {
      if(b==0)
        return a;
      return gcd(b,a%b);
    }
    static int[] create_segment_tree(int arr[])
    {
      int x = (int)Math.ceil(Math.log(arr.length-1)/Math.log(2));
      int size = 2 *(int)Math.pow(2,x)-1;
      int segment_tree[] = new int[size];
      for(int i=0;i<segment_tree.length;i++)
        segment_tree[i] = Integer.MAX_VALUE;
      construct_min_segment_tree(arr,segment_tree,1,arr.length-1,0);
      return segment_tree;
    }
    static void construct_min_segment_tree(int arr[],int segment_tree[],int low,int high,int position)
    {
      if(low == high)
      {
        segment_tree[position] = arr[low] ;
        return;
      }
      int mid = (low+high)/2;
      construct_min_segment_tree(arr,segment_tree,low,mid,2*position+1);
      construct_min_segment_tree(arr,segment_tree,mid+1,high,2*position+2);
      segment_tree[position] = gcd(segment_tree[2*position+1],segment_tree[2*position+2]);
    }
    static int divisor_query(int segment_tree[],int qlow,int qhigh,int low,int high,int position)
    {
      if(qlow <= low && qhigh >= high)
      {
        return segment_tree[position];
      }
      if(high < qlow || low > qhigh)
        return 0;
        
      int mid = (low+high)/2;
      int m1 = divisor_query(segment_tree,qlow,qhigh,low,mid,2*position+1);
      int m2 = divisor_query(segment_tree,qlow,qhigh,mid+1,high,2*position+2);
      return gcd(m1,m2);
    }
    public static void main(String args[]) throws IOException 
    {
      Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();
      for(int p=0;p<t;p++)
      {
        int n = sc.nextInt();
        int arr[] = new int[n+1];
        for(int i=1;i<=n;i++)
          arr[i] = sc.nextInt();
        int q = sc.nextInt();
        int segment_tree[] = create_segment_tree(arr);
        for(int i=0;i<q;i++)
        {
          int qlow = sc.nextInt();
          int qhigh = sc.nextInt();
          System.out.println(divisor_query(segment_tree,qlow,qhigh,1,arr.length-1,0));
        }
      }
      
    }
  }