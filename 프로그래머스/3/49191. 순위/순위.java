import java.util.*;
class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        int[][] dist = new int[n+1][n+1];
        
        for(int[] r : results){
            dist[r[0]][r[1]] = 1;
        }
        
        for(int k=1; k<=n; k++){
            for(int i=1; i<=n; i++){
                for(int j=1; j<=n; j++){
                    if(dist[i][k]==1 && dist[k][j]==1) dist[i][j] = 1;
                }
            }
        }
        for(int i=1; i<=n; i++){
            int winnum = 0;
            int defeatnum = 0;
            for(int j=1; j<=n; j++){
                if(dist[i][j] == 1) winnum++;
                if(dist[j][i] == 1) defeatnum++;
            }
            if(winnum + defeatnum == n-1) answer++;
        }
        return answer;
    }
}