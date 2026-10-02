import java.util.*;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
        int[][] dist = new int[n+1][n+1];
        
        for(int i=0; i<=n; i++) {
            Arrays.fill(dist[i], 200000000);
            dist[i][i] = 0;
        }
        
        for(int[] f : fares){
            int l = f[0];
            int m = f[1];
            int k = f[2];
            dist[l][m] = k;
            dist[m][l] = k;
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
        int minnum = 987654321;
        for(int i=1; i<=n; i++){
            minnum = Math.min(minnum, dist[a][i] + dist[i][b] + dist[s][i]);
        }
        
        return minnum;
    }
}