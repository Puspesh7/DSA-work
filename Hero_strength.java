/*
PrepBuddy has N heroes and a villain. Heroes have some strength and so does villain.
PrepBuddy has to pick up 4 heroes to defend him and the sum of the strength of
chosen heroes should be equal to the strength of the villain.Find all the unique set of heroes 
which can defend him.You can choose different heroes with same strength, but the overall set should not repeat.
*/

import java.util.*;
  import java.io.*;
  
  public class Main 
  {
    static LinkedHashSet<ArrayList<Integer>> strength = new LinkedHashSet<>(); 
    
    static void add_subset(int subset[])
    {
      ArrayList<Integer> l = new ArrayList<>();
      for(int i:subset)
        l.add(i);
      strength.add(l);
    }
    static void find_subset(int arr[],int n,int subset[],int subset_size,int sum,int iterator,int target_sum)
    {
      if(subset_size == 4)
      {
        if(sum == target_sum)
        {
          add_subset(subset);
          //find_subset(arr,n,subset,subset_size-1,sum-arr[iterator],iterator+1,target_sum);
        }
        //find_subset(arr,n,subset,subset_size-1,sum-arr[iterator],iterator+1,target_sum);
      }
      else
      {
        for(int i=iterator;i<n;i++)
        {
          subset[subset_size] = arr[i];
          find_subset(arr,n,subset,subset_size+1,sum+arr[i],i+1,target_sum);
        }
      }
    }
    static void get_subsets(int n,int arr[],int target_sum)
    {
      int subset[] = new int[4];
      find_subset(arr,n,subset,0,0,0,target_sum);
    }
    public static void main(String args[]) throws IOException 
    {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      int arr[] = new int[n];
      for(int i=0;i<n;i++)
        arr[i] = sc.nextInt();
      int s = sc.nextInt();
      Arrays.sort(arr);
      get_subsets(n,arr,s);
      for(ArrayList i:strength)
      {
        System.out.println(i.get(0) + " " + i.get(1) + " " + i.get(2) + " " + i.get(3));
      }
    }
  }