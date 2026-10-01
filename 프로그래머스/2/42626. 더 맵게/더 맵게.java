import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<scoville.length; i++){
            pq.offer(scoville[i]);
        }
        int i=0;
        boolean isable = false;
        while(!pq.isEmpty()){
            int cur = pq.poll();
            if(cur>=K) {
                isable = true;
                break;
            }
            
            if(pq.isEmpty()) break;
            int cur2 = pq.poll();
            int num = cur + (cur2 *2);
            pq.offer(num);
            i++;
        }
        if(isable) return i;
        else return -1;
    }
}