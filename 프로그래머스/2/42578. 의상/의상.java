import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();
        for(String[] c : clothes){
            String type = c[1];
            // map.getOrDefault(type, 0) 
            // = "type의 현재 값을 가져와라. 없으면 0을 줘라"
            map.put(type, map.getOrDefault(type, 0)+1);
        }
        int total = 1;
        for(int count : map.values()){
            total *= (count+1);
        }
        return total-1;
    }
}