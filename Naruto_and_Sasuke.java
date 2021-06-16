/*
Naruto and Sasuke are two Anime characters who have their power levels as A and B.
They got into some fight and the only way to stop their fight is to make their power level equal.
You love both the characters and don't want them to fight. You have K gems.Each gem can increase the power of Naruto by
X and the power of Sasuke by Y.Your goal is to spend all the gems and bring the power of both the characters to the same level.
*/

import java.util.*;
  import java.io.*;
  
  public class Main 
  {
    static int naruto(int a,int b,int x,int y,int k,int p,int q)
    {
      if(p<=q)
      {
        int mid = (p+q)/2;
        int ai=mid,bi=k-mid;
        if(a+(x*ai) == b+(y*bi))  return ai;
        else if(a+(x*ai) > b+(y*bi))  return naruto(a,b,x,y,k,p,mid-1);
        else return naruto(a,b,x,y,k,mid+1,q);
      }
      else  return -1;
    }
    public static void main(String args[]) throws IOException 
    {
      
      Scanner sc = new Scanner(System.in);
      int a = sc.nextInt();
      int b = sc.nextInt();
      int k = sc.nextInt();
      int x = sc.nextInt();
      int y = sc.nextInt();
      System.out.println(naruto(a,b,x,y,k,0,k));
    }
  }