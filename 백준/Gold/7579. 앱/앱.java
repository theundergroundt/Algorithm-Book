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
		int[] v = new int[n+1];
		int[] c = new int[n+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++) {
			v[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++) {
			c[i] = Integer.parseInt(st.nextToken());
		}
		// 비용 c를 사용해서 확보할 수 있는 최대 메모리는 얼마인가?
		// d테이블 채우기 
		int[]d = new int[10002];
		for(int i=1; i<=n; i++) {
			for(int w = 10001; w>=c[i]; w--) {
				d[w] = Math.max(d[w], v[i] + d[w - c[i]]);				
			}
		}
		for(int i=0; i<=10001; i++) {
			if(d[i]>=m) {
				System.out.println(i);
				return;
			}
		}
	}
}