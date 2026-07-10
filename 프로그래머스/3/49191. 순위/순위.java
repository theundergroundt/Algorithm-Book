import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        int answer=0;
        boolean[][] graph = new boolean[n+1][n+1];
        
        for(int[] r : results){
            graph[r[0]][r[1]] = true;
        }
        
        for(int k=1; k<=n; k++){
            for(int i=1; i<=n; i++){
                for(int j=1; j<=n; j++){
                    if(graph[i][k] && graph[k][j]) graph[i][j] = true;
                }
            }
        }
        for(int i=1; i<=n; i++){
            int winnum = 0;
            int defeatnum = 0;
            for(int j=1; j<=n; j++){
                if(graph[i][j]) winnum++;
                if(graph[j][i]) defeatnum++;
            }
            if(winnum+defeatnum == n-1) answer++;
        }
        return answer;
    }
}