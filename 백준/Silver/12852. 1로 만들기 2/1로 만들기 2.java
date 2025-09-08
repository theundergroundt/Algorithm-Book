import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] d = new int[n+1];
		int[] pre = new int[n+1];
		d[1] = 0;
		for(int i=2; i<=n; i++) {
			d[i] = d[i-1]+1;
			pre[i] = i-1;
			if(i%3 == 0 && d[i/3] +1 <d[i]) {
				d[i] = Math.min(d[i/3]+1, d[i]);
				pre[i] = i/3;
			}
			if(i%2 == 0 && d[i/2] +1 <d[i]) {
				d[i] = Math.min(d[i/2]+1, d[i]);
				pre[i] = i/2;
			}
		}
		System.out.println(d[n]);
		int c = n;
		while(true) {			
			System.out.print(c+" ");
			if(c == 1) break;
			c = pre[c];
		}
	}
}
