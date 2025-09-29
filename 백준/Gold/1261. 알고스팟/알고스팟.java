import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static class pair implements Comparable<pair>{
		int x, y, w;
		public pair(int x, int y, int w) {
			this.x=x;
			this.y=y;
			this.w=w;
		}
		public int compareTo(pair other) {
			return this.w - other.w;
		}
	}
	static int n, m, map[][], dist[][];
	static int[] dx = {1,0,-1,0} ;
	static int[] dy = {0,1,0,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[m][n];
		dist = new int[m][n];
		for(int i=0; i<m; i++) {
			Arrays.fill(dist[i], Integer.MAX_VALUE);
			String s = br.readLine();
			for(int j=0; j<n; j++) {
				map[i][j] = s.charAt(j)-'0';
			}
		}
		dijkstra();
		System.out.println(dist[m-1][n-1]);
	}
	
	public static void dijkstra() {
		PriorityQueue<pair> pq = new PriorityQueue<>();
		pq.add(new pair(0,0,0));
		dist[0][0]=0;
		while(!pq.isEmpty()) {
			pair cur = pq.poll();
			int xx = cur.x;
			int yy = cur.y;
			int breakwallcount = cur.w;
			if(dist[xx][yy]>breakwallcount) continue;
			for(int d=0; d<4; d++) {
				int nx = xx+dx[d];
				int ny = yy+dy[d];
				if(nx<0||nx>=m||ny<0||ny>=n) continue;
				// 1 이면 +1
				// 0 이면 그대로
				//if(map[nx][ny] == 1) breakwallcount+=1;
				
				if(dist[nx][ny]>dist[xx][yy]+map[nx][ny]) {
					dist[nx][ny] = dist[xx][yy]+map[nx][ny];
					pq.add(new pair(nx, ny, dist[nx][ny]));
				}
			}
		}
	}
}
