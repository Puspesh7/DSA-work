/*
  write a code to determine molecular weight of given formula.
  Weight of given formula is the sum of all its atoms so if Molecule of COOH or CO2H or (CO)(OH), its weight would be
  12+16+16+1 which is 45.
*/

import java.util.*;
  import java.io.*;
  
  public class Main 
  {
    static String mass(char c)
    {
      if(c=='O')  return "16";
      else if(c=='C') return "12";
      else if(c=='(') return "(";
      else return "1";
    }
    static int molecular_mass(String s)
    {
      Stack <String> stack = new Stack<String>();
      for(int i=0;i<s.length();i++)
      {
        if(Character.isDigit(s.charAt(i)))
        {
          int a = Integer.valueOf(stack.pop());
          stack.push(String.valueOf(a*Character.getNumericValue(s.charAt(i))));
        }
        else if(s.charAt(i) == ')')
        {
          int total=0;
          while(stack.peek().charAt(0) != '(')  total += Integer.valueOf(stack.pop());
          stack.pop();
          stack.push(String.valueOf(total));
        }
        else  stack.push(mass(s.charAt(i)));
      }
      int sum = 0;
      while(!stack.empty())
      {
        if(stack.peek().charAt(0) != '(' && stack.peek().charAt(0) != ')')
          sum += Integer.valueOf(stack.pop());
        else  stack.pop();
      }
      return  sum;
    }
    public static void main(String args[]) throws IOException 
    {
      
      Scanner sc = new Scanner(System.in);
      String s = sc.next();
      System.out.println(molecular_mass(s));
    }
  }