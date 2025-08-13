import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int[] li;
	static int[] vis;
	static Stack<Integer> st;
	static int total=0, n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		while(t-->0) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st1.nextToken());
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			li = new int[n+1];
			vis = new int[n+1];
			for(int i=1; i<=n; i++) {
				int num = Integer.parseInt(st2.nextToken());
				li[i]=num;				
			}
			total=0;
			for(int i=1; i<=n; i++) {
				if(vis[i] ==0) dfs(i);				
			}
			System.out.println(n - total);
		}
	}
	public static void dfs(int start) {
		vis[start]++;	
		int cur = li[start];
		// 방문한적 없을때
		if(vis[cur] == 0) dfs(cur);
		// 방문한적 있을때
		else if(vis[cur]==1) {
			for(int i= cur; i!=start; i=li[i]) {
				total++;
			}
			total++;
		}
		vis[start] = 2;
	}
}
/*
1
4
1 2 3 4
3 2 4 3
*/