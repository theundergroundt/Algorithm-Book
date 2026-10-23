import java.util.*;

class Solution {
    static int[][] arr;
    static int[][] reqs;
    static int[] assign;
    static int best, k, n;
    public int solution(int k, int n, int[][] reqs) {
        
        // 유형별 멘토수
        arr = new int[k+1][n+1];
        this.reqs = reqs;
        this.k = k;
        this.n = n;
        assign = new int[k+1];
        best = 987654321;
        // 유형별 멘토 완탐해서 저장해놓기
        for(int i=1; i<=k; i++){
            for(int j=1; j<=n-k+1; j++){
                arr[i][j] = simulate(i, j);
            }
        }
        
        dfs(1, n);
        
        return best;
    }
    
    static void dfs(int idx, int remain){
        if(idx == k+1){
            int tmp = 0;
            for(int c=1; c<=k; c++){
                tmp += arr[c][assign[c]];
            }
            best = Math.min(best, tmp);
            return;
        }
        for(int cnt=1; cnt<=(remain - (k-idx)); cnt++){
            assign[idx] = cnt;
            dfs(idx+1, remain-cnt);
        }
    }
    
    static int simulate(int typ, int num){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<num; i++) pq.offer(0);
        
        int wait=0;
        for(int[] r : reqs){
            if(r[2] != typ) continue;
            int start = r[0];
            int during = r[1];
            
            int free = pq.poll();
            if(free<=start) pq.offer(start+during);
            else{
                wait+= free - start;
                pq.offer(free + during);
            }
        }
        return wait;
    }
}