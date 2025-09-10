import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int[][] d = new int[n+1][n+1];
		for(int i=1; i<=n; i++) Arrays.fill(d[i], Integer.MAX_VALUE);
		for(int i=1; i<=m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			d[a][b] = Math.min(d[a][b], c);
		}
		for(int i=1; i<=n; i++) d[i][i] = 0;
		for(int k=1; k<=n; k++) {
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=n; j++) {
					if(d[i][k]!=Integer.MAX_VALUE && d[k][j]!=Integer.MAX_VALUE)
					d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
										
				}
			}
		}
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if( d[i][j] == Integer.MAX_VALUE) System.out.print(0+" ");
				else System.out.print(d[i][j]+" ");
			}
			System.out.println();
		}
	}
}
