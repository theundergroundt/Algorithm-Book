import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        
        int n=0;
        for(int i : tangerine){
            n = Math.max(n, i);
        }
        
        int[] arr = new int[n+1];
        for(int i : tangerine){
            arr[i]++;
        }
        List<Integer> li = new ArrayList<>();
        for(int i : arr){
            li.add(i);
        }
        
        Collections.sort(li);
        
        for(int i = li.size() - 1; i>=0; i--){
            k-=li.get(i);
            answer++;
            if(k<=0){
                return answer;
            }
        }
        
        return answer;
    }
}
