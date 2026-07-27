import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String[] arr = new String[numbers.length];
        for(int i=0; i<numbers.length; i++){
            // 숫자를 문자열로 
            arr[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a+b));
        
        if(arr[0].equals("0")) return "0";
        
        StringBuilder sb = new StringBuilder();
        for(String s : arr) sb.append(s);
        return sb.toString();
    }
}