/*
Nikhil is now transferring the data to his boss but he is getting hacked by a man in the middle. The hacker just changes the 
case of some characters of the message. If some characters are in lowercase the hacker changes them to upper case and vice versa. 
Now Nikhil wonders how many different changed messages his boss might get, so he wants to know them all.
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
      String s = sc.next();
      Set<String> a = new LinkedHashSet<>();
  		function(s,0,a);
  		for(String i:a)
  		  System.out.println(i);
    }
  }