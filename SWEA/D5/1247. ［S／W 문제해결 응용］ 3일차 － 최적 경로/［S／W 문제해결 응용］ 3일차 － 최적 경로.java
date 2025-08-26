import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static public class Pair {
		public int x, y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}		
	}
	static List<Pair> li;
	static int[] vis;
	static Pair home, company;
	static int mindistance, n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int test = 1; test<=t; test++) {
			n = Integer.parseInt(br.readLine());
			vis = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			int startx = Integer.parseInt(st.nextToken());
			int starty = Integer.parseInt(st.nextToken());
			company = new Pair(startx, starty);
			
			int endx = Integer.parseInt(st.nextToken());
			int endy = Integer.parseInt(st.nextToken());
			home = (new Pair(endx, endy));
			
			li = new ArrayList<>();
			mindistance = Integer.MAX_VALUE;
			for(int i=0; i<n; i++) {
				int ax = Integer.parseInt(st.nextToken());
				int bx = Integer.parseInt(st.nextToken());
				li.add(new Pair(ax, bx));
			}
			dfs(0, company , 0);
			System.out.println("#"+test+" "+mindistance);
		}
	}
	public static void dfs(int count,  Pair currentPos, int currentdist) {
		// 이미 최소 거리보다 클때
		if(currentdist>=mindistance) {
			return;
		}
		// 끝까지 했을때
		if(count == n) {
			int finaldist = currentdist + distance(currentPos, home);
			mindistance = Math.min(mindistance, finaldist);
			return;
		}
		// 순열 
		for(int i=0; i<n; i++) {
			 if(vis[i] == 0) {
				 vis[i] = 1;
				 // i번째 불러오기
				 Pair nextcustomer = li.get(i);
				 int distnext = distance(currentPos, nextcustomer);
				 dfs(count+1, nextcustomer, currentdist + distnext );
				 vis[i] = 0;
			 }
		}
	}
	public static int distance(Pair p1, Pair p2) {
		return Math.abs((p1.x - p2.x)) + Math.abs((p1.y-p2.y));
	}
}
