/*
One day some guests came to Aman's home. Aman's mama told him to bring N
items from the market and gave him a bag, but the bag can hold a maximum weight
of W units. Every item has some weight Wi and a value Vi.Aman has to put these
items in the bag such that the total value is maximized.
Note:Aman can break items for maximizing the total value of the bag.
*/

import java.util.*;
  import java.io.*;
  
  public class Main 
  {
    static boolean check(ArrayList<Double> ratio)
    {
      for(double i : ratio)
      {
        if(i != 0)  return true;
      }
      return false;
    }
    static void maximum_value(ArrayList<Integer> value,ArrayList<Integer> weight,ArrayList<Double> ratio,int w)
    {
      int x = 0;
      double profit = 0;
      while(x < w && check(ratio) == true)
      {
        int i = ratio.indexOf(Collections.max(ratio));
        if(x + weight.get(i) > w)
        {
          profit = profit + (((double)w-x) * ((double)value.get(i)/weight.get(i)));
          x = w;
        }
        else
        {
          x += weight.get(i);
          profit = profit + (double)value.get(i);
        }
        ratio.set(i,0.0);
      }
      System.out.println(Math.round(profit));
      
    }
    public static void main(String args[]) throws IOException 
    {
      
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      int w = sc.nextInt();
      ArrayList<Integer> value = new ArrayList<>();
      ArrayList<Integer> weight = new ArrayList<>();
      ArrayList<Double> ratio = new ArrayList<>();
      for(int i=0;i<n;i++)
      {
        value.add(sc.nextInt());
        weight.add(sc.nextInt());
        ratio.add((double)value.get(i)/weight.get(i));
      }
      maximum_value(value,weight,ratio,w);
    }
  }