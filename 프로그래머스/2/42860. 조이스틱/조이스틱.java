import java.util.*;

class Solution {
    public int solution(String name) {
        int totalnum = 0;
        int[] number = new int[name.length() + 1];
        // A 제외 나머지 문자 처리
        for(int i=0; i<name.length(); i++){
            char c  = name.charAt(i);
            int t = c - 'A';
            if(t == 0){
                number[i] = 0;
                continue;
            }else if(t>13){
                totalnum += ('Z' - c+1);
            }
            else totalnum += t;   
            
            number[i] = 1;
        }
        // 커서 이동 처리
        // 1 1 1 1 1
        // 1 0 1 
        int minnum = 51;
        for(int i=0; i<name.length(); i++){
            int nxt = i+1;
            while(nxt<name.length() && number[nxt] == 0) nxt++;
            
            // A전까지 오른쪽으로 이동 + 끝에서부터 A뒤까지 이동 + 유턴or뒤에서터올건지
            minnum = Math.min(minnum, i + name.length()-nxt + Math.min(i, name.length() - nxt));
        }
        int total = Math.min(minnum + totalnum, name.length() + totalnum);
        return total;
    }
}