import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int test = 1; test<=t; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			arr = new int[n+1];
			for(int i=0; i<m; i++) {
				StringTokenizer st1 = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st1.nextToken());
				int b = Integer.parseInt(st1.nextToken());
				uni(a,b);
			}
			// 루트의 개수
			int[] vis = new int[n+1];
			for(int i=1; i<=n; i++) {
				int result = fin(i);
				vis[result] = 1;
			}
			int count =0;
			for(int i=1; i<=n; i++) {
				if(vis[i] == 1) count++;
			}
			System.out.println("#"+test+" "+count);
		}
	}
	public static int uni(int a, int b) {
		int fir = fin(a);
		int sec = fin(b);
		if(fir == sec) return 0;
		arr[sec] = fir;
		return 1;
	}
	public static int fin(int c) {
		if(arr[c] == 0) return c;
		return arr[c] = fin(arr[c]);
	}
}
