import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        // 2 3 4 
        // 2 (1) 3 4
        // 5 2 
        
        boolean[][] dist = new boolean[n+1][n+1];
        
        for(int[] r : results){
            dist[r[0]][r[1]] = true;
        }
        
        for(int k=1; k<=n; k++){
            for(int i=1; i<=n; i++){
                for(int j=1; j<=n; j++){
                    if(dist[i][k] && dist[k][j]) dist[i][j] = true;
                }
            }
        }
        
        // n-1 = 지는 선수 + 이긴 선수 
        for(int i=1; i<=n; i++){
            int winnum = 0;
            int defeatnum = 0;
            for(int j=1; j<=n; j++){
                if(dist[i][j]) winnum++;
                if(dist[j][i]) defeatnum++;
            }
            if(winnum + defeatnum == n-1) answer++;
        }
        
        return answer;
    }
}