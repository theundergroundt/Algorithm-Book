import java.util.*;

class Solution {
    public int solution(String name) {
        int answer = 0;
        
        int[] arr = new int[name.length()];
        int totalnum=0;
        for(int i=0; i<name.length(); i++){
            char c = name.charAt(i);
            if(c == 'A'){
                arr[i] = 0;
                continue;
            }else if(c-'A' > 13){
                arr[i] = 'Z' - c+1;
                
            }else{
                arr[i] = c-'A';
            }
            totalnum+=arr[i];
        }
        
        int minnum=52;
        for(int i=0; i<name.length(); i++){
            
            // 연속된 A 끝날때까지 찾기
            int nxt = i+1;
            while(nxt<name.length() && arr[nxt]==0){
                nxt++;
            } 
            
            // 오른쪽 유턴 +뒤에서앞으로
            int fir = i + i+ name.length()- nxt;
            // 뒤에서 앞으로 + 유턴 + i
            int sec = name.length() - nxt + name.length() - nxt + i;
            minnum = Math.min(minnum, Math.min(fir, sec));
        }
        answer = Math.min(minnum+totalnum, name.length()+ totalnum);
        return answer;
    }
}