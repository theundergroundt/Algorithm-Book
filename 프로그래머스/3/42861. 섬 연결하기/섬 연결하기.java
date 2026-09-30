import java.util.*;

class Solution {
    static int[] parent;
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        parent = new int[n+1];
        for(int i=0; i<=n; i++) parent[i] = i;
        
        Arrays.sort(costs, (x,y)-> x[2] - y[2]);
        
        for(int[] c : costs){
            int a = c[0];
            int b = c[1];
            int cost = c[2];
            
            if(uni(a, b) == 1){
                answer += cost;
            }
        }
        
        return answer;
    }
    public int uni(int a, int b){
        int fir = fin(a);
        int sec = fin(b);
        if(fir == sec) return 0;
        parent[fir] = sec;
        return 1;
    }
    public int fin(int a){
        if(parent[a] == a) return a;
        return parent[a] = fin(parent[a]);
    }
}