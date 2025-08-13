import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {	
	static int n, maxH, b;
	static int[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int i=1; i<=t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n  = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			arr = new int[n+1];
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				arr[j] = Integer.parseInt(st1.nextToken());
			}
			maxH = Integer.MAX_VALUE;
			for(int j=1; j<=n; j++) {
				dfs(0,0,j, 0);
			}
			System.out.println("#"+i+" "+(maxH - b));
		}
	}
	public static void dfs(int start, int depth, int r, int cnt) {
		if(depth == r) {
			if(cnt>=b) {
				if(cnt<= maxH)maxH = cnt;				
			}
			return;
		}
		for(int i=start; i<n; i++) {			
			dfs(i+1, depth+1, r, cnt+arr[i]);			
		}
	}
}