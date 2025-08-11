import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static List<Integer>[] li;
	static int[] vis;
	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("Test3.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		li = new ArrayList[n+1];
		for(int i=1; i<=n; i++) {
			li[i] = new ArrayList<>();
		}		
		
		for(int i=0; i<m; i++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st1.nextToken());
			int b = Integer.parseInt(st1.nextToken());
			li[a].add(b);
			li[b].add(a);
		}
		int total=0;
		vis = new int[n+1];
		for(int i=1; i<=n; i++) {
			if(vis[i]==0) {
				dfs(i);
				total++;
			}
		}
		System.out.println(total);
	}
	public static void dfs(int start) {
		vis[start] = 1;
		for(int c : li[start]) {
			if(vis[c]==1) continue;
			dfs(c);
		}
	}
}