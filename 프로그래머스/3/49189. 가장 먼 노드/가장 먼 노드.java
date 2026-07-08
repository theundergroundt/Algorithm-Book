import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        // 가중치 = 1 + 시작점 고정 -> bfs
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<=n; i++) graph.add(new ArrayList<>());
        
        for(int[] e : edge){
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        
        int[] dist = new int[n+1];
        Arrays.fill(dist, -1);
        dist[1] = 0;
        
        int maxnum = 0;
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int c : graph.get(cur)){
                if(dist[c] != -1) continue;
                dist[c] = dist[cur] + 1;
                q.offer(c);
                maxnum = Math.max(maxnum, dist[c]);
            }
        }
        for(int a : dist){
            if(a == maxnum) answer++;
        }
        
        return answer;
    }
}