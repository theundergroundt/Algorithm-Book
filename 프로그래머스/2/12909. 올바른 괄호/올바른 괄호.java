import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        Deque<Character> stack = new ArrayDeque<>();
        
        for(int i=0; i<s.length(); i++){
            
            char c = s.charAt(i);
            if(stack.isEmpty() && c == ')'){
                answer = false;
                break;
            }
            
            if(stack.isEmpty()) {
                stack.push(c);
                continue;
            }
            
            if(stack.peek() == '(' && c == ')'){
                stack.pop();
            }else if(stack.peek() == '(' && c == '('){
                stack.push(c);
            }else stack.push(c);
        }
        
        if(!stack.isEmpty() && answer) answer = false;

        return answer;
    }
}