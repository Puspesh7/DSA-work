/*
Nishant is very poor in studies. So he writes some portions of the answer and marks the rest 
as * or ? (which are wildcards). 
? represents any single character. 
* represents zero or more characters.
Now you are the teacher. Technically you cannot give him 
0 as he is correct in some way.
You have to find out if his answer matches the correct answer or not.
*/

import java.util.*;
  import java.io.*;
  
  public class Main 
  {
    static boolean function(String s,String t,int n,int m)
    {
      boolean [][]lookup = new boolean[n+1][m+1];
      lookup[0][0] = true;
      for(int i=1;i<=n;i++)
        lookup[i][0] = false;
      for(int i=1;i<=m;i++)
      {
        if(t.charAt(i-1) == '*')  lookup[0][i] =  lookup[0][i-1];
      }
      for(int i=1;i<=n;i++)
      {
        for(int j=1;j<=m;j++)
        {
          if(t.charAt(j-1) == '?' || t.charAt(j-1) == s.charAt(i-1))
            lookup[i][j] = lookup[i-1][j-1];
          else if(t.charAt(j-1) == '*')
            lookup[i][j] = lookup[i-1][j] || lookup[i][j-1];
          else
            lookup[i][j] = false;
        }
      }
      return lookup[n][m];
    }
    public static void main(String args[]) throws IOException 
    {
      Scanner sc = new Scanner(System.in);
      String s = sc.next();
      String t = sc.next();
      if(function(s,t,s.length(),t.length()))
        System.out.println("Yes");
      else
        System.out.println("No");
    }
  }