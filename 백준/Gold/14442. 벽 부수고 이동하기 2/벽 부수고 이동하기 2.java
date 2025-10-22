import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
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
		Queue<int[]> q = new LinkedList<>();
		// k : 안 부수기 0, 부수기+개수 k
		int[][][] vis = new int[n][m][k+1];
		
		q.add(new int[] {0,0,0});
		vis[0][0][0] = 1;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int xx = cur[0];
			int yy = cur[1];
			int kk = cur[2];
			for(int d = 0; d<4; d++) {
				int nx = xx + dx[d];
				int ny = yy + dy[d];
				if(nx<0 || nx>=n || ny<0 || ny>=m) continue;
				
				// 벽이 아닐때
				if(map[nx][ny] == 0) {
					 if(vis[nx][ny][kk]==0) {
						 vis[nx][ny][kk] = vis[xx][yy][kk] + 1;
						 q.add(new int[] {nx,ny,kk});
					 }
				}
				// 벽일때
				else {
					// 아직 k번까지 안부쉈을때 + ()
					if(kk < k && (vis[nx][ny][kk+1] == 0)) {
						
						vis[nx][ny][kk+1] = vis[xx][yy][kk]+1;
						q.add(new int[] {nx,ny, kk+1});
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
	}
}
