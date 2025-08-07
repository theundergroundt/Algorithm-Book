import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[] result;
	static int[] arr;
	static int[] kal;
	static int n, limit, max, tot;
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int test =1; test<=t; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			limit = Integer.parseInt(st.nextToken());
			arr = new int[n];
			kal = new int[n];
			for(int i=0; i<n; i++) {
				StringTokenizer st1 = new StringTokenizer(br.readLine());
				arr[i] = Integer.parseInt(st1.nextToken());
				kal[i] = Integer.parseInt(st1.nextToken());
			}
			result = new int[n];
			max = 0;
			for(int i=1; i<=n; i++) {
				comb(0,0,i,0);
			}
			System.out.println("#"+test+" "+max);
		}
	}
	public static void comb(int start, int depth, int r, int k) {
		if(depth == r) {
			if(k>=limit) return;
			tot=0;
			for(int c : result) {
				tot+=c;
			}
			if(max<tot) {
				max = tot;
			}
			return;
		}
		for(int i = start; i<n; i++) {
			result[depth] = arr[i];
			k+=kal[i];
			comb(i+1, depth+1, r, k);
			k-=kal[i];
		}
	}
}	
