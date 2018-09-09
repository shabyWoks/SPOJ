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
        int t= br.nextInt();
        for(int aa=0; aa<t; aa++){
            int EP= br.nextInt();
            int FP= br.nextInt();
            int N= br.nextInt();
            ArrayList<Data> coins = new ArrayList<>();
            for(int kk=0; kk<N; kk++){
                coins.add(new Data(br.nextInt(), br.nextInt()));
            }
            Collections.sort(coins);
            int diff= FP - EP;
            int[][] arr = new int[N+1][diff + 1];
            for(int i=1; i<=N; i++){
                for(int j=1; j<=diff; j++){
                    if(j < coins.get(i-1).weight){
                        arr[i][j]= arr[i-1][j];
                    }
                    else{
                        if(i == 1){
                            if((j - coins.get(i-1).weight != 0 && arr[i][j - coins.get(i-1).weight] != 0) || j - coins.get(i-1).weight == 0){
                                arr[i][j] = arr[i][j - coins.get(i-1).weight] + coins.get(i-1).value;
                            }
                            else{
                                arr[i][j] = 0;
                            }
                        }
                        else {
                            if((j - coins.get(i-1).weight != 0 && arr[i][j - coins.get(i-1).weight] != 0) || j - coins.get(i-1).weight == 0){
                                arr[i][j] = Math.min(arr[i][j - coins.get(i-1).weight] + coins.get(i-1).value, arr[i-1][j] == 0 ? Integer.MAX_VALUE : arr[i-1][j]);    
                            }
                            else{
                                arr[i][j] = arr[i-1][j];
                            }
                                
                        }
                    }
                }
            }
            // for(int i=1; i<=N; i++){
            //     for(int j=1; j<=diff; j++){
            //         System.out.print(arr[i][j] + " ");        
            //     }
            //     System.out.println("");
            // }
            if(arr[N][diff] != 0){
                System.out.println("The minimum amount of money in the piggy-bank is " + arr[N][diff]+".");    
            }
            else{
                System.out.println("This is impossible.");
            }
        }
    }
    
    private static class Data implements Comparable<Data>{
        int value;
        int weight;
        public Data(int value, int weight){
            this.value= value;
            this.weight= weight;
        }
        
        public int compareTo(Data d){
            double dt = (double)(d.value/d.weight);
            double t = (double)(this.value/this.weight);
            if(dt > t) return 1;
            else if(dt < t) return -1;
            else return 0;
        }
    }
    
}
