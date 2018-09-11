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
    
    public static void main(String []argh) throws Exception{
        Reader br = new Reader();
        for(int aa=0; aa<1; aa++){
            int n = br.nextInt();
            int[] arr = new int[n];
            for(int kk=0; kk<n; kk++){
                arr[kk]= br.nextInt();
            }
            ArrayList<Integer> intList = new ArrayList<>();
            ArrayList<ArrayList<Integer>> pqList = new ArrayList<>();
            
            for(int kk=0; kk<n; kk++){
                ArrayList<Integer> q= new ArrayList<Integer>();
                pqList.add(q);
            }
            int len = 0;
            intList.add(0, 0);
            pqList.get(0).add(0);
            
            for(int kk=1; kk<n; kk++){
                int val = arr[kk];
                if(val > arr[intList.get(len)]){
                    len++;
                    intList.add(len, kk);
                    pqList.get(len).add(kk);
                        
                }
                else if(val == arr[intList.get(len)]){
                    intList.set(len, kk);
                    pqList.get(len).add(kk);
                }
                else{
                    if(val <= arr[intList.get(0)]){
                        intList.set(0, kk);
                        pqList.get(0).add(kk);
                    }
                    else{
                        // do binary serach to find position
                        int pos= doBS(arr, intList, val);
                        intList.set(pos, kk);
                        pqList.get(pos).add(kk);
                    }
                }
            }
            
            // for(int q=0; q<=len ;q++){
            //     ArrayList<Integer> llo = pqList.get(q);
            //     for(int w= 0; w<llo.size(); w++){
            //         System.out.print(llo.get(w) + " ");
            //     }
            //     System.out.println("");
            // }
            
            SortedSet<Integer> set = new TreeSet<>();
            for(int ll=0; ll<pqList.get(len).size(); ll++){
                set.add(arr[pqList.get(len).get(ll)]);
            }
            
            for(int ll= len-1; ll>=0; ll--){
                int currMax= Integer.MIN_VALUE;
                int ui= pqList.get(ll+1).get(pqList.get(ll+1).size() - 1);
                for(int ww= 0; ww< pqList.get(ll+1).size(); ww++){
                    int val = arr[pqList.get(ll+1).get(ww)];
                    if(val > currMax) currMax= val;
                }
                ArrayList<Integer> ls= pqList.get(ll);
                for(int yy= 0; yy<ls.size(); yy++){
                    int v= arr[ls.get(yy)];
                    if(v > currMax || ls.get(yy) > ui){
                        ls.remove(yy);
                        yy--;
                    }
                    else{
                        set.add(v);
                    }
                }
            }
            Iterator<Integer> itr = set.iterator();
            System.out.println(set.size());
            while(itr.hasNext()){
                System.out.print(itr.next() + " ");
            }
            System.out.println("");
        }
    }
    
    private static int doBS(int[] arr, ArrayList<Integer> list, int val){
        int len= list.size();
        int mid;
        int high= len-1, low= 0;
        while(high >= low){
            mid= (high + low)/2;
            if(arr[list.get(mid)] > val){
                high= mid - 1;
            }
            else if(arr[list.get(mid)] < val){
                low= mid + 1;
            }
        }
        return low;
    }
    
}
