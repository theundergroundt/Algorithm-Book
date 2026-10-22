import java.util.*;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
        
        int[][] dist = new int[n+1][n+1];
        for(int i=0; i<=n; i++) Arrays.fill(dist[i], 500000000);
        
        for(int[] f : fares){
            dist[f[0]][f[1]] = f[2];
            dist[f[1]][f[0]] = f[2];
        }
        for(int i = 1; i<=n; i++) dist[i][i] = 0;
        
        
        for(int k = 1; k<=n; k++){
            for(int i = 1; i<=n; i++){
                for(int j=1; j<=n; j++){
                    int newdist = dist[i][k] + dist[k][j];
                    if(newdist < dist[i][j]) {
                        dist[i][j] = newdist;
                    }
                }
            }
        }
        answer = Integer.MAX_VALUE;
        for(int i=1; i<=n; i++){
            answer = Math.min(answer, dist[a][i]+ dist[i][b] + dist[s][i]);
        }
        
        return answer;
    }
}