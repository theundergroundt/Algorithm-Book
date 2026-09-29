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
        int answer = 0;
        
        List<List<Node>> graph = new ArrayList<>();
        for(int i=0; i<=N; i++) graph.add(new ArrayList<>());
        
        for(int i=0; i<road.length; i++){
            int a = road[i][0];
            int b = road[i][1];
            int c = road[i][2];
            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }
        
        int dist[] = new int[N+1];
        Arrays.fill(dist, 987654321);
        dist[1] = 0;
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0));
        // 출발점, 누적거리
        
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            if(cur.cost > dist[cur.index]) continue;
            int curNode = cur.index;
            int curCost = cur.cost;
            
            for(Node neigh : graph.get(curNode)){
                int newCost = neigh.cost + curCost;
                // 현재 노드를 거쳐서 이웃까지 가는 새 거리
                if(newCost< dist[neigh.index]){
                    dist[neigh.index] = newCost;
                    pq.offer(new Node(neigh.index, newCost));
                }
            }
        }
        for(int i=1; i<=N; i++) if(dist[i]<=K) answer++;
        return answer;
    }
}