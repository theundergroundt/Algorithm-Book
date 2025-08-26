import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int test = 1; test<= t; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			arr = new int[n+1];
			
			System.out.print("#"+test+" ");
			for(int i=0; i<m; i++) {
				StringTokenizer st1 = new StringTokenizer(br.readLine());
				int ord = Integer.parseInt(st1.nextToken());
				int a = Integer.parseInt(st1.nextToken());
				int b = Integer.parseInt(st1.nextToken());
				if(ord == 0) uni(a,b);
				else if(fin(a) == fin(b)) System.out.print(1);
				else System.out.print(0);
			}
			System.out.println();
		}
	}
	public static int uni(int a, int b) {
		int fir = fin(a);
		int sec = fin(b);
		if(fir == sec) return 0;
		arr[sec] = fir;
		return 1;
	}
	public static int fin(int c) {
		if(arr[c] == 0) return c;
		return arr[c] = fin(arr[c]);
	}
}