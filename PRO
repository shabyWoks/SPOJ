import java.util.*;
import java.io.*;
import java.math.*;
import java.io.InputStream;

class  Solution{
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
        public long nextLong() throws IOException 
        { 
            long ret = 0; 
            byte c = read(); 
            while (c <= ' ') 
                c = read(); 
            boolean neg = (c == '-'); 
            if (neg) 
                c = read(); 
            do { 
                ret = ret * 10 + c - '0'; 
            } 
            while ((c = read()) >= '0' && c <= '9'); 
            if (neg) 
                return -ret; 
            return ret; 
        } 
    }
    
    static TreeSet<Integer> set;
    static HashMap<Integer, Integer> map;
    public static void main(String[] argh) throws Exception{
        Reader br= new Reader();
        set= new TreeSet<>();
        map= new HashMap<>();
        long sum= 0;
        int n= br.nextInt();
        int k;
        for(int nn=0; nn<n; nn++){
            k= br.nextInt();
            int num, pos;
            if(k != 0){
                for(int kk=0; kk<k; kk++){
                    num= br.nextInt();
                    if(!map.containsKey(num)){
                        map.put(num, 1);
                    }
                    else{
                        map.put(num, map.get(num)+1);
                    }
                    set.add(num);
                }    
            }
            int max= set.last();
            int min= set.first();
            map.put(max, map.get(max) - 1);
            map.put(min, map.get(min) - 1);
            
            if(map.get(max) == 0) set.remove(max);
            if(map.get(min) == 0) set.remove(min);
            
            sum += (long)(max-min);
        }
        System.out.println(sum);
    }
}
