/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    static int n;
    static int[] arr;
	  public static void main (String[] args) throws java.lang.Exception
	  {
        StringBuilder sb= new StringBuilder();
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        while(true){
            n= Integer.parseInt(br.readLine().trim());
            if(n == 0) break;
            arr= new int[n];
            String[] inp= br.readLine().trim().split(" ");
            for(int i=0; i<n; i++){
              arr[i]= Integer.parseInt(inp[i]);
            }
            Arrays.sort(arr);
            int len= sum(n-1);
            int[] pairSum= new int[len];
            int[] pairPos= new int[len];
            int c= 0;
            for(int i=0; i<n; i++){
                for(int j=i+1; j<n; j++){
                    pairSum[c] = (arr[i] + arr[j]);
                    pairPos[c] = j;
                    c++;
                }
            }
            long sum= 0;
            for(int i=0; i<len; i++){
                int pS= pairSum[i];
                int pVal= binarySearch(pS, pairPos[i] + 1);
                sum += (n-pVal);
            }
            sb.append(sum+"\n");
		    }
		    System.out.print(sb);
	  }
	
    private static int sum(int n){
        return (n*(n+1)) >> 1;
    }
	
    private static int binarySearch(int val, int sI){
        int l= sI;
        int h= arr.length-1;
        int mid;
        while(l<=h){
            mid= (l+h) >> 1;
            if(arr[mid] > val){
                h= mid - 1;
            }
            else if(arr[mid] <= val){
                l= mid + 1;
            }
        }
        return l;
    }
}
