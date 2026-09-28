import java.util.*;

class Solution {
    public long solution(int n, int s, int a, int b, int[][] fares) {
        long answer = 0;
        
        long dist[][] = new long[n+1][n+1];
        for(int i=1; i<=n; i++) {
            Arrays.fill(dist[i], 200000000);
            dist[i][i] = 0;
        }
        
        
        for(int[] f : fares){
            int a0 = f[0];
            int b0 = f[1];
            int c0 = f[2];
            dist[a0][b0] = c0;
            dist[b0][a0] = c0;
        }
        
        for(int k=1; k<=n; k++){
            for(int i=1; i<=n; i++){
                for(int j=1; j<=n; j++){
                    if(dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        answer = 987654321L;
        for(int i=1; i<=n; i++) answer = Math.min(answer, dist[a][i] + dist[i][b] + dist[s][i]);
        return answer;
    }
}