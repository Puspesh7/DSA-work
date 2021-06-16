/*
Recently PrepBuddy received an mail, in it an IP address was present. He noted down
the numbers but ignored the '.' sign. Now PrepBuddy's boss called him and asked him
to establish a connection with that IP address.But Now PrepBuddy has only digits, not the address.
 Help PrepBuddy find all the valid IP address that can be formed using those digits.
 A valid IP address must be in the form of A1.A2.A3.A4 where A1,A2,A3,A4 are numbers in the range of
 0-255 and the numbers cannot be 0-prefixed unless they are 0.
*/

import java.util.*;
  import java.io.*;
  
  public class Main 
  {
    static void check(String str)
    {
      int j = 0,flag = 0;
      for(int i=0;i<str.length();i++)
      {
        if(i+1 == str.length() || str.charAt(i+1) == '.')
        {
          String str1 = str.substring(j,i+1);
          if(Integer.parseInt(str1) > 255 || (str.charAt(j) == '0' && str1.length()!= 1))
          {
            flag = 1;
            break;
          }
          else  j = i+2;
        }
      }
      if(flag != 1)
        System.out.println(str);
    }
    static void function(String s,String str,int count,int i)
    {
      if(i<s.length())
      {
        if(count == 4)
        {
          str += s.substring(i,s.length());
          check(str);
        }
        if(i+1 <= s.length()) function(s,str+s.substring(i,i+1)+".",count+1,i+1);
        if(i+2 <= s.length()) function(s,str+s.substring(i,i+2)+".",count+1,i+2);
        if(i+3 <= s.length()) function(s,str+s.substring(i,i+3)+".",count+1,i+3);
      }
    }
    public static void main(String args[]) throws IOException 
    {
      Scanner sc = new Scanner(System.in);
      String s = sc.next();
      function(s,"",1,0);
    }
  }