import java.util.*;

class Solution {
    static int lasttime=0;
    static int temperature, t1, t2, a, b;
    static int[] onboard;
    
    static int[][] dp;
    public int solution(int temperature, int t1, int t2, int a, int b, int[] onboard) {
        int answer = 0;
        lasttime = onboard.length;
        this.temperature = temperature;
        this.t1 = t1;
        this.t2 = t2;
        this.a = a;
        this.b = b;
        this.onboard = onboard;
        
        dp = new int[onboard.length + 1][100];
        for(int i=0; i<dp.length; i++){
            Arrays.fill(dp[i], -1);
        }
        
        answer = dfs(0, temperature); // 현재 온도, 소비전력
        return answer;
    }
    static int dfs(int t, int temp){
        if(t == lasttime){
            return 0;
        }
        
        // t1, t2 바깥일때
        if(onboard[t] == 1){
            if(temp<t1 || temp >t2) return 100000;
        }
        if(temp<-10 || temp> 40) return 100000;
        
        // 이미 방문한거 
        if(dp[t][temp+10] != -1) return dp[t][temp+10];
        
        int minnum = Integer.MAX_VALUE;
        // 에어컨 전원 킬때
        minnum = Math.min(minnum, a + dfs(t+1, temp+1));
        minnum = Math.min(minnum, b + dfs(t+1, temp));
        minnum = Math.min(minnum, a + dfs(t+1, temp-1));
        
        // 끌때
        if(temp<temperature){
            minnum = Math.min(minnum, dfs(t+1, temp+1));
        }else if(temp>temperature){
            minnum = Math.min(minnum, dfs(t+1, temp-1));
        }else{
            minnum = Math.min(minnum, dfs(t+1, temp));
        }
        
        dp[t][temp+10] = minnum;
        return minnum;
    }
}