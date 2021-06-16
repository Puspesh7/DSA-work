/*
Nikhil wants to bring sofa(s) to his room. But he wants to dedicate the entire length of the room to the sofa(s) (yes I know he is a bit weird).
Now Nikhil's room length is W meters, and when he went to the shop he found out sofas of two types, one of length N ans other of length M.
Now, let Nikhil know how many sofas of the first and second type he should buy to reduce wastage of space. First minimize the space wastage 
then, if similar result arises always prefer the sofa with a larger length. In case N==M give preference to second sofa.
*/

import java.util.*;
  import java.io.*;
  
  public class Main 
  {
    static void dedicate_length(int arr_1[],int arr_2[],int n,int m,int w,int rem)
    {
      if(n>m)
      {
        while(arr_1[0] != 0)
        {
          arr_1[0] -= 1;
          int temp = w - (n*arr_1[0]);
          arr_1[1] = temp/m;
          temp = temp%m;
          if(temp < rem)
          {
            arr_2[0] = arr_1[0];
            arr_2[1] = arr_1[1];
            rem = temp;
          }
        }
      }
      else
      {
        while(arr_1[1] != 0)
        {
          arr_1[1] -= 1;
          int temp = w - (m*arr_1[1]);
          arr_1[0] = temp/n;
          temp = temp%n;
          if(temp < rem)
          {
            arr_2[0] = arr_1[0];
            arr_2[1] = arr_1[1];
            rem = temp;
          }
        }
      }
      System.out.println(arr_2[0] + " " + arr_2[1]);
    }
    public static void main(String args[]) throws IOException 
    {
      Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();
      for(int p=0;p<t;p++)
      {
        int w = sc.nextInt();
        int n = sc.nextInt();
        int m = sc.nextInt();
        int arr_1[] = new int[2];
        int arr_2[] = new int[2];
        int rem = 0;
        if(n > m)
        {
          arr_1[0] = w/n;
          int temp = w%n;
          arr_1[1] = temp/m;
          rem = temp%m;
        }
        else
        {
          arr_1[1] = w/m;
          int temp = w%m;
          arr_1[0] = temp/n;
          rem = temp%n;
        }
        arr_2[0] = arr_1[0];
        arr_2[1] = arr_1[1];
        dedicate_length(arr_1,arr_2,n,m,w,rem);
      }
    }
  }