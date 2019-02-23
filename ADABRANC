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
    
    static int[] disArray;
    static int[] disSize;
    static int N;
    
    public static void main(String []argh) throws Exception{
        Reader br = new Reader();
        
            N = br.nextInt();
        int M = br.nextInt();
        int Q = br.nextInt();
        
            disArray    = new int[N];
            disSize     = new int[N];
            
        int[] result    = new int[Q];
                
        initArray(N);
        
        ArrayList<Set> list = new ArrayList<>();
                
        for (int i=0; i<M; i++) {
            int A = br.nextInt();
            int B = br.nextInt();
            int X = br.nextInt();
            list.add(new Set(0, -1, A, B, X));
        }
        
        for (int i=0; i<Q; i++) {
            int A = br.nextInt();
            int Y = br.nextInt();
            list.add(new Set(1, i, A, -1, Y));
        }
        
        Collections.sort(list);
        
        int len = list.size();
        for (int i=0; i<len; i++) {
            Set set = list.get(i);
            if(set.type == 0) {
                union(set.a, set.b);
            }
            else {
                result[set.id] = disSize[findParent(set.a)];
            }
        }
        
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<Q; i++) {
            sb.append(result[i] + "\n");
        }
        
        System.out.print(sb);
        
    }
    
    private static void initArray(int N) {
        for (int i=0; i<N; i++) {
            disArray[i] = i;
            disSize[i]  = 1;
        }
    }
    
    private static int findParent(int pos) {
        if (pos == disArray[pos]) return pos;
        disArray[pos] = findParent(disArray[pos]);
        return disArray[pos];
    }
    
    private static void union(int pos1, int pos2) {
        int parent1 = findParent(pos1);
        int parent2 = findParent(pos2);
        
        if (parent1 == parent2) return;
        
        int l = parent1 > parent2 ? parent2 : parent1;
        int h = parent1 > parent2 ? parent1 : parent2;
        
        disArray[h] = l;
        disSize[l] += disSize[h];
        disSize[h] = 0;
    }
    
    static class Set implements Comparable<Set> {
        int type;
        int id;
        int a;
        int b;
        int w;
        
        public Set (int type, int id, int a, int b, int w) {
            this.type   = type;
            this.id     = id;
            this.a      = a;
            this.b      = b;
            this.w      = w;
        }
        
        public int compareTo (Set s) {
            if (this.w > s.w) return -1;
            if (this.w < s.w) return 1;
            if (this.type < s.type) return -1;
            if (this.type > s.type) return 1;
            return 0;
        }
    }
}
