import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int removenum = 0;
        for(int i=0; i<number.length(); i++){
            char c = number.charAt(i);
            
            while(removenum<k && sb.length()>0){
                char tmp = sb.charAt(sb.length() - 1);
            
                // 새로운 문자가 더 클 경우
                if(tmp < c){
                    sb.deleteCharAt(sb.length() - 1);
                    removenum++;
                    
                }else{
                    break;
                }   
            }
            sb.append(c);
        }
        while(removenum<k){
            sb.deleteCharAt(sb.length()-1);
            removenum++;
        }
        return sb.toString();
    }
}