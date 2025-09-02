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
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] dig = new int[n+1];
		List<Integer> li[] = new ArrayList[n+1];
		for(int i=1; i<=n; i++) li[i] = new ArrayList<>();
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			li[a].add(b);
			dig[b]++;
		}
		Queue<Integer> q = new LinkedList<>();
		for(int i=1; i<=n; i++) {
			if(dig[i]==0)q.add(i);
		}
		List<Integer> result = new ArrayList<>();
		while(!q.isEmpty()) {
			int cur = q.poll();
			result.add(cur);
			for(int c : li[cur]) {
				dig[c]--;
				if(dig[c]==0) {
					q.add(c);
				}				
			}
		}
		for(int a : result) System.out.print(a+" ");
	}
}