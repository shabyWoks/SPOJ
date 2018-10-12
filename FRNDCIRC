import java.util.*;
import java.io.*;
import java.math.*;
import java.io.InputStream;

class  Solution{
    static HashMap<Integer, Integer> parent;
    static HashMap<Integer, Integer> degree;
    static StringBuilder sb;
    public static void main(String[] argh) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int t= Integer.parseInt(br.readLine().trim());
        for(int tt=0; tt<t; tt++){
            int n= Integer.parseInt(br.readLine().trim());
            HashMap<String, Integer> nameMap= new HashMap<>();
            int cName= 1;
            parent= new HashMap<>();
            degree= new HashMap<>();
            sb= new StringBuilder();
            for(int nn=0; nn<n; nn++){
                String[] inpName= br.readLine().trim().split(" ");
                if(!nameMap.containsKey(inpName[0])){
                    nameMap.put(inpName[0], cName);
                    cName++;
                }
                if(!nameMap.containsKey(inpName[1])){
                    nameMap.put(inpName[1], cName);
                    cName++;
                }
                int p1= nameMap.get(inpName[0]);
                int p2= nameMap.get(inpName[1]);
                if(findParent(p1) != findParent(p2)){
                    union(p1, p2);
                }
                else{
                    sb.append(degree.get(findParent(p1)) + "\n");
                }
            }
            System.out.println(sb);
        }
    }
    
    private static int findParent(int pos){
        if(!parent.containsKey(pos)){
            parent.put(pos, pos);
            degree.put(pos, 1);
            return pos;
        }
        if(parent.get(pos) == pos){
            return pos;
        }
        int p= findParent(parent.get(pos));
        parent.put(pos, p);
        return p;
    }
    
    private static void union(int pos1, int pos2){
        int posP1= findParent(pos1);
        int posP2= findParent(pos2);
        int a1= degree.get(posP1);
        int a2= degree.get(posP2);
        if(posP1 != posP2){
            if(a1 > a2){
                parent.put(posP2, posP1);
                degree.put(posP1, (a1 + a2));
            }
            else{
                parent.put(posP1, posP2);
                degree.put(posP2, (a1 + a2));
            }
            sb.append((a1+a2) + "\n");
        }   
    }   
}
