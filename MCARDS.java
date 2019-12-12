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
    
    static class CARD implements Comparable<CARD>{
        int color;
        int card;
        public CARD(int color, int card){
            this.color= color;
            this.card= card;
        }
        public int compareTo(CARD c){
            if(map.get(this.color) > map.get(c.color)) return 1;
            else if(map.get(this.color) < map.get(c.color)) return -1;
            else{
                if(this.card > c.card) return 1;
                else if(this.card < c.card) return -1;
                else return 0;
            }
        }
    }
    
    static int[] permutation;
    static int C;
    static HashMap<Integer, Integer> map;
    public static void main(String[] argh) throws Exception{
        Reader br= new Reader();
        C= br.nextInt();
        int N= br.nextInt();
        ArrayList<CARD> cards= new ArrayList<>();
        
        int len= C*N;
        for(int i=0; i<len; i++){
            cards.add(new CARD(br.nextInt() - 1, br.nextInt() - 1));
        }
        
        permutation= new int[C];
        int fact= 1;
        for(int i=0; i<C; i++){
            permutation[i]= i;
            fact *= (i+1);
        }
        int min= Integer.MAX_VALUE;
        for(int i=0; i<fact; i++){
            map= new HashMap<>();
            for(int j=0; j<C; j++){
                map.put(permutation[j], j);
            }
            int v= lis(cards);
            if(min > v) min= v;
            nextPermutation();
        }
        System.out.println(min);
    }
    
    private static int lis(ArrayList<CARD> cards){
        ArrayList<CARD> list= new ArrayList<>();
        int len= cards.size();
        int lisLen= 0;
        for(int i=0; i<len; i++){
            if(i == 0){
                list.add(cards.get(i));
                lisLen++;
            }
            else{
                CARD last= list.get(list.size() - 1);
                CARD first= list.get(0);
                if(cards.get(i).compareTo(last) > 0){
                    list.add(cards.get(i));
                    lisLen++;
                }
                else if(cards.get(i).compareTo(first) < 0){
                    list.remove(0);
                    list.add(0, cards.get(i));
                }
                else{
                    int l= 1;
                    int h= list.size() - 2;
                    int mid;
                    while(l<=h){
                        mid= (l+h) >> 1;
                        if(list.get(mid).compareTo(cards.get(i)) > 0){
                            h= mid-1;
                        }
                        else if(list.get(mid).compareTo(cards.get(i)) < 0){
                            l= mid+1;
                        }
                        else{
                            l= mid;
                            break;
                        }
                    }
                    list.set(l, cards.get(i));
                }
            }
        }
        return (len - lisLen);
    }
    
    private static void nextPermutation(){
        int split= -1;
        for(int i=C-2; i>=0; i--){
            if(permutation[i+1] > permutation[i]){
                split= i;
                break;
            }
        }
        if(split == -1) return;
        int nextHigh= -1;
        for(int i=C-1; i>split; i--){
            if(permutation[i] > permutation[split]){
                nextHigh= i;
                break;
            }
        }
        
        // swap numbers
        int temp= permutation[split];
        permutation[split]= permutation[nextHigh];
        permutation[nextHigh]= temp;
        
        // quick sort 
        quicksort(split+1, C-1);
    }
    
    private static void quicksort(int l, int h){
        if(l<h){
            int pi= partition(l, h);
            quicksort(l, pi-1);
            quicksort(pi+1, h);
        }
    }
    
    private static int partition(int l, int h){
        int pivot= permutation[h];
        int i= l-1;
        for(int j=l; j<h; j++){
            if(permutation[j] < pivot){
                i++;
                int temp= permutation[i];
                permutation[i]= permutation[j];
                permutation[j]= temp;
            }
        }
        int temp= permutation[i+1];
        permutation[i+1]= permutation[h];
        permutation[h]= temp;
        return (i+1);
    }
}
