import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	public static class Pair{
		int x, y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int[] dr = {-1, 1, 0, 0}; // 상, 하, 좌, 우
    static int[] dc = {0, 0, -1, 1};
	static List<Pair> li;
	static int[][] map;
	static int maxnum,  minwireLength, n;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int test = 1;test<=t; test++) {
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			li = new ArrayList<>();
			for(int i=0; i<n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<n;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());	
					if(map[i][j] == 1) {
						if(i==0 || i==n-1||j==0 || j==n-1) continue;
						li.add(new Pair(i, j));
					}
				}
			}
			minwireLength = Integer.MAX_VALUE;
			maxnum = 0;
			dfs(0,0,0);
			System.out.println("#"+test+" "+minwireLength);
		}		
	}
	public static void dfs(int index, int num, int sum) {
		
		if(index == li.size()) {
			if(num>maxnum) {
				maxnum = num;
				minwireLength = sum;
			}else if(num == maxnum) {
				minwireLength = Math.min(minwireLength, sum);
			}
			return;
		}
		
		Pair cur = li.get(index);
		int r = cur.x;
		int c = cur.y;
		for(int d=0; d<4; d++) {
			if(isconnectable(r,c,d)) {
				// 전선 2로 놓기
				int len = setwire(r,c,d,2);
				dfs(index+1, num+1, sum+len);
				// 전선 지우기
				setwire(r,c,d,0);
			}
		}
		dfs(index+1, num, sum);
	}
	// 전선 놓을 수 있는지 확인
	public static boolean isconnectable(int r, int c, int d) {
		int nr = r;
		int nc = c;
		while(true) {
			nr+=dr[d];
			nc+=dc[d];
			if(nr<0 || nr>=n || nc<0 || nc>=n) return true;
			// 코어나 전선 만남
			if(map[nr][nc] != 0) return false;
		}
	}
	// 전선 놓거나 지우기
	public static int setwire(int r, int c, int d, int value) {
		int len = 0;
		int nr = r;
		int nc = c;
		while(true) {
			nr+=dr[d];
			nc+=dc[d];
			if(nr<0 || nr>=n || nc<0 || nc>=n) break;
			map[nr][nc] = value;
			len++;
		}
		return len;
	}
}
