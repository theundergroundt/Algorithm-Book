import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        
        List<List<int[]>> li = new ArrayList<>();
        for(int i=0; i<=N; i++) li.add(new ArrayList<>());
        
        for(int[] r : road){
            li.get(r[0]).add(new int[]{r[1], r[2]});
            li.get(r[1]).add(new int[]{r[0], r[2]});
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.offer(new int[]{1, 0}); // 노드번호, 거리
        
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int curnode = cur[0];
            int curdist = cur[1];
            if(dist[curnode] < curdist) continue;
            for(int[] neigh : li.get(curnode)){
                int newdist = neigh[1] + dist[curnode];
                if(dist[neigh[0]]>newdist){
                    dist[neigh[0]] = newdist;
                    pq.offer(new int[]{neigh[0], newdist});
                }
            }
        }
        for(int i=1; i<=N; i++){
            if(dist[i]<=K) answer++;
        }
        
        return answer;
    }
}