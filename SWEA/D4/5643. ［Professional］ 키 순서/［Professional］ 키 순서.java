import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static List<Integer>[] tallarr;
	static List<Integer>[] shortarr;
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int test = 1; test<=t; test++) {			
			n = Integer.parseInt(br.readLine());
			int m = Integer.parseInt(br.readLine());
			tallarr = new ArrayList[n+1];
			shortarr = new ArrayList[n+1];
			for(int i=1; i<=n; i++) tallarr[i] = new ArrayList<>();
			for(int i=1; i<=n; i++) shortarr[i] = new ArrayList<>();
			for(int i=0; i<m; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				tallarr[a].add(b);
				shortarr[b].add(a);
			}
			int result = 0;
			for(int i = 1; i<=n; i++) {
				int tallcnt = tallbfs(i);
				int shortcnt = shortbfs(i);
				//System.out.println(tallcnt+" "+shortcnt+" ");
				if((tallcnt+shortcnt) == n-1) {					
					result++;
				}
			}
			System.out.println("#"+test+" "+result);			
		}
	}
	public static int tallbfs(int i) {
		Queue<Integer> q = new LinkedList<>();
		int[] vis = new int[n+1];
		int cnt = 0;
		q.add(i);
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int c : tallarr[cur]) {
				if(vis[c] == 1) continue;
				q.add(c);
				vis[c] = 1;
				cnt++;
			}
		}
		return cnt;
	}
	public static int shortbfs(int i) {
		Queue<Integer> q = new LinkedList<>();
		int[] vis = new int[n+1];
		int cnt = 0;
		q.add(i);
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int c : shortarr[cur]) {
				if(vis[c] == 1) continue;
				q.add(c);
				vis[c] = 1;
				cnt++;
			}
		}
		return cnt;
	}
}
