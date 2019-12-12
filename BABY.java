import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
    static int[] chessnew;
    static int[] chessold;
    static int row;
    static int[] dp= new int[1<<17];
    static int n;
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        while(true){
            n= Integer.parseInt(br.readLine().trim());
            //System.out.println(0 | 1<<0);
            if(n == 0) break;
            int dia= 2*n - 1 ;
            String[] org= br.readLine().trim().split(" ");
            String[] chg= br.readLine().trim().split(" ");
            chessold= new int[n];
            chessnew= new int[n];
            row= 0;
            Arrays.fill(dp, -1);
            int sum= 0;
            for(int i=0; i<n; i++){
                chessold[i]= Integer.parseInt(org[i]);
                chessnew[i]= Integer.parseInt(chg[i]);
            }
            System.out.println(baby(0));
        }
        
	}
    private static int baby(int rowNo){
        if(rowNo == n) return 0;
        if(dp[row] != -1) return dp[row];
        int min= Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            if((row&(1<<i)) == 0){
                row= row|(1<<i);
                int val= Math.abs(i-rowNo) + Math.abs(chessold[rowNo] - chessnew[i]);
                val= val + baby(rowNo + 1);
                if(min > val) min= val;
                row= row & ~(1<<i);
            }
        }
        return dp[row]= min;
    }
        
}
