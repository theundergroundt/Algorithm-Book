import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        Deque<Integer> stack = new ArrayDeque<>();
        int[] answer = new int[speeds.length];
        int t = 0;
        for(int i=0; i<progresses.length; i++){
            int restnum = 100 - progresses[i];
            int curnum = 0;
            
            if(restnum % speeds[i] != 0){
                curnum = restnum/speeds[i] + 1;
            }else curnum = restnum/speeds[i];
            
            if(stack.isEmpty() || stack.peek() < curnum) {
                stack.push(curnum);
                t = stack.size() - 1;
                answer[t] = 1;
            }else{
                answer[t]++;
            }
        }
        
        int[] result = new int[t+1];
        for(int i=0; i<=t; i++){
            result[i] = answer[i];
        }
        return result;
    }
}