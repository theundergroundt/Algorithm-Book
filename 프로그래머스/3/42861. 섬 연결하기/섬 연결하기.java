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
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        List<List<Node>> graph = new ArrayList<>();
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int[] co : costs){
            int a = co[0];
            int b = co[1];
            int c = co[2];
            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0, 0));
        
        boolean[] vis = new boolean[n+1];
        int totalcost = 0;
        int connected = 0;
        
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            if(vis[cur.index]) continue;
            
            vis[cur.index] = true;
            totalcost += cur.cost;
            connected++;
            
            for(Node g : graph.get(cur.index)){
                if(vis[g.index])continue;
                pq.offer(new Node(g.index, g.cost));
            }
        }
        if(connected == n) return totalcost;
        else return -1;
    }
}