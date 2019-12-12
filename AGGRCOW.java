import java.util.*;
import java.io.*;

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
        int t = br.nextInt();
        for(int aq=0; aq<t; aq++){
            int N= br.nextInt();
            int C= br.nextInt();
            int[] arr= new int[N];
            for(int bq=0; bq<N; bq++){
                arr[bq] = br.nextInt();
            }
            Arrays.sort(arr);
            int start= 0;
            int end= arr[N-1] - arr[0] + 1;
            int mid;
            while(end-start > 1){
                mid= (end+start)>>1;
                if(canPlaceCows(mid, arr, C) == 1){ start = mid; }
                else {end = mid;}
            }
            System.out.println(start);
        }
    }
    
    private static int canPlaceCows(int x, int[] pos, int C){
        int N= pos.length;
        int cowsplaced=1,lastpos=pos[0];
        for(int i=1;i<N;i++)
        {
            if(pos[i]-lastpos>=x)
            {
                if(++cowsplaced==C) return 1;
                lastpos=pos[i];
            }
        }
        return 0;
    }
}
