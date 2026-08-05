import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int priLength = priorities.length;
        Queue<int[]> q = new LinkedList<>();
        
        for(int i=0; i<priLength; i++){
            q.offer(new int[] {priorities[i], i});
        }
        
        Arrays.sort(priorities);
        int[] arr = new int[priLength];
        int t = priLength-1;
        for(int i=0; i<priLength; i++){
            arr[i] = priorities[t];
            t--;
        }
        
        t = 0;
        int num = 1;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            
            
            if(cur[0] == arr[t]){
                if(cur[1] == location){
                    answer = num;
                    break;
                }
                t++;
                num++;
            }else{
                q.offer(new int[]{cur[0], cur[1]});
            }
            
            
        }
        return answer;
    }
}