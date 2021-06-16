/*
You are given two integers a and b.After that, you will be given q queries each of which contains two integers low and high.
Let’s define S as the set of common divisors of a and b which lie in the range low to high i.e. low <= d <= high.Find the maximum
element in this set S or report -1 if no such element is possible.

*/
import java.util.*;
  import java.io.*;
  
  public class Main 
  {
    static int gcd(int a,int b)
    {
      if(b==0) return a;
      return gcd(b,a%b);
    }
    static int division(ArrayList<Integer> arr,int low,int high,int l,int r)
    {
      if(l<=r)
      {
        int m = (l+r)/2;
        if(arr.get(m)>=low && arr.get(m)<=high)
          return Math.max(arr.get(m),division(arr,low,high,m+1,r));
        else
        {
          if(arr.get(m) < low)
            return division(arr,low,high,m+1,r);
          if(arr.get(m) > high)
            return division(arr,low,high,l,m-1);
        }
      }
      return -1;
    }
    public static void main(String args[]) throws IOException 
    {
      
      Scanner sc = new Scanner(System.in);
      int a = sc.nextInt();
      int b = sc.nextInt();
      int c = gcd(a,b);
      ArrayList<Integer> arr = new ArrayList<>();
      for(int i=1;i<=c;i++)
      {
        if(a%i==0 && b%i==0) arr.add(i);
      }
      int q = sc.nextInt();
      for(int j=0;j<q;j++)
      {
        int low = sc.nextInt();
        int high = sc.nextInt();
        System.out.println(division(arr,low,high,0,arr.size()-1));
      }
    }
  }