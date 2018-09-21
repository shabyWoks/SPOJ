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
    
    static int[][] arr;
    static int[][] visited;
    static int total;
    static int count;
    static int n;
    public static void main(String []argh) throws Exception{
        Reader br = new Reader();
        int cc= 0;
        while(true){
            cc++;
            n= br.nextInt();
            if(n == 0) break;
            arr= new int[n][2];
            total= 0;
            count= 0;
            overMax= Integer.MIN_VALUE;
            int maxY= Integer.MIN_VALUE;
            for(int aa=0; aa<n ;aa++){
                int x= br.nextInt();
                int y= br.nextInt();
                arr[aa][0]= x;
                arr[aa][1]= x+y -1;
                total += y;
                if(x+y > maxY) maxY= x+y;
            }
            visited= new int[n][maxY];
            dfs(0, arr[0][0]);
            int ccc= (total - overMax);
            if(ccc == 1){
                System.out.println("Case "+cc  +", " + ccc +" square can not be reached." );
            }
            else{
                System.out.println("Case "+cc  +", " + ccc +" squares can not be reached." );    
            }
            
        }
    }
    
    static int[] pX= new int[] {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] pY= new int[] {-1, 1, -2, 2, -2, 2, -1, 1};
    static int overMax;
    public static void dfs(int x, int y){
        visited[x][y]= 1;
        count++;
        if(count > overMax) overMax= count;
        for(int i=0; i<8; i++){
            int nX= x + pX[i];
            int nY= y + pY[i];
            if((nX >= 0 && nX < n) && (nY >= arr[nX][0] && nY <= arr[nX][1])){
                if(visited[nX][nY] == 0)
                    dfs(nX, nY);
            }
        }
        visited[x][y]= 0;
        count--;
    }
}
