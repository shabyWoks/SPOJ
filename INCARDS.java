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
            byte[] buf = new byte[128]; // line length 
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

    static ArrayList<ArrayList<Data>> arr;
    static ArrayList<ArrayList<Data>> rev;
    public static void main(String []argh) throws Exception{
        Reader br = new Reader();
        int t= br.nextInt();
        for(int aa=0; aa<t; aa++){
            int p= br.nextInt();
            int q= br.nextInt();
            arr = new ArrayList<>();
            rev = new ArrayList<>();
            for(int qq=0; qq<p; qq++){
                arr.add(new ArrayList<Data>());
                rev.add(new ArrayList<Data>());
            }
            for(int qq= 1; qq<=q; qq++){
                int o= br.nextInt();
                int d= br.nextInt();
                int pp= br.nextInt();
                Data d1 = new Data(d-1, pp);
                Data d2 = new Data(o-1, pp);
                arr.get(o-1).add(d1);
                rev.get(d-1).add(d2);
            }
            
            int[] data= dijkstra(arr, p);
            int[] data1= dijkstra(rev, p);
            int sum =0;
            for(int i=1; i<p; i++){
                sum += data[i] + data1[i];
            }
            System.out.println(sum);
        }
    }
    
    static Queue<Data> integerPQ;
    static int[] currPath;
    static int[] distMap;
    static int[] visited;
    private static int[] dijkstra(ArrayList<ArrayList<Data>> arr, int p) {
        currPath = new int[p];
        distMap = new int[p];
        visited = new int[p];
        integerPQ = new PriorityQueue<>();
        for(int zz=0; zz<p; zz++) distMap[zz]= Integer.MAX_VALUE;
        integerPQ.add(new Data(0, 0));
        while(integerPQ.peek() != null) {
            Data dd= integerPQ.poll();
            if(distMap[dd.ind] > dd.cost) {
                distMap[dd.ind] = dd.cost;
                ArrayList<Data> ddd= arr.get(dd.ind);
                for(int kk= 0; kk<ddd.size(); kk++) {
                    int totalPrice= ddd.get(kk).cost + dd.cost;
                    if(distMap[ddd.get(kk).ind] > totalPrice && visited[ddd.get(kk).ind] == 0) {
                        integerPQ.add(new Data(ddd.get(kk).ind, totalPrice));
                    }    
                }  
                visited[dd.ind] = 1;
            }
        }
        return distMap;
    }
    
    private static class Data implements Comparable<Data>{
        int ind;
        int cost;
        
        public Data(int ind, int cost){
            this.ind= ind;
            this.cost= cost;
        }
        
        public int compareTo(Data d){
            if(d.cost > this.cost)return -1;
            else if(d.cost < this.cost) return 1;
            else {
                if(d.ind > this.ind) return -1;
                else if(d.ind < this.ind) return 1;
                else return 0;
            }
                
        }
    }
    
}
