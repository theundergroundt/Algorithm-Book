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
        
        // 연결 리스트
        // 초기화
        List<List<Node>> li = new ArrayList<>();
        for(int i=0; i<=n; i++) li.add(new ArrayList<>());
        
        for(int[] c : costs){
            li.get(c[0]).add(new Node(c[1], c[2]));
            li.get(c[1]).add(new Node(c[0], c[2]));
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0,0));
        
        boolean[] vis = new boolean[n+1];
        
        int totalcost = 0;
        int connected = 0;
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            if(vis[cur.index]) continue;
            
            vis[cur.index] = true;
            totalcost += cur.cost;
            connected++;
            
            for(Node l : li.get(cur.index)){
                if(vis[l.index]) continue;
                pq.offer(new Node(l.index, l.cost));
            }
        }
        
        if(connected == n) return totalcost;
        
        return answer;
    }
}