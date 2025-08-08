import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		List<Integer>[] li = new ArrayList[n+1];
		int[] vis = new int[n+1];
		for(int i=0; i<=n; i++) {
			li[i] = new ArrayList<>();
		}
		for(int i=0; i<m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			li[a].add(b);
			li[b].add(a);
		}
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		vis[1] = 1;
		int total =0;
		while(!q.isEmpty()) {
			int cur = q.poll();			
			if(vis[cur]==3) break;
			for(int c : li[cur]) {
				if(vis[c]>0)continue;
				vis[c] = vis[cur]+1;
				q.add(c);
				total++;
			}
		}
		System.out.println(total);
	}
}