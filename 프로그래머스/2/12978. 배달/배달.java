import java.util.*;

class Solution {
    static public class Node implements Comparable<Node>{
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
        for(int[] r : road){
            int a = r[0];
            int b = r[1];
            int c = r[2];
            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0));
        
        int[] dist = new int[N+1];
        Arrays.fill(dist, 987654321);
        dist[1] = 0;
        
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int curNode = cur.index;
            int curCost = cur.cost;
            if(curCost>dist[curNode]){
                continue;
            }
            
            for(Node neighbor : graph.get(curNode)){
                int newCost = curCost + neighbor.cost;
                
                if(dist[neighbor.index] > newCost){
                    dist[neighbor.index] = newCost;
                    pq.offer(new Node(neighbor.index, newCost));
                }
            }
        }
        int answer = 0;
        for(int i=1; i<=N; i++){
            if(dist[i]<=K) answer++;
        }
        return answer;
    }
}