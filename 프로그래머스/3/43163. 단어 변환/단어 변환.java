import java.util.*;

class Solution {
    static boolean[] vis;
    static int answer;
    public int solution(String begin, String target, String[] words) {
        answer = 0;
        vis = new boolean[words.length];
        dfs(begin, target, words, 0);
        return answer;
    }
    public void dfs(String begin, String target, String[] words, int cnt){
        if(begin.equals(target)){
            answer = cnt;
            return;
        }
        for(int i=0; i<words.length; i++){
            if(vis[i]) continue;
            
            int k=0;
            for(int j=0; j<begin.length(); j++){
                if(begin.charAt(j) == words[i].charAt(j)) k++;
            }
            
            if(k == begin.length()-1){
                vis[i] = true;
                dfs(words[i], target, words, cnt+1);
                vis[i] = false;
            }
        }    
    }
}