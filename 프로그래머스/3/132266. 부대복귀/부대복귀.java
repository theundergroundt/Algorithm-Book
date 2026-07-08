import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        // 지역, 지역, 거리
        List<List<Integer>> li = new ArrayList<>();
        for(int i=0; i<=n; i++){
            li.add(new ArrayList<>());
        }
        
        // 연결리스트에 지역 정보 담기
        for(int[] r : roads){
            li.get(r[0]).add(r[1]);
            li.get(r[1]).add(r[0]);
        }
        
        // 최단거리 담을 배열
        int[] dist = new int[n+1];
        Arrays.fill(dist, -1);
        dist[destination] = 0;
        
        // bfs 위한 큐 선언
        Queue<Integer> q = new LinkedList<>();
        q.offer(destination);
        
        while(!q.isEmpty()){
            int cur = q.poll();
            
            for(int c : li.get(cur)){
                if(dist[c] != -1) continue;
                dist[c] = dist[cur] + 1;
                q.offer(c);
            }
        }
        int i=0;
        int[] answer = new int[sources.length];
        for(int c : sources){
            if(dist[c] == -1) answer[i] = -1;
            else answer[i] = dist[c];
            i++;
        }
        return answer;
    }
}