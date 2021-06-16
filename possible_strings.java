/*
Given a string  S consisting of numeric digits and Uppercase alphabets, you can change the alphabets individually 
to lowercase or keep it in uppercase to create a new string. Task is to print the list of all possible strings that
can be created using the above operation.
*/

import java.util.*;
  import java.io.*;
  
  public class Main 
  {
    static void function(String s,int i,Set<String> a)
  	{
  	    if(i==s.length())
  	        return;
  	    s = s.substring(0,i) + s.substring(i,i+1).toUpperCase() + s.substring(i+1,s.length());
  	    function(s,i+1,a);
  	    a.add(s);
  	    s = s.substring(0,i) + s.substring(i,i+1).toLowerCase() + s.substring(i+1,s.length());
  	    function(s,i+1,a);
  	    a.add(s);
  	}
    public static void main(String args[]) throws IOException 
    {
      Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();
      for(int p=0;p<t;p++)
      {
        String s = sc.next();
        Set<String> a = new LinkedHashSet<>();
    		function(s,0,a);
    		for(String i:a)
    		  System.out.print(i + " ");
    		System.out.println();
      }
    }
  }