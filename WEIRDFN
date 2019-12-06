import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
	static int MOD = 1000000007;
	static int a,b,c;
	static PriorityQueue<Integer> pqTop;
  static PriorityQueue<Integer> pqBot;
  static Reader br;
  static BufferedWriter bw;
	public static void main (String[] args) throws java.lang.Exception
	{
		br = new Reader();
		bw = new BufferedWriter(new PrintWriter(System.out));
    
		int T = br.nextInt();
		
		for(int t = 0; t < T; t++) {
			pqTop = new PriorityQueue<>(Collections.reverseOrder());
			pqBot = new PriorityQueue<>();

			a = br.nextInt();
			b = br.nextInt();
			c = br.nextInt();
			int n = br.nextInt();
			pqBot.add(1);
			long sum = 1;
			for(int i=2; i<=n; i++) {
				
				if(i%2 == 0) {
					pqTop.add(pqBot.remove());
				}

				int ff = getF(pqTop.peek(), i);

				sum += (long)ff;
				pqBot.add(ff);
					
				if(pqBot.size() > 0 && pqTop.size() > 0 && pqTop.peek() < pqBot.peek()) {
					pqTop.add(pqBot.remove());
					pqBot.add(pqTop.remove());
				}
			}
			bw.write(sum + "\n");
		}
		bw.flush();
		bw.close();
	}
	
	private static int getF(long med, int i) {
		return (int)(((a*med) + (b*i) + c)%MOD);
	}
	
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
  
        public Reader(String file_name) throws IOException 
        { 
            din = new DataInputStream(new FileInputStream(file_name)); 
            buffer = new byte[BUFFER_SIZE]; 
            bufferPointer = bytesRead = 0; 
        } 
  
        public String readLine() throws IOException 
        { 
            byte[] buf = new byte[64]; // line length 
            int cnt = 0, c; 
            while ((c = read()) != -1) 
            { 
                if (c == '\n') 
                    break; 
                buf[cnt++] = (byte) c; 
            } 
            return new String(buf, 0, cnt); 
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
  
        public void close() throws IOException 
        { 
            if (din == null) 
                return; 
            din.close(); 
        } 
    }
}
