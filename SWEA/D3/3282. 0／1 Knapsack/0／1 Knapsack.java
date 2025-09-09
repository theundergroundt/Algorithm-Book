import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int test=1; test<=t; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			// n개, k부피
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int[] v = new int[n+1]; // 부피
			int[] c = new int[n+1]; // 가치
			for(int i=1; i<=n; i++) {
				st = new StringTokenizer(br.readLine());
				v[i] = Integer.parseInt(st.nextToken());
				c[i] = Integer.parseInt(st.nextToken());
			}
			// 민수가 가방에 담을 수 있는 최대 가치를 계산
			int[][] d = new int[n+1][k+1];
			for(int i = 1; i<=n; i++) {
				for(int w =1; w<=k; w++) {
					if(w<v[i]) {
						d[i][w] = d[i-1][w];
					}else {
						d[i][w] = Math.max(d[i-1][w],  c[i] + d[i-1][w - v[i]]);
					}
				}
			}
			System.out.println("#"+test+" "+d[n][k]);
		}
	}
}
