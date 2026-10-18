import java.util.*;

class Solution {
    public int solution(String name) {
        int answer = 0;
        
        // 'A'+13 위아래 따지기
        
        int[] arr = new int[name.length()];
        int totalnum = 0;
        for(int i=0; i<name.length(); i++){
            char c = name.charAt(i);
            int n = c - 'A';
            if(n == 0){
                arr[i] = 0;
                continue;
            }else if(n > 13){
                totalnum += (26 - n);
            }else totalnum += n;
            arr[i] = totalnum;
        }
        
        int minnum = 52;
        for(int i=0; i<name.length(); i++){
            
            // 연속된A가 어디서 끝나는지
            int nxt = i+1;
            while(nxt < name.length() && arr[nxt] == 0) nxt++;
            
            int back = i+i+name.length()-nxt; // 오른쪽 다시왼쪽 뒤에서앞으로
            int back2 = name.length() - nxt +(name.length() - nxt + i); // 뒤에서 앞으로 + 돌아가기 + 오른쪽
            
            minnum = Math.min(minnum, Math.min(back, back2));
            
        }
        int total = Math.min(minnum + totalnum, name.length() + totalnum);
        return total;
    }
}