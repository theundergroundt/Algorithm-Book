import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<Integer>[] arr = new ArrayList[n+1];
		int [] parent = new int[n+1];
		for(int i=1; i<=n; i++) {
			arr[i] = new ArrayList<>();
		}
		for(int i=0; i<n-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a].add(b);
			arr[b].add(a);
		}
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		parent[1]=1;
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int c : arr[cur]) {
				if(parent[c] >0) continue;
				parent[c] = cur;
				q.add(c);
			}
		}
		for(int i =2; i<=n; i++) {
			System.out.println(parent[i]);
		}
	}
}
