import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();
        for(String s : participant){
            map.put(s, map.getOrDefault(s, 0)+1);
        }
        for(String s : completion){
            map.put(s, map.get(s)-1);
        }
        for(String k : map.keySet()){
            if(map.get(k)>0) return k;
        }
        return answer;
    }
}