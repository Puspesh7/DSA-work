/*
One day Aman went to the office and his boss gave him some tasks to finish within the given deadline and told him 
to earn maximum profit. Boss gave him a set of N task where each task(i) has a deadline and profit associated with it. 
Each task takes 1 unit of time to complete and only one job can be scheduled at a time. Aman can earn the profit if and 
only if the job is completed by its deadline. Aman has to find the maximum profit but he doesn't know how to maximize profit 
so he asks for your help.
*/

import java.util.*;
  import java.io.*;
  
  public class Main 
  {
    static int profit_priority(ArrayList<Integer> deadline,ArrayList<Integer> profit,ArrayList<Integer> sorted_profit)
    {
      ArrayList<Integer> selected_deadline = new ArrayList<>();
      int max = 0;
      for(int i=0;i<sorted_profit.size();i++)
      {
        int temp = deadline.get(profit.indexOf(sorted_profit.get(i)));
        if(!selected_deadline.contains(temp))
        {
          selected_deadline.add(temp);
          max += sorted_profit.get(i);
        }
        else
        {
          for(int j=temp;j>=1;j--)
          {
            if(!selected_deadline.contains(j))
            {
              selected_deadline.add(j);
              max += sorted_profit.get(i);
              break;
            }
          }
        }
        profit.set(profit.indexOf(sorted_profit.get(i)),-1);
      }
      return max;
    }
    public static void main(String args[]) throws IOException 
    {
      
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      ArrayList<Integer> deadline = new ArrayList<>();
      ArrayList<Integer> profit = new ArrayList<>();
      ArrayList<Integer> sorted_profit = new ArrayList<>();
      for(int i=0;i<n;i++)
      {
        int x = sc.nextInt();
        deadline.add(sc.nextInt());
        profit.add(sc.nextInt());
        sorted_profit.add(profit.get(i));
      }
      Collections.sort(sorted_profit,Collections.reverseOrder());
      //System.out.println(sorted_profit);
      System.out.println(profit_priority(deadline,profit,sorted_profit));
    }
  }