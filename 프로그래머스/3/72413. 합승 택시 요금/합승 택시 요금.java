import java.util.*;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
        
        
        int[][] dist = new int[n+1][n+1];
        for(int i=0; i<=n; i++){
            Arrays.fill(dist[i], 100000000);
            dist[i][i] = 0;
        }
        
        
        for(int[] f : fares){
            int A = f[0];
            int B = f[1];
            int C = f[2];
            dist[A][B] = C;
            dist[B][A] = C;
        }
        
        
        for(int k = 1; k<=n; k++){
            for(int i=1; i<=n; i++){
                for(int j=1; j<=n; j++){
                    if(dist[i][j] > dist[i][k] + dist[k][j]){
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        answer = 987654321;
        for(int i=1; i<=n; i++){
            answer = Math.min(dist[a][i] + dist[i][b] + dist[s][i], answer);
        }
        return answer;
    }
}