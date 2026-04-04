import java.util.*;

class Solution {
    
    static class Node implements Comparable<Node>{
        int index;
        int cost;
        
        public Node(int index, int cost){
            this.index = index;
            this.cost = cost;
        }
        
        public int compareTo(Node other){
            return Integer.compare(this.cost, other.cost);
        }
    }
    
    public int solution(int N, int[][] road, int K) {
        
        List<List<Node>> graph = new ArrayList<>();
        for(int i=0; i<=N; i++){
            graph.add(new ArrayList<>());
        }
        
        // 그래프 값 저장
        for(int[] r : road){
            int u = r[0];
            int v = r[1];
            int cost = r[2];
            
            // 양방향 통행
            graph.get(u).add(new Node(v, cost));
            graph.get(v).add(new Node(u, cost));            
        }
        
        // dist max로 초기화
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        // 출발지
        dist[1] = 0;
        
        // 우선순위 큐 선언 
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        // 시작 노드, 비용 = 0 부터 
        pq.offer(new Node(1, 0));
        
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int curIndex = cur.index;
            int curCost = cur.cost;
            
            for(Node neighbor : graph.get(curIndex)){
                int newCost = neighbor.cost + dist[curIndex];
                
                if(newCost < dist[neighbor.index]){
                    dist[neighbor.index] = newCost;
                    pq.offer(new Node(neighbor.index, newCost));
                }
            }
        }
        int answer = 0;
        for(int i=1; i<=N; i++){
            if(dist[i] <= K){
                answer++;
            }
        }
        return answer;
    }
}