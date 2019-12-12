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
    
    static int[] parent;
    static int[] degree;
    static int[] segemntMinTree;
    static int[] segemntMaxTree;
    public static void main(String[] argh) throws Exception{
        Reader br= new Reader();
        int n= br.nextInt();
        int q= br.nextInt();
        
        parent= new int[n];
        degree= new int[n];
        
        int x = (int) (Math.ceil(Math.log(n) / Math.log(2)));
        int max_size = 2 * (int) Math.pow(2, x) - 1;
        segemntMinTree= new int[max_size];
        segemntMaxTree= new int[max_size];
        for(int i=0; i<n; i++){
            parent[i]= i;
            degree[i]= 1;
        }
        constructSegmentTree(0, n-1, 0);
        
        int prev= 0;
        StringBuilder sb= new StringBuilder();
        for(int i=0; i<q; i++){
            int k1= br.nextInt();
            int k2= br.nextInt();
            k1--;
            k2--;
            int p1= findParent(k1);
            int p2= findParent(k2);
            if(p1 == p2){
            }
            else{
                union(k1, k2);
                int min= rangeMinQuery(0, n-1, 0, n-1, 0);
                int max= rangeMaxQuery(0, n-1, 0, n-1, 0);
                prev= max-min;
            }
            sb.append(prev);
            if(i != q-1) sb.append("\n");
        }
        System.out.print(sb);
    }
    
    private static int rangeMinQuery(int l, int h, int sI, int eI, int pos){
        if(sI>h || eI<l) return Integer.MAX_VALUE;
        if(sI<=l && eI>=h) return segemntMinTree[pos];
        int mid= (l+h) >> 1;
        return (int)Math.min(rangeMinQuery(l, mid, sI, eI, (pos<<1)+1), rangeMinQuery(mid+1, h, sI, eI, (pos<<1)+2));
    }
    
    private static int rangeMaxQuery(int l, int h, int sI, int eI, int pos){
        if(sI>h || eI<l) return Integer.MIN_VALUE;
        if(sI<=l && eI>=h) return segemntMaxTree[pos];
        int mid= (l+h) >> 1;
        return (int)Math.max(rangeMaxQuery(l, mid, sI, eI, (pos<<1)+1), rangeMaxQuery(mid+1, h, sI, eI, (pos<<1)+2));
    }
    
    private static void constructSegmentTree(int l, int h, int pos){
        if(l == h){
            segemntMinTree[pos]= degree[l];
            segemntMaxTree[pos]= degree[l];
            return;
        }
        int mid= (l+h) >> 1;
        constructSegmentTree(l, mid, (pos<<1)+1);
        constructSegmentTree(mid+1, h, (pos<<1)+2);
        segemntMinTree[pos]= (int)Math.min(segemntMinTree[(pos<<1)+1], segemntMinTree[(pos<<1)+2]);
        segemntMaxTree[pos]= (int)Math.max(segemntMaxTree[(pos<<1)+1], segemntMaxTree[(pos<<1)+2]);
    }
    
    private static void updateSegmentTree(int updatePos, int l, int h, int pos, int value){
        if(updatePos > h || updatePos < l) return;
        if(l == h){
            if(updatePos == l){
                if(parent[updatePos] == updatePos){
                    segemntMinTree[pos]= value;
                    segemntMaxTree[pos]= value;
                }
                else{
                    segemntMinTree[pos]= Integer.MAX_VALUE;
                    segemntMaxTree[pos]= Integer.MIN_VALUE;
                }
                return;
            }
        }
        int mid= (l+h)>>1;
        if(mid >= updatePos){
            updateSegmentTree(updatePos, l, mid, (pos<<1)+1, value);
        }
        else{
            updateSegmentTree(updatePos, mid+1, h, (pos<<1)+2, value);
        }
        segemntMinTree[pos]= (int)Math.min(segemntMinTree[(pos<<1)+1], segemntMinTree[(pos<<1)+2]);
        segemntMaxTree[pos]= (int)Math.max(segemntMaxTree[(pos<<1)+1], segemntMaxTree[(pos<<1)+2]);
    }
    
    private static int findParent(int pos){
        if(parent[pos] == pos) return pos;
        return parent[pos]= findParent(parent[pos]);
    }
    
    private static void union(int pos1, int pos2){
        int parent1= findParent(pos1);
        int parent2= findParent(pos2);
        if(parent1 != parent2){
            int a1= degree[parent1];
            int a2= degree[parent2];
            if(a1>a2){
                parent[parent2]= parent1;
                degree[parent1]= a1+a2;
                updateSegmentTree(parent1, 0, parent.length-1, 0, a1+a2);
                updateSegmentTree(parent2, 0, parent.length-1, 0, a1+a2);
            }
            else{
                parent[parent1]= parent2;
                degree[parent2]= a1+a2;
                updateSegmentTree(parent1, 0, parent.length-1, 0, a1+a2);
                updateSegmentTree(parent2, 0, parent.length-1, 0, a1+a2);
            }
        }
    }   
}
