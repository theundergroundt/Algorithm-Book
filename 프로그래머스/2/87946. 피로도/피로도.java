import java.util.*;

class Solution {
    static int[] vis;
    static int answer;
    static int[][] dungeons;
    public int solution(int k, int[][] dungeons) {
        this.dungeons = dungeons;
        answer = 0;
        
        vis = new int[5001];
        dfs(k, 0);
        
        return answer;
    }
    
    static void dfs(int k, int t){
        answer = Math.max(t, answer);
        for(int i=0; i<dungeons.length; i++){
            if(vis[i] == 1) continue;
            if(k<dungeons[i][0]) continue;
            vis[i] = 1;
            dfs(k - dungeons[i][1], t+1);
            vis[i] = 0;
        }
    }
}