import java.util.*;

class Solution {
    
    static int temperature, t1, t2, a, b, answer;
    static int[] onboard;
    static int[][] dp;
    
    public int solution(int temperature, int t1, int t2, int a, int b, int[] onboard) {
        answer = 0;
        this.temperature = temperature;
        this.t1 = t1;
        this.t2 = t2;
        this.a = a;
        this.b = b;
        this.onboard = onboard;
        
        dp = new int[onboard.length+1][51];
        
        for(int i=0; i<dp.length; i++){
            Arrays.fill(dp[i], -1);
        }
        
        answer = dfs(0, temperature);
        
        return answer;
    }
    
    static int dfs(int t, int temp){
        if(t == onboard.length) return 0;
        
        if(temp<-10 || temp>40) return 100000000;
        
        if(onboard[t] == 1){
            if(temp<t1 || temp>t2) return 100000000;
        }
        
        if(dp[t][temp + 10] != -1) return dp[t][temp + 10];
        
        // 에어컨 킨 상태
        // 온도올리기
        // 온도내리기
        // 온도 유지하기
        
        int minset = 987654321;
        minset = Math.min(dfs(t+1, temp+1) + a, minset);
        minset = Math.min(dfs(t+1, temp-1) + a, minset);
        minset = Math.min(dfs(t+1, temp) + b, minset);
            
        // 에어컨 끈 상태
        // 온도 올라가기 or 온도 내려가기 or 온도 같아서 유지
        if(temp < temperature) minset = Math.min(dfs(t+1, temp+1), minset);
        else if(temp > temperature) minset = Math.min(dfs(t+1, temp-1), minset);
        else minset = Math.min(dfs(t+1, temp), minset);
        
        dp[t][temp + 10] = minset;
        return minset;        
    }
}