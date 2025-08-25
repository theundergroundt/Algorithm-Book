import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int test = 1; test<=t; test++) {
			int n = Integer.parseInt(br.readLine());
			arr = new int[n+1];
			for(int i=0; i<=n; i++) arr[i] = -1;
			int k = Integer.parseInt(br.readLine());
			for(int i=0; i<k; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				uni(a, b);
			}
			int m = Integer.parseInt(br.readLine());
			System.out.println("Scenario "+test+":");
			for(int i=0; i<m; i++) {
				StringTokenizer st1 = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st1.nextToken());
				int b = Integer.parseInt(st1.nextToken());
				if(fin(a) == fin(b)) System.out.println(1);
				else System.out.println(0);
			}
			System.out.println();
		}
	}
	public static int uni(int a, int b) {
		// 부모 찾기
		int fir = fin(a);
		int sec = fin(b);
		if(fir == sec) return 0;
		arr[sec] = fir;
		return 1;
	}
	public static int fin(int c) {
		if(arr[c]<0) return c;
		return arr[c] = fin(arr[c]);
	}
}