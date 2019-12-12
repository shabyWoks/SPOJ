import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
    static long invCount= 0;
	public static void main (String[] args) throws java.lang.Exception
	{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            br.readLine();
            int l= Integer.parseInt(br.readLine().trim());
            int[] arr= new int[l];
            for(int j=0; j<l; j++){
                arr[j]= Integer.parseInt(br.readLine().trim());
            }
            
            invCount= 0;
            int mid= (0 + (arr.length - 1))/2;
            mergeSort(arr,0, mid, mid +1 , arr.length - 1);
            System.out.println(invCount);
        }
    }
    
    private static void mergeSort(int[] arr, int s1, int e1, int s2, int e2){
        if(e1-s1+1 > 1){
            int mid= (s1 + e1) / 2;
            mergeSort(arr, s1, mid, mid+1, e1);
        }
        if(e2-s2+1  > 1){
            int mid= (s2 + e2) / 2;
            mergeSort(arr, s2, mid, mid+1, e2);
        }
        
        int[] aS= new int[e2 - s1 + 1];
        int s1c= s1;
        int i=0;
        while(s1 <= e1 && s2 <= e2){
            if(arr[s1] > arr[s2]){
                aS[i++]= arr[s2];
                invCount= invCount + (long)(e1 - s1 + 1);
                s2++;
            }
            else{
                aS[i++]= arr[s1];
                s1++;
            }
        }
        
        if(s1 > e1 && s2 <= e2){
            while(s2<=e2){
                aS[i++]= arr[s2++];
            }
        }
        else if(s1 <= e1 && s2 > e2){
            while(s1<=e1){
                aS[i++]= arr[s1++];
            }
        }
        
        
        int c=0;
        while((i--) != 0){
            arr[s1c++]= aS[c++];
        }
    }
    
}
