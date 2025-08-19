import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int test=1; test<=t; test++) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n];
			int maxnum = 0, idx = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());				
			}
			int cur=0;
			long cnt=0;
			for(int i=n-1; i>=0; i--) {
				cur = arr[i];
				if(maxnum<cur) {
					maxnum = cur;
					continue;
				}
				cnt+=(maxnum-cur);
			}
			System.out.println("#"+test+" "+cnt);
		}
	}
}