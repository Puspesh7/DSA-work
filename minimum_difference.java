/*
Arnab is given an array of length n and a number x
Help Arnab Find three integers in the array whose sum is closest to x.
Print the minimum absolute difference between the sum and the integer x.
*/

import java.util.*;
  import java.io.*;
  
  public class Main 
  {
    static int difference(int arr[],int n,int x)
    {
      int mindiff = 100000000;
      for(int i=0;i<n-2;i++)
      {
        int j = i+1,k = n-1;
        while(j<k)
        {
          if(Math.abs(x - (arr[i]+arr[j]+arr[k])) < mindiff)
          {
            mindiff = Math.abs(x - (arr[i]+arr[j]+arr[k]));
            if(arr[i]+arr[j]+arr[k] < x)  j++;
            else if(arr[i]+arr[j]+arr[k] > x) k--;
            else  break;
          }
          else
          {
            if(arr[i]+arr[j]+arr[k] < x)  j++;
            else if(arr[i]+arr[j]+arr[k] > x) k--;
            else  break;
          }
        }
      }
      return mindiff;
    }
    public static void main(String args[]) throws IOException 
    {
      
      Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();
      for(int p=0;p<t;p++)
      {
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++)
          arr[i] = sc.nextInt();
        int x = sc.nextInt();
        Arrays.sort(arr);
        System.out.println(difference(arr,n,x));
      }
      
    }
  }