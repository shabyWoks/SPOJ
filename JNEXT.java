//Complete this code or write your own from scratch
import java.util.*;
import java.io.*;
import java.math.*;

class Solution{
    static String s;
    static StringBuilder sb;
    static int breakPoint;
    static int mI;
    public static void main(String[] argh) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int t= Integer.parseInt(br.readLine().trim());
        for(int aa=0; aa<t; aa++){
            int n= Integer.parseInt(br.readLine().trim());
            sb = new StringBuilder(br.readLine().trim().replace(" ", ""));
            breakPoint= -1;
            mI= -1;
            int min= Integer.MAX_VALUE;
            for(int qq=n-1; qq>0; qq--){
                if(sb.charAt(qq) > sb.charAt(qq-1)){
                    breakPoint= qq-1;
                    break;
                }
            }
            if(breakPoint == -1 || n == 1){
                System.out.println(-1);
                continue;
            }
            for(int qq=n-1; qq>breakPoint; qq--){
                if(sb.charAt(breakPoint) < sb.charAt(qq)){
                    if(min > Integer.parseInt(sb.charAt(qq)+"")){
                        min= Integer.parseInt(sb.charAt(qq)+"");
                        mI= qq;
                    }
                }
            }
            char c1= sb.charAt(mI);
            char c2= sb.charAt(breakPoint);
            sb.setCharAt(breakPoint, c1);
            sb.setCharAt(mI, c2);
            breakPoint++;
            int len= n - breakPoint;
            for(int ii=breakPoint; ii<breakPoint+(len/2); ii++){
                c1= sb.charAt(n-ii-1+breakPoint);
                c2= sb.charAt(ii);
                sb.setCharAt(ii, c1);
                sb.setCharAt(n-ii-1+breakPoint, c2);
            }
            System.out.println(sb);
        }
    }
}
