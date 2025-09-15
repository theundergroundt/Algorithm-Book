import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static class Node implements Comparable<Node>{
		int y,cost;
		public Node( int y, int cost) {
			this.y=y;
			this.cost=cost;
		}
		public int compareTo(Node other) {
			return this.cost - other.cost;
		}
	}
	static List<Node>[] li;
	static int[] dist;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		li = new ArrayList[N+1];
		dist = new int[N+1];
		for(int i=1; i<=N; i++) {
			li[i] = new ArrayList<>();
		}
		Arrays.fill(dist, Integer.MAX_VALUE);
		for(int i=1; i<=M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			li[a].add(new Node(b,c));
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		dist[start]=0;
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			int curcity = cur.y;
			int curcost = cur.cost;
			if(dist[curcity]<curcost) continue;
			for(Node c : li[curcity]) {
				if(dist[c.y]>curcost+c.cost) {
					dist[c.y] = curcost+c.cost;
					pq.add(new Node(c.y, dist[c.y]));
				}
			}
		}
		System.out.println(dist[end]);
	}
}
