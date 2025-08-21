import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	static public class Pair{
		public int x, y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;		
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] dx = {1,0,-1,0};
		int[] dy = {0,1,0,-1};
		for(int test=1; test<=10; test++) {
			int t = Integer.parseInt(br.readLine());
			int [][] matrix = new int[100][100];
			Queue<Pair> q = new LinkedList<>();
			for(int i=0; i<100; i++) {
				String s = br.readLine();
				for(int j =0; j<100; j++) {
					matrix[i][j] = s.charAt(j) - '0';
					if(matrix[i][j] == 2) q.add(new Pair(i,j));
				}
			}
			int[][]vis = new int[100][100];
			boolean chk = false;
			while(!q.isEmpty()) {
				Pair cur = q.poll();
				for(int dir = 0; dir<4; dir++) {
					int nx = cur.x + dx[dir];
					int ny = cur.y + dy[dir];
					if(nx<0 || nx>=100 || ny<0 || ny>=100) continue;
					if(matrix[nx][ny] == 1 || vis[nx][ny] == 1) continue;
					if(matrix[nx][ny] == 3) {
						chk = true;
						break;
					}
					vis[nx][ny] = 1;
					q.add(new Pair(nx, ny));
				}
			}
			if(chk) System.out.println("#"+test+" "+1);
			else System.out.println("#"+test+" "+0);
		}
	}
}
