import java.util.*;

class Solution {
    static int[] parent;
    
    public int solution(int n, int[][] costs) {
        
        int answer = 0;
        parent = new int[n+1];
        for(int i=0; i<=n; i++) parent[i] = i;
        
        Arrays.sort(costs, (a,b) -> Integer.compare(a[2], b[2]));
        
        for(int[] c : costs){
            int a = c[0];
            int b = c[1];
            int cc = c[2];
            if(uni(a, b)){
                answer+=cc;
            }
        }
        return answer;
    }
    static boolean uni(int a, int b){
        int fir = fin(a);
        int sec = fin(b);
        if(fir == sec) return false;
        parent[fir] = sec;
        return true;
    }
    
    static int fin(int a){
        if(parent[a] == a) return a;
        return parent[a] = fin(parent[a]);
    }
}