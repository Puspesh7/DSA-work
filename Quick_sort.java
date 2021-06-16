/* Quick Sort ALgorithm*/

import java.util.*;
  import java.io.*;
  
  public class Main 
  {
    static int partition(int arr[],int low,int high)
    {
      int pivot = arr[high],i=low-1,temp;
      for(int j=low;j<=high-1;j++)
      {
        if(arr[j] <= pivot)
        {
          i++;
          temp = arr[i];
          arr[i] = arr[j];
          arr[j] = temp;
        }
      }
      temp = arr[i+1];
      arr[i+1] = arr[high];
      arr[high] = temp;
      return i+1;
    }
    
    static void quicksort(int arr[],int low,int high)
    {
      if(low > high)  return;
      int pivot = partition(arr,low,high);
      quicksort(arr,low,pivot-1);
      quicksort(arr,pivot+1,high);
    }
    public static void main(String args[]) throws IOException 
    {
      
      Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();
      for(int p=0;p<t;p++)
      {
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++)
          arr[i] = sc.nextInt();
        quicksort(arr,0,n-1);
        for(int i:arr)  System.out.print(i + " ");
        System.out.println();
      }
    }
  }