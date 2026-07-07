import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        // destination에서 sorces까지 가기 
        
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<=n; i++) graph.add(new ArrayList<>());
        
        for(int[] r : roads){
            int a = r[0];
            int b = r[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        Queue<Integer> q = new LinkedList<>();
        q.offer(destination);
        
        int[] dist = new int[n+1];
        Arrays.fill(dist, -1);
        dist[destination] = 0;
        
        
        while(!q.isEmpty()){
            int cur = q.poll();
            
            for(int c : graph.get(cur)){
                if(dist[c] == -1){
                    dist[c] = dist[cur]+1;
                    q.offer(c);
                }
            }
        }
        int d = 0;
        for(int s : sources){
            if(dist[s] == -1) answer[d] = -1;
            else answer[d] = dist[s];
            d++;
        }
        
        return answer;
    }
}