import java.util.*;
class Solution {
    static int[][] dp;
    static int[] onboard;
    static int temperature, t1, t2, a, b;
    
    static final int OFFSET = 10;
    public int solution(int temperature, int t1, int t2, int a, int b, int[] onboard) {
        int answer = 0;
        
        this.temperature = temperature;
        this.t1 = t1;
        this.t2 = t2;
        this.a = a;
        this.b = b;
        this.onboard = onboard;
        
        dp = new int[onboard.length + 1][100];
        for(int i=0; i< dp.length; i++){
            Arrays.fill(dp[i], -1);
        }
        answer = dfs(0, temperature);
        return answer;
    }
    static public int dfs(int t, int temp){
        if(t == onboard.length){
            return 0;
        }
        
        if(temp<-10 || temp>40) return 100000000;
        
        // 승객이 타고 있는데 쾌적 온도 외 인경우 안 고르게
        if(onboard[t] == 1){
            if(temp<t1 || temp>t2) return 100000;
        }
        
        // 이미 계산한값이면 바로 리턴
        if(dp[t][temp + OFFSET] != -1) return dp[t][temp + OFFSET];
        
        int besttemp = 100000000;
        
        besttemp= Math.min(besttemp, a + dfs(t+1, temp+1));
        besttemp= Math.min(besttemp, a + dfs(t+1, temp-1));
        besttemp= Math.min(besttemp, b + dfs(t+1, temp));
            
        // 에어컨 off
        int offtemp;
        if(temp < temperature) offtemp = temp+1;
        else if(temp > temperature) offtemp = temp-1;
        else offtemp = temp;
        besttemp = Math.min(besttemp, 0 + dfs(t+1, offtemp));
            
        dp[t][temp + OFFSET] = besttemp;
        return besttemp;
        
    }
}