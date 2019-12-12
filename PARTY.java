//Complete this code or write your own from scratch
import java.util.*;
import java.io.*;
import java.math.*;

class Solution{
    
    static class Reader
    {
        final private int BUFFER_SIZE = 1 << 25;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;
 
        public Reader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }
        public String readLine() throws IOException 
        { 
            byte[] buf = new byte[1280000]; // line length 
            int cnt = 0, c; 
            while ((c = read()) != -1) 
            { 
                if (c == '\n') 
                    break; 
                buf[cnt++] = (byte) c; 
            } 
            return new String(buf, 0, cnt); 
        } 
        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }
        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do
            {
                ret = ret * 10 + c - '0';
            }  while ((c = read()) >= '0' && c <= '9');
 
            if (neg)
                return -ret;
            return ret;
        }
    }
    public static void main(String []argh) throws Exception{
        Reader br = new Reader();
        while(true){
            int total= br.nextInt();
            int n= br.nextInt();
            if(total == 0 && n == 0) break;
            ArrayList<Party> lParty= new ArrayList<>();
            for(int aa=0; aa<n; aa++){
                Party p= new Party(br.nextInt(), br.nextInt());
                lParty.add(p);
            }
            int max= Integer.MIN_VALUE;
            int mI= -1;
            int[][] dp= new int[n][total];
            Collections.sort(lParty);
            for(int i=0; i<n; i++){
                for(int j=0; j<total; j++){
                    if(i == 0){
                        if(lParty.get(i).entrance <= (j+1)){
                            dp[i][j]= lParty.get(i).fun;
                            
                        }
                    }
                    else{
                        if(j == 0){
                            if(lParty.get(i).entrance <= (j+1)){
                                dp[i][j] = (int)Math.max(dp[i-1][j], lParty.get(i).fun);
                            }
                            else{
                                dp[i][j] = dp[i-1][j];
                            }
                        }
                        else{
                            if(lParty.get(i).entrance <= (j+1)){
                                int val = 0;
                                if(j+1 -lParty.get(i).entrance > 0){
                                    val= dp[i-1][j - lParty.get(i).entrance];
                                }
                                
                                dp[i][j] = (int)Math.max(dp[i-1][j], lParty.get(i).fun + val);
                            }
                            else{
                                dp[i][j] = dp[i-1][j];
                            }
                        }
                    }
                    if(dp[i][j] > max){ 
                        mI= j+1;
                        max= dp[i][j];
                    }
                }
            }
            System.out.println(mI + " " + max);
        }
    }
    
    private static class Party implements Comparable<Party>{
        int entrance;
        int fun;
        public Party(int et, int fn){
            this.entrance= et;
            this.fun= fn;
        }
        
        public int compareTo(Party p){
            double f1= (double)p.fun/p.entrance;
            double f2= (double)this.fun/this.entrance;
            if(f1>f2) return -1;
            else if(f1<f2) return 1;
            else return 0;
        }
    }
    
}
