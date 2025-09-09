import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		int[] k = new int[n+1];
		int[] s = new int[t+1];
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			k[i] = Integer.parseInt(st.nextToken());
			s[i] = Integer.parseInt(st.nextToken());
		}
		int[][] d = new int[n+1][t+1];
		for(int i=1; i<= n; i++) {
			for(int w = 1; w<=t; w++) {
				if(w<k[i]) d[i][w] = d[i-1][w];
				else d[i][w] = Math.max(d[i-1][w], s[i] + d[i-1][w - k[i]]);
			}
		}
		System.out.println(d[n][t]);
	}
}
