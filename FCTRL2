//Complete this code or write your own from scratch
import java.util.*;
import java.io.*;
import java.math.*;

class Solution{
    
    public static void main(String []argh) throws Exception{
        Scanner br= new Scanner(System.in);
        int t= br.nextInt();
        HashMap<Integer, String> map = new HashMap<>();
        for(int aa=0; aa<t; aa++){
            int n = br.nextInt();
            if(map.containsKey(n)){
                System.out.println(map.get(n));
                continue;
            }
            BigInteger prod = new BigInteger("1");
            for(int i=1; i<=n; i++){
                prod = prod.multiply(new BigInteger(i+""));
            }
            map.put(n, prod.toString());
            System.out.println(prod.toString());
        }
    }
    
}
