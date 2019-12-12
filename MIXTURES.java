import java.util.*;
import java.io.*;
import java.math.*;
import java.io.InputStream;

class  Solution{
    static int[] arr;
    public static void main(String[] argh) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String inpN= br.readLine();
            if(inpN == null) break;
            int n= Integer.parseInt(inpN.trim());
            String[] inpA= br.readLine().trim().split(" ");
            int[] arr= new int[n+1];
            for(int i=1; i<=n; i++){
                arr[i]= Integer.parseInt(inpA[i-1]);
            }
            int[][] dpColor= new int[n+1][n+1];
            int[][] dpSmoke= new int[n+1][n+1];
            for(int i=1; i<=n; i++) {
                dpColor[i][i]= arr[i];
            }
            for(int i=1; i<n; i++){
                for(int j=1; j<=(n-i); j++){
                    int k= i+j;
                    int minS= Integer.MAX_VALUE;
                    int minC= -1;
                    for(int l= j; l<k; l++){
                        int sm1= dpSmoke[j][l];
                        int sm2= dpSmoke[l+1][k];
                        int sm3= dpColor[j][l] * dpColor[l+1][k];
                        if(minS > sm3+sm2+sm1){
                            minS= sm3+sm2+sm1;
                            minC= (dpColor[j][l] + dpColor[l+1][k])%100;
                        }
                    }
                    dpSmoke[j][k]= minS;
                    dpColor[j][k]= minC;
                }
            }
            System.out.println(dpSmoke[1][n]);
        }   
    }
}
