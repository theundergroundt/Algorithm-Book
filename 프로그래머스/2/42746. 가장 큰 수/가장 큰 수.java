import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] arr = new String[numbers.length];
        for(int i=0; i<numbers.length; i++){
            arr[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(arr, (a, b) -> (b+a).compareTo(a+b));
        
        if(arr[0].equals("0")) {
		    return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<numbers.length; i++){
            sb.append(arr[i]);
        }
        
        answer = sb.toString();
        return answer;
    }
}