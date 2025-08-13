import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int[] dx = {1,0,-1,0};
		int[] dy = {0,1,0,-1};
		int[][]arr = new int [n][m];
		int[][]dist = new int[n][m];
		Queue<int[]> q = new LinkedList<>();
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				int a = sc.nextInt();
				arr[i][j] = a;
				int[] tmp = {i,j};
				if(a == 1) q.add(tmp);
				else if(a==0) dist[i][j] = -1;
			}
		}
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			for(int dir = 0; dir<4; dir++) {
				int nx = cur[0] + dx[dir];
				int ny = cur[1] + dy[dir];
				if(nx<0 || nx>=n || ny<0 || ny>=m) continue;
				if(dist[nx][ny]>=0 || arr[nx][ny] == -1) continue;
				dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
				int[] tmp = {nx,ny};
				q.add(tmp);
			}
		}
		boolean chk = true;
		int maxtotal=0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(dist[i][j] == -1) {
					System.out.println(-1);
					chk = false;
					break;					
				}
				if(maxtotal<dist[i][j]) {
					maxtotal = dist[i][j];
				}
			}
			if(chk == false) break;
		}
		if(chk) {			
			System.out.println(maxtotal);
		}
	}
}
