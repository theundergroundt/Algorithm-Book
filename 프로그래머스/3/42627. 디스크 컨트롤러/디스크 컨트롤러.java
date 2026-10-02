import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        
        Arrays.sort(jobs, (a,b) -> Integer.compare(a[0], b[0]));
        
        // 작업의 소요시간이 짧은 것, 작업의 요청 시각이 빠른 것, 작업의 번호가 작은 것
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->{
            if(a[1] != b[1]) return Integer.compare(a[1], b[1]);
            else return Integer.compare(a[0], b[0]);
        });
        
        // 종료조건 : 모든 작업 다했을때
        int tasknum = 0;
        int i=0;
        int t=0; // 현재 시간
        int total = 0;
        // 시간 별로 돌아감
        while(tasknum < jobs.length){
            // t 시간에 들어갈 수 있는 작업 모두 넣기
            while(i < jobs.length && jobs[i][0] <= t){
                pq.offer(new int[]{jobs[i][0], jobs[i][1]});
                i++;
            }
            if(pq.isEmpty()) t = jobs[i][0];
            else{
                int[] cur = pq.poll();
                t+=cur[1];
                total += (t - cur[0]);
                tasknum++;
            }
        }
        
        return total/tasknum;
    }
}