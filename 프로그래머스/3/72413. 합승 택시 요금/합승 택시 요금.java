import java.util.*;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        
        // 시작점이 n개 -> 플로이드워샬
        
        int[][] dist = new int[n+1][n+1];
        for(int i=0; i<=n; i++){
            Arrays.fill(dist[i], 200000000);
            dist[i][i] = 0;
        };
        
        for(int[] f : fares){
            dist[f[0]][f[1]] = f[2];
            dist[f[1]][f[0]] = f[2];
        }
        
        for(int k=1; k<=n; k++){
            for(int i=1; i<=n; i++){
                for(int j=1; j<=n; j++){
                    if(dist[i][j] > dist[i][k] + dist[k][j]){
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        
        for(int i=1; i<=n; i++){
            answer = Math.min(answer, dist[a][i]+dist[i][b]+dist[s][i]);
        }
        
        return answer;
    }
}