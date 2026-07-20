import java.util.*;

class Solution {
    static int[][] dp;
    static int[][] triangle;
    public int solution(int[][] triangle) {
        int answer = 0;
        this.triangle = triangle;
        
        int leng = triangle.length;
        dp = new int[leng][leng];
        for(int i=0; i<dp.length; i++){
            Arrays.fill(dp[i], -1);
        }
        
        answer = dfs(0,0);        
        
        return answer;
    }
    static int dfs(int a, int b){
        if(a == triangle.length) return 0;
        
        if(dp[a][b] != -1) return dp[a][b];
        
        dp[a][b] = triangle[a][b] + Math.max(dfs(a+1, b), dfs(a+1, b+1));
        return dp[a][b];                                             
    }
}