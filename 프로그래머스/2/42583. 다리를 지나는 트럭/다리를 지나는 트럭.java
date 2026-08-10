import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
        Queue<Integer> q = new LinkedList<>();
        for(int t=0; t<bridge_length; t++){
            q.offer(0);
        }
        
        int curweight = 0;
        int time=0;
        int i=0;
        while(i < truck_weights.length){
            time++;
            // q.peek 내보내기
            // 대기트럭 가져와서 원래 트럭 무게합이 최대무게 이하인지 확인
                // 이하면 큐에 넣기
                // 이하가 아니면 0 넣기
            curweight -= q.poll();
            int waittruck = truck_weights[i];
            if(waittruck + curweight <= weight){
                q.offer(waittruck);
                i++;
                curweight += waittruck;
            }else{
                q.offer(0);
            }
        }
        
        return time + bridge_length;
    }
}