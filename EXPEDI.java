import java.util.*;
import java.io.*;
import java.math.*;
import java.io.InputStream;

class  Solution{
    public static void main(String[] argh) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++) {
            int n = Integer.parseInt(br.readLine());
            ArrayList<Pair> arr = new ArrayList<>();
            for(int j=0; j<n; j++) {
                String[] inpA = br.readLine().trim().split(" ");
                Pair p = new Pair(Integer.parseInt(inpA[0]), Integer.parseInt(inpA[1]));
                arr.add(p);
            }
            Collections.sort(arr);
            String[] inpF   = br.readLine().trim().split(" ");
            int reqFuel     = Integer.parseInt(inpF[0]);
            int fuelIHave   = Integer.parseInt(inpF[1]);
            int count       = 0;
            boolean flag    = true;
            
            PriorityQueue<Pair2> pq = new PriorityQueue<>();
            for(int j=0; j<n; j++) {
                Pair p = arr.get(j);
                if(fuelIHave >= reqFuel) { break; }
                if(reqFuel - p.dist <= fuelIHave) { pq.add(new Pair2(p.dist, p.fuel)); }
                else {
                    if(pq.size() != 0) {
                        Pair2 pp  = pq.poll();
                        fuelIHave = fuelIHave + pp.fuel;
                        count++;
                        if(reqFuel - p.dist > fuelIHave) {
                            while(reqFuel - p.dist > fuelIHave) {
                                if(pq.size() == 0) {
                                    flag = false;
                                    break;
                                }
                                Pair2 pqp = pq.poll();
                                fuelIHave = fuelIHave + pqp.fuel;
                                count++;
                            }  
                            if(flag == false) break;
                        }
                        pq.add(new Pair2(p.dist, p.fuel));
                    }
                    else {
                        flag = false;
                        break;
                    }
                }
            }
            if(fuelIHave < reqFuel) {
                while(reqFuel > fuelIHave){
                    if(pq.size() != 0) {
                        Pair2 pqp = pq.poll();   
                        fuelIHave = fuelIHave + pqp.fuel;
                        count++;    
                    }
                    else {
                        flag = false;
                        break;
                    }
                } 
            }    
            if(flag == true) {
                System.out.println(count);
            }
            else {
                System.out.println("-1");
            }
        }
    }
    
    static class Pair implements Comparable<Pair> {
        int dist;
        int fuel;
        
        public Pair(int dist, int fuel) {
            this.fuel = fuel;
            this.dist = dist;
        }
        
        public int compareTo(Pair p) {
            if(p.dist > this.dist) return 1;
            else if(p.dist < this.dist) return -1;
            else return 0;
        }
    }
    
    static class Pair2 implements Comparable<Pair2> {
        int dist;
        int fuel;
        
        public Pair2(int dist, int fuel) {
            this.fuel = fuel;
            this.dist = dist;
        }
        
        public int compareTo(Pair2 p) {
            if(p.fuel > this.fuel) return 1;
            else if(p.fuel < this.fuel) return -1;
            else return 0;
        }
    }
    
    
    
}
