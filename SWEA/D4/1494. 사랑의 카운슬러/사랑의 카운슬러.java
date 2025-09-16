import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	public static class pair{
		int x,y;
		public pair(int x, int y) {
			this.x=x;
			this.y=y;
		}
	}
	static int n;
	static long minnum;
	static int[] vis;
	static pair[] li;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int test=1; test<=t; test++) {
			n = Integer.parseInt(br.readLine());
			li = new pair[n];
			vis = new int[n];
						
			for(int i=0; i<n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				li[i] = new pair(x,y);
			}
			minnum = Long.MAX_VALUE;
			dfs(0,0);
			System.out.println("#"+test+" "+minnum);
		}
	}
	public static void dfs(int start, int count) {
		if(count == n/2) {
			long sum1x = 0, sum1y=0, sum2x=0, sum2y=0;
			for(int i=0; i<n; i++) {
				if(vis[i] == 1) {
					sum1x+=li[i].x;
					sum1y+=li[i].y;
				}else {
					sum2x+=li[i].x;
					sum2y+=li[i].y;
				}
			}
			long result = (sum2x-sum1x)*(sum2x-sum1x) + (sum1y-sum2y)*(sum1y-sum2y);
			minnum = Math.min(result, minnum);
		}
		for(int i=start; i<n; i++) {
			vis[i] = 1;
			dfs(i+1, count+1);
			vis[i]=0;
		}
	}
}
