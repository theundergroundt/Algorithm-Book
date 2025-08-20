import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static public class Pair{
		public int x, y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] dx = {1,0,-1,0};
		int[] dy = {0,1,0,-1};
		
		int t = Integer.parseInt(br.readLine());
		for(int test = 1; test<= t; test++) {
			int n = Integer.parseInt(br.readLine().trim());
			int[][] matrix = new int[n][n];
			int[][] vis;
			int maxnum = 0, minnum = Integer.MAX_VALUE;
			for(int i=0; i<n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<n; j++) {
					matrix[i][j] = Integer.parseInt(st.nextToken());
					if(maxnum<matrix[i][j]) maxnum = matrix[i][j];
					if(minnum>matrix[i][j]) minnum = matrix[i][j];
					
				}
			}
			
			Queue<Pair> q =new LinkedList<>();
			int maxcheese = 0;
			// 몇일 
			for(int day=0; day<=maxnum; day++) {
				int count = 0;
				// 계속 초기화
				vis = new int[n][n];
				for(int i=0; i<n; i++) {
					for(int j=0; j<n; j++) {												
						if(matrix[i][j]<=day) continue;
						if(vis[i][j] == 1) continue;
						vis[i][j] = 1;
						q.add(new Pair(i,j));						
						count++;
						while(!q.isEmpty()) {
							Pair cur = q.poll();
							for(int dir = 0; dir<4; dir++) {
								int nx = cur.x + dx[dir];
								int ny = cur.y + dy[dir];
								if(nx<0 || nx>=n || ny<0 || ny>=n) continue;
								if(vis[nx][ny] == 1)continue;
								int num = matrix[nx][ny];
								// 요정이 먹은거
								if(num<=day) continue;
								q.add(new Pair(nx, ny));
								vis[nx][ny] = 1;
							}					
						}						
					}
				}
				if(maxcheese<count) maxcheese = count;
			}
			System.out.println("#"+test+" "+maxcheese);
		}
	}
}
