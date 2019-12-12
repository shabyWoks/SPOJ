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

    static HashMap<Integer, Integer> parent;
    static HashMap<Integer, Integer> degree;
    static int n;
    public static void main(String[] argh) throws Exception{
        Reader br= new Reader();
        n= br.nextInt();
        int m= br.nextInt();

        parent= new HashMap<>();
        degree= new HashMap<>();
        
        for(int i=0; i<m; i++){
            int n1= br.nextInt();
            int n2= br.nextInt();
            if(findParent(n1) != findParent(n2)) union(n1, n2);
        }
        System.out.println(totalComponent());
    }
    
    private static int findParent(int pos){
        if(!parent.containsKey(pos) || parent.get(pos) == pos){
            parent.put(pos, pos);
            degree.put(pos, 1);
            return pos;
        }
        int p= findParent(parent.get(pos));
        parent.put(pos, p);
        return p;
    }
    
    private static void union(int pos1, int pos2){
        int posP1= findParent(pos1);
        int posP2= findParent(pos2);
        int a1= degree.get(posP1);
        int a2= degree.get(posP2);
        if(posP1 != posP2){
            if(a1 > a2){
                parent.put(posP2, posP1);
                degree.put(posP1, a1 + a2);
            }
            else{
                parent.put(posP1, posP2);
                degree.put(posP2, a1 + a2);
            }
        }
    }
    
    private static int totalComponent(){
        HashMap<Integer, Integer> map= new HashMap<>();
        int count= 0;
        for (Map.Entry<Integer, Integer> entry : parent.entrySet()) {
            int key = entry.getKey();
            map.put(findParent(key), 1);
        }
        return n - parent.size() + map.size();
    }
    
}
