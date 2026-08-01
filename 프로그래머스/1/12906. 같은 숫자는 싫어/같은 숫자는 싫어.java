import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        Deque<Integer> stack = new ArrayDeque<>();
        int t = 0;
        for(int i=0; i<arr.length; i++){
            if(i == 0) {
                stack.push(arr[i]);
                t++;
                continue;
            }
            
            if(stack.peek() == arr[i]){
                continue;
            }else {
                stack.push(arr[i]);
                t++;
            }
        }

        int[] answer = new int[stack.size()];
        while(!stack.isEmpty()){
            answer[t-1] = stack.pop();
            t--;
        }
        return answer;
    }
}