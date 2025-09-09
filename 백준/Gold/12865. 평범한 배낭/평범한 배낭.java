import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] w = new int[n+1];
		int[] v = new int[k+1];
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			w[i] = Integer.parseInt(st.nextToken());
			v[i] = Integer.parseInt(st.nextToken());
		}		
		int[][] d = new int[n+1][k+1];
		for(int i=1; i<=n; i++) {
			for(int e = 1; e<=k; e++) {
				if(e<w[i]) d[i][e] = d[i-1][e];
				else {
					d[i][e] = Math.max(d[i-1][e], v[i] + d[i-1][e - w[i]]);
				}
			}
		}
		System.out.println(d[n][k]);
	}
}
