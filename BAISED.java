import java.util.*;
import java.io.*;
import java.math.*;
import java.io.InputStream;

class  Solution{
    public static void main(String[] argh) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t= Integer.parseInt(br.readLine().trim());
        for(int ii=0; ii<t; ii++){
            br.readLine();
            int n= Integer.parseInt(br.readLine().trim());
            PriorityQueue<Long> pq= new PriorityQueue<>();
            for(int i=0; i<n; i++){
                String[] inp= br.readLine().trim().split(" ");
                pq.add(Long.parseLong(inp[1]));
            }
            long sum= 0;
            for(long i=0; i<n; i++){
                sum += (long)Math.abs(pq.poll() - (i+1));
            }
            System.out.println(sum);
            
        }
    }
}
