import java.util.*;

class Solution {
    
    static int answer;
    static boolean[] vis;
    
    public int solution(String begin, String target, String[] words) {
        answer = 0;
        vis = new boolean[words.length];
        dfs(begin, target, words, 0);
        return answer;
    }
    
    public void dfs(String begin, String target, String[] words, int cnt){
        // 1. 중단조건
        if(begin.equals(target)){
            answer = cnt;
            return;
        }
        for(int i=0; i<words.length; i++){
            if(vis[i]) continue;
            
            // 한글자만 다른 단어 찾기
            int k=0;
            for(int j=0; j<begin.length(); j++){
                if(begin.charAt(j) == words[i].charAt(j)) k++;
            }
            
            // 한글자만 다른 해당 단어
            if(k == begin.length() - 1){
                vis[i] = true; // 방문 표시
                dfs(words[i], target, words, cnt+1);
                vis[i] = false;
            }
        }
    }
}