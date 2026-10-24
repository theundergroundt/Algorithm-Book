import java.util.*;

class Solution {
    static int[][] reqs;
    static int k, n, answer;
    static int[] assign;
    static int[][] arr;
    public int solution(int k, int n, int[][] reqs) {
        answer = 987654321;
        
        this.reqs = reqs;
        this.k = k;
        this.n = n;
        assign = new int[k+1];
        arr = new int[k+1][n+1];
        
        for(int i=1; i<=k; i++){
            for(int j=1; j<=n-k+1; j++){
                // 타입별 사람 수 -> 기다린 시간
                arr[i][j] = simulate(i, j);
            }
        }
        dfs(1, n);
        
        return answer;
    }
    static void dfs(int idx, int remain){
        if(idx == k+1){
            int tmp=0;
            for(int c=1; c<=k; c++){
                tmp += arr[c][assign[c]];
            }
            answer = Math.min(answer, tmp);
            return ;
        }
        for(int cnt=1; cnt<=(remain - (k-idx)); cnt++){
            assign[idx] = cnt;
            dfs(idx+1, remain - cnt);
        }
    }
    
    static int simulate(int typ, int num){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<num; i++) pq.offer(0);
        int wait = 0;
        for(int[] r : reqs){
            int start = r[0];
            int during = r[1];
            
            if(r[2] !=typ) continue;
            int cur = pq.poll();
            if(cur <= start){
                pq.offer(start+during);
            }else{
                wait+=cur - start;
                pq.offer(cur + during);
            }
        }
        return wait;
    }
}