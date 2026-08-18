import java.util.*;

class Solution {
    public int solution(int[][] jobs) {

        // 대기큐가 비어있지 않을때 
        // 작업의 소요시간이 짧은 것, 작업의 요청 시각이 빠른 것, 작업의 번호가 작은 것
        
        // 요청 시각 빠른 순으로 배열 정렬
        Arrays.sort(jobs, (a, b) -> 
            Integer.compare(a[0], b[0])
        );
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            // 요청 시각이 같을때
            if(a[1] != b[1]) return Integer.compare(a[1], b[1]);
            
            else return Integer.compare(a[0], b[0]);
        });
        
        int t = 0;
        int total = 0;
        int tasknum = 0; // 작업 수
        int i = 0;
        while(tasknum < jobs.length){
            
            // 현재 시각 해당 작업 다 큐에 넣기
            while(i < jobs.length && jobs[i][0] <= t){
                pq.offer(new int[]{ jobs[i][0], jobs[i][1]});
                i++;
            }
            if(pq.isEmpty()) t = jobs[i][0];
            else{
                int[] cur = pq.poll();
                t+=cur[1];
                total += (t-cur[0]);
                tasknum++;
            }
        }   
        
        return total/jobs.length;
    }
}