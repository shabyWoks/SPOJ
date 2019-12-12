import java.io.BufferedReader;
import java.io.InputStreamReader;

class TestClass {
    static int[] segmentTree;
    static int[] inpArr;
    static int N;
    static int max_size;
    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N= Integer.parseInt(br.readLine().trim());
        String[] inp= br.readLine().trim().split(" ");
        inpArr= new int[N];
        for(int i=0; i<N; i++){
            inpArr[i]= Integer.parseInt(inp[i]);
        }
        int Q= Integer.parseInt(br.readLine().trim());
        
        //---1st Step
        int x = (int) (Math.ceil(Math.log(N) / Math.log(2)));
        //Maximum size of segment tree
        max_size = 2 * (int) Math.pow(2, x) - 1;
        segmentTree= new int[max_size];
        
        //---2nd Step
        
        constructSegmentTree(N-1, 0, 0);
        
        //--3rd Step
        //--process queries
        for(int i=0; i<Q; i++){
            String[] q= br.readLine().trim().split(" ");
            int pos1= Integer.parseInt(q[0]);
            int pos2= Integer.parseInt(q[1]);
            System.out.println(rangeMinimumQuery(pos1, pos2, N-1, 0, 0));
        }
    }
    
    private static void constructSegmentTree(int high, int low, int pos){
        if(high == low){
            segmentTree[pos]= inpArr[low];
            return;
        } 
        int mid= (high + low)/2;
        constructSegmentTree(mid, low, (2*pos) + 1);
        constructSegmentTree(high, mid+1, (2*pos) + 2);
        segmentTree[pos]= (int)Math.min(segmentTree[2*pos + 1], segmentTree[2*pos + 2]);
    }
    
    private static int rangeMinimumQuery(int sI, int eI, int high, int low, int pos){
        if(sI<=low && eI>=high){ //--total OverLap
            return segmentTree[pos];
        }
        else if(high < sI || low > eI){ //-- No OverLap
            return Integer.MAX_VALUE;
        }
        else{ //-- Partial OverLap
            int mid= (low + high) / 2;
            return (int)Math.min(rangeMinimumQuery(sI, eI, mid, low, (2*pos) + 1), rangeMinimumQuery(sI, eI, high, mid+1, (2*pos) + 2));
        }
    }
    
}
