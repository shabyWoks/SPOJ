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
    static int[] M;
    
    public static void main(String[] argh) throws Exception{
        Reader br= new Reader();
        int t= br.nextInt();
        StringBuilder sb= new StringBuilder();
        for(int tt=0; tt<t; tt++){
            int n= br.nextInt();
            int m= br.nextInt();
            M= new int[n];
            for(int i=0; i<n; i++){
                M[i]= br.nextInt();
            }
            ArrayList<ROAD> roads= new ArrayList<>();
            for(int i=0; i<m; i++){
                roads.add(new ROAD(br.nextInt() - 1, br.nextInt() - 1, br.nextInt()));
            }
            Collections.sort(roads);
            
            parent= new HashMap<>();
            long sum= 0;
            for(int i=0; i<m; i++){
                ROAD r= roads.get(i);
                int p1= findParent(r.n1);
                int p2= findParent(r.n2);
                if(p1 != p2 && (M[p1] == 0 || M[p2] == 0)){
                    union(r.n1, r.n2);
                    sum += (long)r.cost;
                }
            }
            boolean flag= total();
            if(flag == true){
                sb.append(sum);
            }
            else{
                sb.append("impossible");
            }
            if(tt != t) sb.append("\n");
        }
        System.out.print(sb);
    }
    
    private static int findParent(int pos){
        if(!parent.containsKey(pos)){
            parent.put(pos, pos);
            return pos;
        }
        if(parent.get(pos) == pos){
            return pos;
        }
        
        int p= findParent(parent.get(pos));
        parent.put(pos, p);
        return p;
    }
    
    private static boolean total(){
        for(Map.Entry<Integer, Integer> entry: parent.entrySet()){
            int key= entry.getKey();
            int p= findParent(key);
            if(M[p] == 0) return false;
        }
        int mLen= M.length;
        for(int i=0; i<mLen; i++){
            if(M[i] == 0){
                if(!parent.containsKey(i)) return false;
            }
        }
        return true;
    }
    
    private static void union(int pos1, int pos2){
        int parent1= findParent(pos1);
        int parent2= findParent(pos2);
        
        if(parent1 != parent2){
            if(M[parent1] == 1){
                parent.put(parent2, parent1);
            }
            else{
                parent.put(parent1, parent2);
            }
        }
    }
    
    private static class ROAD implements Comparable<ROAD>{
        int n1;
        int n2;
        int cost;
        public ROAD(int n1, int n2, int cost){
            this.n1= n1;
            this.cost= cost;
            this.n2= n2;
        }
        public int compareTo(ROAD r){
            if(this.cost < r.cost) return -1;
            else if(this.cost > r.cost) return 1;
            else return 0;
        }
    }
}
