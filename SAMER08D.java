import java.util.*;
import java.io.*;
import java.math.*;
import java.io.InputStream;

class  Solution{
    public static void main(String[] argh) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringBuilder kb= new StringBuilder();
        while(true){
            String inpN= br.readLine().trim();
            int n= Integer.parseInt(inpN);
            if(n == 0) break;
            String s1= br.readLine().trim();
            String s2= br.readLine().trim();
            int sl1= s1.length();
            int sl2= s2.length();
            
            int[][] len= new int[sl1 + 1][sl2 + 1];
            
            for(int i=1; i<=sl1; i++){
                for(int j=1; j<=sl2; j++){
                    int c=1;
                    while(i-c>=0 && j-c>=0 && s1.charAt(i-c) == s2.charAt(j-c)){
                        if(c>=n){
                            len[i][j]= Math.max(len[i][j], c + len[i-c][j-c]);
                        }
                        c++;
                    }
                    len[i][j]= Math.max(len[i][j], len[i-1][j]);
                    len[i][j]= Math.max(len[i][j], len[i][j-1]);
                }
            }
            kb.append(len[sl1][sl2] + "\n");
        }
            
        System.out.print(kb);
        
    }
    
}
