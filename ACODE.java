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
            String s = br.readLine();
            if(s.equals("0")) break;
            System.out.println(doRec(s));
        }
    }
    
    private static int doRec(String s){
        int n= s.length();
        int[] arr= new int[n+1];
        arr[0] = 1;
        arr[1] = 1;
        for(int i=2; i<=n; i++){
            if(s.charAt(i-1) > '0'){
                arr[i] = arr[i-1];
            }
            if(s.charAt(i-2) == '1' || s.charAt(i-2) == '2' && s.charAt(i-1) < '7'){
                arr[i] += arr[i-2];
            }
        }
        return arr[n];
    }
    
}
