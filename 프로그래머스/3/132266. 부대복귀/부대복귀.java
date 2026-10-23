import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        
        // dist배열에 계속 +1
        // distination 기준
        
        List<List<Integer>> li = new ArrayList<>();
        for(int i=0; i<=n; i++) li.add(new ArrayList<>());
        
        for(int[] r : roads){
            li.get(r[0]).add(r[1]);
            li.get(r[1]).add(r[0]);
        }
        
        int[] dist = new int[n+1];
        Arrays.fill(dist, -1);
        dist[destination] = 0;
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{destination, 0});
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int curnode = cur[0];
            int curdist = cur[1];
            if(dist[curnode]<curdist) continue;
            
            for(int t : li.get(curnode)){
                if(dist[t] >= 0) continue;
                dist[t] = dist[curnode] + 1;
                q.offer(new int[]{t, dist[t]});
            }
        }
        
        for(int i=0; i<sources.length; i++){
            if(dist[sources[i]] == -1) answer[i] = -1;
            else answer[i] = dist[sources[i]];
        }
        
        return answer;
    }
}