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
    static ArrayList<Integer> stack;
    static int[] comp ;
    public static void main(String []argh) throws Exception{
        Reader br = new Reader();
        int t= br.nextInt();
        for(int aa=0; aa<t; aa++){
            int n = br.nextInt();
            int[][] arr= new int[n+1][n+1];
            int[][] rev= new int[n+1][n+1];
            for(int bb=1; bb<=n; bb++){
                int c = br.nextInt();
                for(int cc=0; cc<c; cc++){
                    int kk= br.nextInt();
                    arr[kk][bb] = 1;
                    rev[bb][kk] = 1;
                }
            }
            stack = new ArrayList<>();
            int[] visited = new int[n+1];
            
            // doing first dfs for filling up stack
            
            while(true){
                int yz=0;
                for(int i=1; i<=n; i++){
                    if(visited[i] == 0){
                        yz= i;
                        break;
                    }
                }
                if(yz==0) break;
                dfs(yz, arr, n, visited);
                
            }
            visited = new int[n+1];
            comp = new int[n+1];
            int len = stack.size();
            int cou= 1;
            //doing 2nd dfs for finding strongly connected components
            for(int z= 0; z<len; z++){
                int vv= stack.get(z);
                if(visited[vv] == 1) continue;
                dfs2(vv, rev, n, visited, cou++);
            }
            int[] indegree= new int[cou];
            
            // finding indegrees of vertices
            
            for(int i=1; i<=n; i++){
                for(int j=1; j<=n; j++)
                    if(arr[i][j] == 1){
                        if(comp[i] != comp[j])
                            indegree[comp[j]]++;    
                    }
            }
            int lp= 0;
            int indx= -1;
            for(int i=1; i<cou; i++){
                if(indegree[i] == 0){
                    indx= i;
                    lp++;
                }
            }
            if(lp == 1){
                int cnt=0;
                for(int i=1; i<=n; i++){
                    if(comp[i] == indx){
                        cnt++;
                    }
                }
                System.out.println(cnt);
            }
            else{
                System.out.println(0);
            }
        }
    }
    
    private static void dfs(int val, int[][] arr, int n, int[] visited){
        visited[val]= 1;
        for(int qq=1; qq<=n; qq++){
            if(arr[val][qq] == 1){
                if(visited[qq] == 0){
                    dfs(qq, arr, n, visited);
                }        
            }
        }
        stack.add(0, val);
    }
    private static void dfs2(int val, int[][] rev, int n, int[] visited, int cou){
        visited[val] = 1;
        comp[val] = cou;
        for(int qq=1; qq<=n; qq++){
            if(rev[val][qq] == 1){
                if(visited[qq] == 0){
                    dfs2(qq, rev, n, visited, cou);
                }        
            }
        }
    }
}
