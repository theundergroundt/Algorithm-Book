import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        
        Stack<Integer> st = new Stack<>();
        int[] arr = new int[prices.length];
        
        for(int i=0; i<prices.length; i++){
            // 이전 가격보다 떨어졌을때 앞에것들 계산하기
            while (!st.isEmpty() && prices[st.peek()] > prices[i]) {
                int cur = st.pop();
                arr[cur] = i - cur; 
            }
            st.push(i);
        }
        
        // 
        while (!st.isEmpty()) {
            int cur = st.pop();
            arr[cur] = (prices.length-1) - cur;
        }
        return arr;
    }
}