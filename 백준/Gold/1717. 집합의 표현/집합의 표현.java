import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		arr = new int[1000005];
		for(int i=0; i<=n; i++) arr[i] = -1;
		for(int i=0; i<m; i++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st1.nextToken());
			int a = Integer.parseInt(st1.nextToken());
			int b = Integer.parseInt(st1.nextToken());
			int chk = 0;
			// union
			if(num == 0) {
				chk = uni(a, b);
			}else if(fin(a) == fin(b)) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
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
		if(arr[c] <0) return c;
		return arr[c] = fin(arr[c]);
	}
}
