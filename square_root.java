/* finding square root of a number , if sqaure root is in decimal, find the floor of square root.*/

import java.util.*;
  import java.io.*;
  
  public class Main 
  {
    static long squareroot(long low,long high,long n)
    {
      if(low <= high)
      {
        long mid = (low+high)/2;
        if(mid*mid < n) return  squareroot(mid+1,high,n);
        else if(mid*mid > n)  return squareroot(low,mid-1,n);
        else return mid;
      }
      else return high;
    }
    public static void main(String args[]) throws IOException 
    {
      
      Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();
      for(int p=0;p<t;p++)
      {
        long n = sc.nextLong();
        long low = 1,high = (low+n)/2;
        if(n==1)  System.out.println("1");
        else if(n==0) System.out.println("0");
        else  System.out.println(squareroot(low,high,n));
      }
    }
  }