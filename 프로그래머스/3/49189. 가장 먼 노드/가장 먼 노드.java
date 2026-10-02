import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        // 1번 노드 고정
        
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
        dist[1]=0;
        
        int maxnum =0;
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int neigh : graph.get(cur)){
                if(dist[neigh]!=-1) continue;
                dist[neigh] = dist[cur]+1;
                q.offer(neigh);
                maxnum = Math.max(maxnum, dist[neigh]);
            }
        }
        for(int i=1; i<=n; i++){
            if(dist[i] == maxnum) answer++;
        }
        
        return answer;
    }
}