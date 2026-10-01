import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        
        int lengthnum = triangle.length;
        int[][] dp = new int[lengthnum+1][lengthnum+1];
        for(int i=0; i<lengthnum+1; i++) Arrays.fill(dp[i], 0);
        
        dp[0][0] = triangle[0][0];
        for(int i=1; i<lengthnum; i++){
            for(int j=0; j<=i; j++){
                if(j == 0){
                    dp[i][j] = dp[i-1][j] + triangle[i][j];
                }else if(j == i){
                    dp[i][j] = dp[i-1][j-1] + triangle[i][j];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
                }
            }
        }
        int maxnum = 0;
        for(int i=0; i<lengthnum; i++){
            maxnum = Math.max(maxnum, dp[lengthnum-1][i]);
        }
        return maxnum;
    }
}