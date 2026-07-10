import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        // 시작점 1로 고정 bfs
        
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<=n; i++) graph.add(new ArrayList<>());
        
        for(int[] e : edge){
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        
        int[] dist = new int[n+1];
        Arrays.fill(dist, -1);
        dist[1] = 0;
        
        int maxnum = 0;
        
        while(!q.isEmpty()){
            int cur = q.poll();
            
            for(int g : graph.get(cur)){
                if(dist[g] != -1) continue;
                dist[g] = dist[cur]+1;
                q.offer(g);
                maxnum = Math.max(dist[g], maxnum);
            }
        }
        for(int i=1; i<=n; i++){
            if(dist[i] == maxnum) answer++;
        }
        
        return answer;
    }
}