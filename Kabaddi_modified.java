/*
Arnab has made a team and he wants to fight with another team with some modified form of Kabaddi. 
In this game, all the players stand in a line. Now in a turn Arnab's team member can hold and win 
over an player of opposite team upto K distance apart. Each player of Arnab's team can win over only 
one opponent player and upto K distance. Player of Arnab's team is marked by 1 and opponents team is marked by 0.
Find the maximum number of people Arnab's team can win over.
*/

import java.util.*;
  import java.io.*;
  
  public class Main 
  {
    static int kabaddi(ArrayList<Integer> ones,ArrayList<Integer> zeroes,int k)
    {
      if(ones.isEmpty() || zeroes.isEmpty())
        return 0;
      int count = 0,j=0,temp = 0;
      for(int i=0;i<ones.size();i++)
      {
        int flag = 0;
        while(j<zeroes.size())
        {
          if(Math.abs(ones.get(i) - zeroes.get(j++)) <= k)
          {
            temp = j;
            count++;
            flag = 1;
            break;
          }
        }
        if(j >= zeroes.size() && flag == 0)
          j = temp;
      }
      return count;
    }
    public static void main(String args[]) throws IOException 
    {
      
      Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();
      for(int p=0;p<t;p++)
      {
        String s = sc.next();
        int k = sc.nextInt();
        ArrayList<Integer> ones = new ArrayList<>();
        ArrayList<Integer> zeroes = new ArrayList<>();
        for(int i=0;i<s.length();i++)
        {
          if(s.charAt(i) == '0')
            zeroes.add(i);
          else
            ones.add(i);
        }
        System.out.println(kabaddi(ones,zeroes,k));
      }
      
    }
  }