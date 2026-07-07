import java.util.*;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int[][] dist = new int[n+1][n+1];
        for(int i=1; i<=n; i++){
            Arrays.fill(dist[i], 100000000);
            dist[i][i] = 0;
        }
        for(int[] f : fares){
            int c = f[0];
            int d = f[1];
            int e = f[2];
            dist[c][d] = e;
            dist[d][c] = e;
        }
        
        // 플로이드-워샬
        for(int k = 1; k<=n; k++){
            for(int i = 1; i<=n; i++){
                for(int j = 1; j<=n; j++){
                    if(dist[i][j] > dist[i][k] + dist[k][j]){
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        int answer = 987654321;
        for(int i=1; i<=n; i++){
            answer = Math.min(answer, dist[s][i] + dist[i][a] + dist[i][b]);
        }
        return answer;
    }
}