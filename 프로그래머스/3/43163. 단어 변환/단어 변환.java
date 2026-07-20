import java.util.*;
class Solution {
    
    static String[] words;
    static boolean[] vis;
    static int answer;
    
    public int solution(String begin, String target, String[] words) {
        answer = 0;
        

        this.words = words;
        vis = new boolean[words.length+1];
        dfs(begin, target, 0);
        return answer;
    }
    
    static void dfs(String begin, String target, int cnt){
        if(begin.equals(target)) answer = cnt;
        
        for(int i=0; i<words.length; i++){
            if(vis[i]) continue;
            
            int k=0;
            for(int j=0; j<begin.length(); j++){
                if(begin.charAt(j) == words[i].charAt(j)) k++;
            }
            
            if(k == begin.length()-1) {
                vis[i] = true;
                dfs(words[i], target, cnt+1);
                vis[i] = false;
            }
        }
    }
}