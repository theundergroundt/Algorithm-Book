import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n+1];
		long[][] dp = new long[n+1][3];
		for(int i=1; i<=n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		if(n == 1) {
			System.out.println(arr[1]);
			return;
		}
		dp[1][1] = arr[1];
		dp[1][2] = 0;
		dp[2][1] = arr[2];
		dp[2][2] = arr[1]+arr[2];
		for(int i=3; i<=n; i++) {
			dp[i][1] = Math.max(dp[i-2][1], dp[i-2][2]) + arr[i];
			dp[i][2] = dp[i-1][1] + arr[i];			
		}
		long result = Math.max(dp[n][1], dp[n][2]);
		System.out.println(result);
	}
}
