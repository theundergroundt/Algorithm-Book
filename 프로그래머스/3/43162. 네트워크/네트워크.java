import java.util.*;
class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        boolean[] vis = new boolean[n];
        for(int i=0; i<n; i++){
            
            if(!vis[i]){
                // 시작, n, computers
                dfs(i, n, computers, vis);
                answer++;
            }
        }
        
        return answer;
    }
    
    public void dfs(int start, int n, int[][] coms, boolean[] vis){
        vis[start] = true;
        for(int i=0; i<n; i++){
            // 나자신, 연결x
            if(start != i && coms[start][i] != 0 && !vis[i]){
                dfs(i, n, coms, vis);
            }
        }
    }
}