import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static class pair{
		int x,y;
		public pair(int x, int y) {
			this.x=x;
			this.y=y;
		}
	}
	public static class Node implements Comparable<Node>{
		int a,b, cost;
		public Node(int a, int b, int cost) {
			this.a=a;
			this.b=b;
			this.cost=cost;
		}
		public int compareTo(Node other) {
			return this.cost - other.cost;
		}
	}
	static int[][] map;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] dx = {1,0,-1,0};
		int[] dy = {0,1,0,-1};
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[][] vis = new int[n][m];
		int num = 0;		
		Queue<pair> q = new LinkedList<>();
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(vis[i][j]>0||map[i][j]==0) continue;
				q.offer(new pair(i, j));
				num++;
				map[i][j] = num;
				while(!q.isEmpty()) {
					pair cur = q.poll();
					for(int d=0; d<4; d++) {
						int nx = cur.x + dx[d];
						int ny = cur.y + dy[d];
						if(nx<0||nx>=n||ny<0||ny>=m) continue;
						if(vis[nx][ny] == 1 || map[nx][ny]==0)continue;
						// 번호 매기기 
						map[nx][ny] = num;
						q.offer(new pair(nx,ny));
						vis[nx][ny] = 1;
					}
				}
			}
		}
		// 다리 찾기 
		List<Node>li = new ArrayList<>();
		int[][] result = new int[n][m];
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {				
				if(map[i][j] == 0) continue;
				for(int d=0; d<4; d++) {
					int nx = i;
					int ny = j;
					int length=0;
					while(true) {
						nx+=dx[d];
						ny+=dy[d];
						if(nx<0||nx>=n||ny<0||ny>=m) break; 
						if(map[nx][ny] == map[i][j]) break;						
						if(map[nx][ny] == 0) length++;
						else {
							if(length>=2) {
								li.add(new Node(map[i][j], map[nx][ny], length));
							}
							break;
						}
					}
				}
			}
		}
		// mst
		Collections.sort(li);
		int[] parent = new int[num+1];
		for(int i=1; i<=num; i++) parent[i] = i;
		int totallength = 0;
		int connectedge = 0;
		arr = new int[num+1];
		for(int i=1; i<=num; i++)arr[i] = i;
		for(Node cur : li) {
			if(fin(cur.a)!=fin(cur.b)) {
				uni(cur.a, cur.b);
				totallength += cur.cost;
				connectedge++;
			}
		}
		if(connectedge != num-1 || connectedge==0) System.out.println(-1);
		else System.out.println(totallength);
	}
	public static int uni(int r, int c) {
		int fir = fin(r);
		int sec = fin(c);
		if(fir == sec) return 0;
		arr[sec] =fir;
		return 1;
	}
	public static int fin(int t) {
		if(arr[t] == t) return t;
		return arr[t] = fin(arr[t]);
	}
}
