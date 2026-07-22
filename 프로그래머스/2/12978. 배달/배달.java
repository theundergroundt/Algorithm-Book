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
        
        // 두 개의 지역, cost
        List<List<Node>> graph = new ArrayList<>();
        for(int i=0; i<=N; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int r[] : road){
            // 양방향
            int i1 = r[0];
            int i2 = r[1];
            int c = r[2];
            
            graph.get(i1).add(new Node(i2, c));
            graph.get(i2).add(new Node(i1, c));
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));
        
        int[] dist = new int[N+1];
        Arrays.fill(dist, 987654321);
        dist[1] = 0;
        
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int curNode = cur.index;
            int curCost = cur.cost;
            
                        
            for(Node neigh : graph.get(curNode)){
                
                if(dist[neigh.index] > dist[curNode] + neigh.cost){
                    dist[neigh.index] = dist[curNode] + neigh.cost;
                    pq.offer(new Node(neigh.index, dist[neigh.index]));
                }
            }
        }
        
        for(int i=1; i<=N; i++){
            if(dist[i]<=K) answer++;
        }

        return answer;
    }
}