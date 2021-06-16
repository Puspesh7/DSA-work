// Program to reverse a queue

import java.util.*;
  import java.io.*;
  
  public class Main {
    public static void main(String args[]) throws IOException 
    {
      
      Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();
      for(int p=0;p<t;p++)
      {
        Queue<Integer> q = new LinkedList<Integer>();
        int n = sc.nextInt();
        for(int i=0;i<n;i++)
        {
          int a = sc.nextInt();
          q.add(a);
        }
        Stack<Integer> s = new Stack<Integer>();
        while(!q.isEmpty()) s.push(q.remove());
        while(!s.empty()) System.out.print(s.pop() + " ");
        System.out.println();
      }
      
    }