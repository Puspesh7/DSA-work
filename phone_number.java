/*
You are given a string containing numeric digits from 2 to 9 inclusive, return all
possible letter combinations that the number could represent in lexicographical order.
A mapping of digit to letters (just like on the mobile dial-pad) is given below. Note that
0 and 1 does not map to any letters.
*/


import java.util.*;
  import java.io.*;
  
  public class Main 
  {
    static void phone_number(String s,String s1,int i,String arr[])
    {
      if(i == s.length())
      {
        System.out.print(s1 + " ");
        return;
      }
      int y = Character.getNumericValue(s.charAt(i));
      for(int j=0;j<arr[y].length();j++)
      {
        int x = Character.getNumericValue(s.charAt(i));
        s1 += arr[x].charAt(j);
        phone_number(s,s1,i+1,arr);
        s1 = s1.substring(0,s1.length()-1);
      }
    }
    public static void main(String args[]) throws IOException 
    {
      Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();
      for(int p=0;p<t;p++)
      {
        String s = sc.next();
        String s1 = "";
        String arr[] = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        phone_number(s,s1,0,arr);
        System.out.println();
      }
    }
  }