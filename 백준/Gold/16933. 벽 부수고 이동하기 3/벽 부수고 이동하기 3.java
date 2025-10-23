import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class State implements Comparable<State> {
		int x, y, k, cost;
		
		public State(int x, int y, int k, int cost) {
			this.x = x;
			this.y = y;
			this.k = k;
			this.cost = cost;
		}
		
		// 비용(cost)이 낮은 순서대로 정렬
		@Override
		public int compareTo(State other) {
			return this.cost - other.cost;
		}
	}
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0,1,0,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[n][m];
		for(int i=0; i<n; i++) {
			String s = br.readLine();
			for(int j=0; j<m; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		Queue<State> q = new PriorityQueue<>();
		// k : 안 부수기 0, 부수기+개수 k
		int[][][] vis = new int[n][m][k+1];
		
		q.add(new State(0,0,0,1));
		vis[0][0][0] = 1;
		while(!q.isEmpty()) {
			State cur = q.poll();
			int xx = cur.x;
			int yy = cur.y;
			int kk = cur.k;
			int cost = cur.cost;
			
			// 가지치기 
			if(vis[xx][yy][kk] != 0 && cost > vis[xx][yy][kk]) {
		        continue;
		    }
			
			for(int d = 0; d<4; d++) {
				int nx = xx + dx[d];
				int ny = yy + dy[d];
				if(nx<0 || nx>=n || ny<0 || ny>=m) continue;
				
				// 벽이 아닐때
				if(map[nx][ny] == 0) {
					int newCost = cost + 1;
					if(vis[nx][ny][kk] == 0 || newCost<vis[nx][ny][kk]) {	
						vis[nx][ny][kk] = newCost;
						q.add(new State(nx, ny, kk, newCost));
					}
				}
				// 밤 주의 
				// 벽일때
				else {
					// 아직 k번까지 안부쉈을때 + ()
					if(kk < k) {
						int newCost=0;
						if(cost%2 == 0) {
							newCost = cost+2;
						}else {							
							newCost = cost+1;
						}
						// 방문한적 없을때
						if(vis[nx][ny][kk+1] == 0 || newCost < vis[nx][ny][kk+1]) {							
							vis[nx][ny][kk+1] = newCost;
							q.add(new State(nx, ny, kk+1, newCost));							
						}

					}
				}
			}
		}
		int minnum = Integer.MAX_VALUE;
		for(int i=0; i<=k; i++) {
			if(vis[n-1][m-1][i] == 0)continue;
			minnum = Math.min(minnum, vis[n-1][m-1][i]);
		}
		if(minnum == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(minnum);
//		for(int i=0; i<n; i++) {
//			for(int j=0; j<m; j++) {
//				System.out.print(vis[i][j][2]+" ");
//			}
//			System.out.println();
//		}		
	}
}
