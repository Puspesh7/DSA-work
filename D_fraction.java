/*
Now Arnab is given a fraction N/D. He is asked to divide the fraction in sum of unique unit fractions where 
N/D = (1/D1) + (1/D2) + (1/D3) + ....+ (1/Dn).Now find the value of
D1,D2,...Dn.
if (1/D1) = 2 then value of Di = 1/2, print it in fraction as 1/2 not as floating point number. 
*/

import java.util.*;
  import java.io.*;
  
  public class Main 
  {
    static void d_fraction(int num,int deno)
    {
      if(deno == 0 || num == 0)
        return;
      if(deno % num == 0)
      {
        System.out.print(deno/num + " ");
        return;
      }
      if(num > deno)
      {
        System.out.print("1/" + num/deno + " ");
        d_fraction(num-(deno*(num/deno)),deno);
        return;
      }
      int n = (deno/num) + 1;
      System.out.print(n + " ");
      d_fraction(num*n - deno,deno*n);
    }
    public static void main(String args[]) throws IOException 
    {
      
      Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();
      for(int p=0;p<t;p++)
      {
        int n = sc.nextInt();
        int d = sc.nextInt();
        d_fraction(n,d);
      }
    }
  }