import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
        int[][] dist = new int[n+1][m+1];
        for(int[] p : puddles){
            dist[p[1]][p[0]] = -1;
        }
        
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(i==1 && j==1) {
                    dist[i][j] = 1;
                    continue;
                }
                if(dist[i][j] == -1) dist[i][j] = 0;
                else dist[i][j] = (dist[i-1][j]+dist[i][j-1])%1000000007;
            }
        }
        answer = dist[n][m];
        return answer;
    }
}