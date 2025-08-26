import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
	// 노드 클래스
	static class Node implements Comparable<Node> {
		int x, y, cost;
		public Node(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}
		public int compareTo(Node other) {
			return this.cost - other.cost;
		}
	}
	
	static int n, INF = Integer.MAX_VALUE;
	static int[][] matrix, dist;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int test = 1; test<=t; test++) {
			n = Integer.parseInt(br.readLine());
			matrix = new int[n][n];
			dist = new int[n][n];
			
			for(int i=0; i<n; i++) {
				String s = br.readLine();
				// 거리배열 무한대로 초기화
				Arrays.fill(dist[i], INF);
				for(int j =0 ; j<n; j++) {
					matrix[i][j] = s.charAt(j)-'0';
				}
			}
			dikjstra();
			sb.append("#").append(test).append(" ").append(dist[n-1][n-1]).append("\n");
			
		}
		System.out.println(sb);
		
	}
	public static void dikjstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		// 시작점 
		dist[0][0] = 0;
		pq.add(new Node(0,0,0));
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			int curx = cur.x;
			int cury = cur.y;
			int curcost = cur.cost;
			// 이미 처리 dist는 무시
			if(curcost>dist[curx][cury]) continue;
			
			for(int dir = 0; dir<4; dir++) {
				int nx = dx[dir] + curx;
				int ny = dy[dir] + cury;
				if(nx<0 || nx>=n || ny<0 || ny>=n) continue;
				// 새로운 거리 값 구하기
				int newcost = matrix[nx][ny]+curcost;
				// 거리 값이 기존 경로보다 작을 경우
				if(newcost<dist[nx][ny]) {
					dist[nx][ny] = newcost;
					pq.add(new Node(nx, ny, newcost));
				}
			}
		}	
	}
}
