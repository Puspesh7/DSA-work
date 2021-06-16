/*
You have a truck that has to cover a circular route and along this route are N gas
stations and the amount of gas at each station is gas[i].You are also given a cost array where cost[i]
denotes the amount of gas required to travel from station i to i+1.The tank of the truck has unlimited 
capacity to store gas but if at any point the amount of gas in the truck is less than the cost[i], then the truck can not move further.
Consider gas stations are from index 0 to N-1 and you can start the ride from any index such that the truck completes the ride along the circular route once in the clockwise direction.

Print the index from where the truck can start if there is no such route possible print -1
*/

import java.util.*;
  import java.io.*;
  
  public class Main 
  {
    static int circular_route(int gas[],int cost[],int n)
    {
      int start=0,end=1;
      int curr_petrol = gas[start] - cost[start];
      while(end != start || curr_petrol < 0) 
      { 
        while(curr_petrol < 0 && start != end) 
        { 
            curr_petrol -= gas[start] - cost[start]; 
            start = (start + 1) % n; 
            if(start == 0) 
                return -1; 
        } 
        curr_petrol += gas[end] - cost[end]; 
          
        end = (end + 1)%n; 
      } 
      return start;
    }
    public static void main(String args[]) throws IOException 
    {
      
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      int gas[] = new int[n];
      int cost[] = new int[n];
      for(int i=0;i<n;i++)
        gas[i] = sc.nextInt();
      for(int i=0;i<n;i++)
        cost[i] = sc.nextInt();
      System.out.println(circular_route(gas,cost,n));
    }
  }