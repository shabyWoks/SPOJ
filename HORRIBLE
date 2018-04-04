import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
	static long[] st;
	static long[] lpt;
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int i=0; i<t; i++){
			String[] inp = br.readLine().trim().split(" ");
			int n = Integer.parseInt(inp[0]);
			int c = Integer.parseInt(inp[1]);
			
			int x = (int)(Math.ceil(Math.log(n)/Math.log(2)));
			int sts = (int)(2*Math.pow(2, x)) - 1;
			st = new long[sts];
			lpt = new long[sts];
			for(int j=0; j<c; j++){
				String[] inpC = br.readLine().trim().split(" ");
				int ty = Integer.parseInt(inpC[0]);
				if(ty == 0){
					int p = Integer.parseInt(inpC[1]);
					int q = Integer.parseInt(inpC[2]);
					long v = (long)(Integer.parseInt(inpC[3]));
					uST(v, p-1, q-1, 0, n-1, 0);
				}
				else{
					int p = Integer.parseInt(inpC[1]);
					int q = Integer.parseInt(inpC[2]);
                    System.out.println(rSQ(p-1, q-1, 0, n-1, 0));
				}
			}
		}
	}
	
	public static long uST(long v, int p, int q, int l, int h, int pos){
		long c = (long)(h-l+1);
        if(lpt[pos] != 0){
            st[pos] = st[pos] + (c*lpt[pos]);
            if(l != h){
                lpt[(2*pos)+1] = lpt[(2*pos)+1] + lpt[pos];
			    lpt[(2*pos)+2] = lpt[(2*pos)+2] + lpt[pos];    
            }
            lpt[pos] = 0;
		}   
		if(p <= l && q >= h){
			st[pos] = st[pos] + (c * v);
            if(l != h){
                lpt[(2*pos)+1] = lpt[(2*pos)+1] + v;
			    lpt[(2*pos)+2] = lpt[(2*pos)+2] + v;    
            }
			return st[pos];
		}
		else if( p>h || q<l){
			return st[pos];
		}
		else{
			int mid = (int)((l + h)/2);
			st[pos] = uST(v, p, q, l, mid, (2*pos) + 1) + uST(v, p, q, mid+1, h, (2*pos) + 2);
			return st[pos];
		}
	}
    
    public static long rSQ(int p, int q, int l, int h, int pos){
        long c = (long)(h-l+1);
        if(lpt[pos] != 0){
            st[pos] = st[pos] + (c*lpt[pos]);
            if(l != h){
                lpt[(2*pos)+1] = lpt[(2*pos)+1] + lpt[pos];
			    lpt[(2*pos)+2] = lpt[(2*pos)+2] + lpt[pos];    
            }
            lpt[pos] = 0;
		}
        if(p <= l && q >= h){
            return st[pos];
		}
		else if( p>h || q<l){
            return 0;
		}
		else{
            int mid = (int)((l+h)/2);
            return ((rSQ(p, q, l, mid, (2*pos)+1) + rSQ(p, q, mid+1, h, (2*pos)+2)));
		}
    }
}
