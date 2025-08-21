import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static public class Pair{
		public int x, y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;		
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		int[][] matrix = new int[n][n];
		int[] dx = {1,0,-1,0};
		int[] dy = {0,1,0,-1};
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			for(int j =0; j<n; j++) {
				matrix[i][j] = 	str.charAt(j) - '0';
			}
		}
		Queue<Pair> q = new LinkedList<>();
		List<Integer> result = new ArrayList<>();
		int total=0;
		int[][] vis = new int[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(matrix[i][j] == 0 || vis[i][j] == 1)continue;
				q.add(new Pair(i,j));
				total++;
				int cnt = 1;
				vis[i][j] = 1;
				while(!q.isEmpty()) {
					Pair cur = q.poll();
					
					for(int dir = 0; dir<4; dir++) {
						int nx = cur.x + dx[dir];
						int ny = cur.y + dy[dir];
						if(nx<0 || nx>=n|| ny<0 || ny>=n) continue;
						if(vis[nx][ny] == 1 || matrix[nx][ny] == 0) continue;
						q.add(new Pair(nx,ny));
						vis[nx][ny] = 1;
						cnt++;
					}
				}
				result.add(cnt);
			}
		}
		Collections.sort(result);
		System.out.println(total);
		for(int c : result) {
			System.out.println(c);
		}
	}
}
