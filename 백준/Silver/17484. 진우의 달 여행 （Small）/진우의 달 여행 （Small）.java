import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][][] dp = new int[n][m][3];
		int[][] vis = new int[n][m];
		int chk=0;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				vis[i][j] = Integer.parseInt(st.nextToken());
				if(i==0) {
					dp[i][j][0] = vis[i][j];
					dp[i][j][1] = vis[i][j];
					dp[i][j][2] = vis[i][j];
					continue;
				}
				if(j-1>=0) dp[i][j][0] = vis[i][j] + Math.min(dp[i-1][j-1][1], dp[i-1][j-1][2]);
				else dp[i][j][0] = Integer.MAX_VALUE;
				dp[i][j][1] = vis[i][j] + Math.min(dp[i-1][j][0], dp[i-1][j][2]);
				if(j+1<m) dp[i][j][2] = vis[i][j] + Math.min(dp[i-1][j+1][0], dp[i-1][j+1][1]);
				else dp[i][j][2] = Integer.MAX_VALUE;
			}
		}
		
		int minnum = Integer.MAX_VALUE;
		for(int i = 0; i<m; i++) {
			for(int j=0; j<3; j++) {
				minnum = Math.min(minnum, dp[n-1][i][j]);				
			}
		}
		System.out.println(minnum);
	}
}
