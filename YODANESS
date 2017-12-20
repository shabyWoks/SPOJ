import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
    
	public static void main (String[] args) throws java.lang.Exception
	{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int t= Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++){
            int n= Integer.parseInt(br.readLine());
            String[] ch= br.readLine().trim().split(" ");
            String[] og= br.readLine().trim().split(" ");
            int[] arr= new int[n];
            HashMap<String, Integer> map= new HashMap<>();
            for(int j=0; j<n; j++){
                map.put(og[j], j+1);
            }
            for(int j=0; j<n; j++){
                arr[j]= map.get(ch[j]);
            }
            int mid= n/2;
            long sum= 0;
            sum= mergeSort(arr, 0, mid, mid + 1, n-1);
            System.out.println(sum);
        }
    }
    
    private static long mergeSort(int[] arr, int s1, int e1, int s2, int e2){
        long sum= 0;
        if(e1-s1+1 > 1){
            int mid= (s1 + e1)/2;
            sum += mergeSort(arr, s1, mid, mid + 1, e1);
        }
        if(e2-s2+1 > 1){
            int mid= (s2 + e2)/2;
            sum += mergeSort(arr, s2, mid, mid + 1, e2);
        }
        
        int l= e2-s1+1;
        //System.out.println("Length= " + l);
        int[] aS= new int[l];
        int x= s1, y= s2;
        int i=0;
        while(s1<=e1 && s2<=e2){
            if(arr[s1] > arr[s2]){
                aS[i++]= arr[s2++];
                sum += (e1-s1+1);
            }
            else{
                aS[i++]= arr[s1++];
            }
        }
        
        if(s1 > e1 && s2 <= e2){
            while(s2<=e2){
                aS[i++]= arr[s2++];
            }
        }
        else if(s2 > e2 && s1 <= e1){
            while(s1<=e1){
                aS[i++]= arr[s1++];
            }
        }
        int k=0;
        for(i=0; i<l; i++){
            arr[x+i]= aS[k++];
        }
        return sum;
    }
}
