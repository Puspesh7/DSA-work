/*
You are given postfix representation of an algebraic expression. Your task is to evaluate the expression and output the result.

Postfix expression contains, space separated +, -, /, * and integer numbers Ai.
*/

import java.util.*;
  import java.io.*;
  
  public class Main 
  {
    static int postfix(String arr[])
    {
      Stack<Integer> s = new Stack<Integer>();
      for(int i=0;i<arr.length;i++)
      {
        char c = arr[i].charAt(0);
        if(c=='+')
        {
          int a=0,b=0;
          if(!s.empty())  a = s.pop();
          if(!s.empty())  b = s.pop();
          s.push(a+b);
        }
        else if(c=='-')
        {
          int a=0,b=0;
          if(!s.empty())  a = s.pop();
          if(!s.empty())  b = s.pop();
          s.push(b-a);
        }
        else if(c=='*')
        {
          int a=0,b=0;
          if(!s.empty())  a = s.pop();
          if(!s.empty())  b = s.pop();
          s.push(a*b);
        }
        else if(c=='/')
        {
          int a=0,b=0;
          if(!s.empty())  a = s.pop();
          if(!s.empty())  b = s.pop();
          s.push(b/a);
        }
        else
        {
          int out = Integer.valueOf(arr[i]);
          s.push(out);
        }
      }
      if(!s.empty())  return  s.pop();
      return  0;
    }
    public static void main(String args[]) throws IOException 
    {
      
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      String arr[] = new String[n];
      for(int i=0;i<n;i++)
      {
        arr[i] = sc.next();
      }
      System.out.println(postfix(arr));
    }
  }