import java.util.*;
class Solution {
    static int[][] triangle;
    static int[][] dp;
    public int solution(int[][] triangle) {
        int answer = 0;
        this.triangle =triangle;
        
        dp = new int[triangle.length + 1][triangle.length + 1];
        for(int i=0; i<triangle.length; i++){
            Arrays.fill(dp[i], -1);
        }
        answer = dfs(0,0);
        return answer;
    }
    static public int dfs(int a, int b){
        if(a == triangle.length) return 0;
        
        // 이미 확인한 dp
        if(dp[a][b] != -1) return dp[a][b];
        
        int maxnum = 0;
        maxnum = triangle[a][b] + Math.max(dfs(a+1,b+1), dfs(a+1, b));
        dp[a][b] = maxnum;
        return maxnum;
    }
}