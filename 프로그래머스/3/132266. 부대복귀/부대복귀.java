import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        
        List<List<Integer>> li = new ArrayList<>();
        for(int i=0; i<=n; i++) li.add(new ArrayList<>());
        
        for(int i=0; i<roads.length; i++){
            int a = roads[i][0];
            int b = roads[i][1];
            li.get(a).add(b);
            li.get(b).add(a);
        }
        int[] dist = new int [n+1];
        Arrays.fill(dist, -1);
        dist[destination] = 0;
        
        Queue<Integer> q = new LinkedList<>();
        q.offer(destination);
        
        while(!q.isEmpty()){
            int cur = q.poll();
            
            for(int c : li.get(cur)){
                if(dist[c] == -1){
                    dist[c] = dist[cur]+1;
                    q.offer(c);
                }
            }
        }
        int i=0;
        int[] answer = new int[sources.length];
        for(int s : sources){
            if(dist[s] == -1) answer[i] = -1;
            else answer[i] = dist[s];
            i++;
        }
        return answer;
    }
}