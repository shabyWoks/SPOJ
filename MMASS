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
    
    public static void main(String[] argh) throws Exception{
        Reader br = new Reader();
        String formula= br.readLine().trim();
        
        ArrayList<String> stack= new ArrayList<>();
        int len= formula.length();
        for(int i=0; i<len; i++){
            String ch= formula.charAt(i)+"";
            // System.out.println(ch);
            if(ch.equals("(")){
                stack.add(0, "(");
            }
            else if(isElem(ch)){
                int aw= getAW(ch);
                if(i+1<len){
                    String nextNum= formula.charAt(i+1)+"";
                    if(isNum(nextNum)){
                        aw= Integer.parseInt(nextNum) * aw;
                        i++;
                    }    
                }
                stack.add(0, aw+"");
                
            }
            else{
                int sum= 0;
                while(true){
                    if(isNum(stack.get(0))){
                        sum += Integer.parseInt(stack.get(0));
                        stack.remove(0);
                    }
                    else break;
                }
                stack.remove(0);
                if(i+1 < len){
                    String nextNum= formula.charAt(i+1)+"";
                    if(isNum(nextNum)){
                        sum= Integer.parseInt(nextNum) * sum;
                        i++;
                    }    
                }
                stack.add(0, sum+"");
            }
        }
        int sm= 0;
        for(int a=0; a<stack.size(); a++){
            sm += Integer.parseInt(stack.get(a));
            // stack.remove(0);
        }
        System.out.println(sm);
    }
    
    private static int getAW(String c){
        switch(c){
            case "H": return 1;
            case "C": return 12;
            case "O": return 16;
        }
        return 0;
    }
    
    private static boolean isElem(String s){
        if(s.equals("C") || s.equals("H") || s.equals("O")) return true;
        return false;
    }
    
    private static boolean isNum(String s){
        try{
            int n= Integer.parseInt(s);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
}
