import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 부분집합
public class Solution {
	static int[] arr;
	static int[] kal;
	static int n, limit, max;
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
			max = 0;			
			comb(0,0,0);			
			System.out.println("#"+test+" "+max);
		}
	}
	public static void comb(int depth, int score, int k) {
		
		if(k>limit) return;
		if(depth == n) {
			if(max<score) {
				max = score;				
			}	
			return;
		}
		// 현재 자료 선택o
		comb(depth+1, score+arr[depth], k+kal[depth]);
		// 현재 자료 선택x 
		comb(depth+1, score, k);
	}
}