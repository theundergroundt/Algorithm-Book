import java.util.*;

class Solution {
    static int temperature, t1, t2, a, b;
    static int[] onboard;
    static int[][] dp;
    static final int offset = 10;
    public int solution(int temperature, int t1, int t2, int a, int b, int[] onboard) {
        int answer = 0;
        
        this.temperature = temperature;
        this.t1 = t1;
        this.t2 = t2;
        this.a = a;
        this.b = b;
        this.onboard = onboard;
        
        dp = new int[onboard.length+1][100];
        for(int i=0; i<dp.length; i++){
            Arrays.fill(dp[i], -1);
        }
        
        // 시간, 실내온도
        answer = dfs(0, temperature);
        
        return answer;
    }
    public int dfs(int t, int temp){
        // 종료조건
        if(t == onboard.length) return 0;
        
        if(temp<-10 || temp >40) return 100000000;
        
        // 승객이 타있는데 온도 범위 벗어났을때
        if(onboard[t] == 1){
            if(temp < t1 || temp > t2) return 100000000;
        }
        
        if(dp[t][temp+offset] != -1) return dp[t][temp+offset];
        
        int mincost = 987654321;
        // 에어컨 켰을때
        mincost = Math.min(mincost, a + dfs(t+1, temp+1));
        mincost = Math.min(mincost, a + dfs(t+1, temp-1));
        mincost = Math.min(mincost, b + dfs(t+1, temp));
        
        // 에어컨 껐을때
        if(temp < temperature){
            mincost = Math.min(mincost, dfs(t+1, temp+1));
        }else if(temp > temperature){
            mincost = Math.min(mincost, dfs(t+1, temp-1));
        }else mincost = Math.min(mincost, dfs(t+1, temp));
        
        dp[t][temp+offset] = mincost;
        return mincost;
        
    }
}