// solution is throwing runtime error but passing most test cases.
import java.util.*;
import java.io.*;

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
    
    public static void main(String []argh) throws Exception{
        Reader br = new Reader();
        int t = br.nextInt();
        for(int i=0; i<t; i++){
            int N= br.nextInt();
            int M= br.nextInt();
            int Q= br.nextInt();
            
            HashMap<String, Integer> map = new HashMap<>();
            ArrayList<Integer> xaxis = new ArrayList<>();
            ArrayList<Integer> yaxis = new ArrayList<>();
            xaxis.add(0);
            xaxis.add(N);
            yaxis.add(0);
            yaxis.add(M);
            
            ArrayList<Integer> xQaxis = new ArrayList<>();
            xQaxis.add(N);
            ArrayList<Integer> yQaxis = new ArrayList<>();
            yQaxis.add(M);
            
            long lastX= N;
            long lastY= M;
            for(int q=0; q<Q; q++){
                int type= br.nextInt();
                if(type == 0){
                    int x= br.nextInt();
                    if(N == 1){
                    }
                    else{
                        if(!map.containsKey(type + " " + x)){
                            int pos = binarySearch(x, xaxis);  
                            binaryRemove(xaxis.get(pos+1) - xaxis.get(pos-1), xQaxis);
                            binarySearch(xaxis.get(pos+1) - x, xQaxis);
                            binarySearch(x - xaxis.get(pos-1), xQaxis);
                            if(xQaxis.size() != 0)
                                lastX = (long)xQaxis.get(xQaxis.size() -1);
                            map.put(type + " " + x, 1);
                        }
                    }
                    long prod = lastX * lastY;
                    System.out.println(prod);
                }
                else{
                    int y= br.nextInt();
                    if(M == 1){

                    }
                    else{
                        if(!map.containsKey(type + " " + y)){
                            int pos = binarySearch(y, yaxis);
                            binaryRemove(yaxis.get(pos+1) - yaxis.get(pos-1), yQaxis);
                            binarySearch(yaxis.get(pos+1) - y, yQaxis);
                            binarySearch(y - yaxis.get(pos-1), yQaxis);
                            if(yQaxis.size() != 0)
                                lastY = (long)yQaxis.get(yQaxis.size() -1);
                            map.put(type + " " + y, 1);
                        }
                    }
                    long prod = lastX * lastY;
                    System.out.println(prod);
                }
            }
        }
    }
    
    private static int binarySearch(int val, ArrayList<Integer> arr){
        int len= arr.size() - 1;
        int low=0, high=len;
        int mid;
        while(high>=low){
            mid= (low+high)>>1;
            if(val > arr.get(mid)){
                low= mid+1;
            }
            else if(val < arr.get(mid)){
                high= mid-1;
            }
            else{
                arr.add(mid, val);
                return mid;
            }
        }
        arr.add(low, val);
        return low;
    }
    
    private static void binaryRemove(int val, ArrayList<Integer> arr){
        int len= arr.size() - 1;
        int low=0, high=len;
        int mid;
        while(high>=low){
            mid= (low+high)>>1;
            if(val > arr.get(mid)){
                low= mid+1;
            }
            else if(val < arr.get(mid)){
                high= mid-1;
            }
            else{
                arr.remove(mid);
                break;
            }
        }
    }
}
