import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	static int n, result = Integer.MAX_VALUE;
	static List<Integer>[] li;
	static int[] map, arr, vis;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());	
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[n+1];
		for(int i=1; i<=n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		vis = new int[n+1];
		li = new ArrayList[n+1];
		for(int i=1; i<=n; i++) li[i] = new ArrayList<>();
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			for(int j=0; j<num; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				li[i].add(tmp);
			}
		}
		dfs(1);
		if(result == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(result);
	}
	
	public static void dfs(int cnt) {
		if(cnt == n+1) {
			List<Integer> groupA = new ArrayList<>();
			List<Integer> groupB = new ArrayList<>();
			for(int i=1; i<=n; i++) {
				if(vis[i] == 1) {
					groupA.add(i);
				}else {
					groupB.add(i);
				}
			}
			if(groupA.isEmpty()||groupB.isEmpty()) return;
			if(iscorrect(groupA) && iscorrect(groupB)) {
				int count1 = 0, count2 = 0;
				for(int a : groupA) {
					count1 += arr[a];
				}
				for(int a : groupB) {
					count2 += arr[a];
				}
				result = Math.min(result, Math.abs(count1 - count2));
			}
			return;
		}
		vis[cnt] = 1;
		dfs(cnt+1);
		vis[cnt] = 0;
		dfs(cnt+1);
	}
	public static boolean iscorrect(List<Integer> group) {
		if(group.size()<=1) return true;
		int count = 1;
		int[] grovis = new int[n+1];
		Queue<Integer> q = new LinkedList<>();
		int cur = group.get(0);
		q.add(cur);
		grovis[cur] = 1;
		while(!q.isEmpty()) {
			int current = q.poll();
			for(int c : li[current]) {
				if(group.contains(c) && grovis[c] == 0) {
					grovis[c] = 1;
					q.add(c);
					count++;
				}
			}
		}
		return count == group.size();		
	}
}
