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
        // 인접리스트 만들기
        List<List<Node>> li = new ArrayList<>();
        for(int i=0; i<=N; i++){
            li.add(new ArrayList<>());
        }
        // 인접리스트 채우기
        for(int[] r : road){
            int a = r[0];
            int b = r[1];
            int c = r[2];
            li.get(a).add(new Node(b,c));
            li.get(b).add(new Node(a,c));
        }
        // 우선순위 큐 준비
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));
        
        int[] dist = new int[N+1];
        for(int i=0; i<=N; i++){
            dist[i] = Integer.MAX_VALUE;
        }
        
        dist[1] = 0;
        
        // 다익스트라 
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int curNode = cur.index;
            int curCost = cur.cost;
            
            for(Node neigh : li.get(curNode)){
                int newCost = neigh.cost + dist[curNode];
                
                if(dist[neigh.index] > newCost){
                    dist[neigh.index] = newCost;
                    pq.offer(new Node(neigh.index, newCost));
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