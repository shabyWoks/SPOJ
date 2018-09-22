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
    static int[] arr;
    
    public static void main(String[] argh) throws Exception{
        Reader br = new Reader();
        int t= br.nextInt();
        
        for(int aa=0; aa<t; aa++){
            String s= br.readLine();
            ArrayList<String> stack= new ArrayList<>();
            stack.add("#");
            int len= s.length();
            for(int i=0; i<len; i++){
                String ch= s.charAt(i) + "";
                if(ch.equals("(") || isOp(ch)){
                    stack.add(0, ch);
                }
                else if(ch.equals(")")){
                    while(true){
                        String elem= stack.get(0);
                        if(isOp(elem)){
                            System.out.print(elem);
                            stack.remove(0);
                        }
                        else break;
                    }
                    stack.remove(0);
                }
                else{
                    System.out.print(ch);
                }
            }
            System.out.println("");
        }
    }
    
    private static boolean isOp(String s){
        if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") ||s.equals("^")) return true;
        return false;
    }
}
