//Complete this code or write your own from scratch
import java.util.*;
import java.io.*;
import java.math.*;

class Solution{
    
    static class Reader
    {
        final private int BUFFER_SIZE = 1 << 16;
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
            byte[] buf = new byte[250]; // line length 
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
            int n= br.nextInt();
            if(n == 0) break;
            String s = br.readLine();
            String newString= "";
            int r= s.length() / n;
            for(int i=0; i<n; i++){
                for(int j=0; j<r; j++){
                    if(j % 2 ==0){
                        int pos = (j*n) + (i);
                        newString += s.charAt(pos);    
                    }
                    else{
                        int pos = (j*n) + (n-i-1);
                        newString += s.charAt(pos); 
                    }
                }
            }
            System.out.println(newString);
        }
    }   
}
