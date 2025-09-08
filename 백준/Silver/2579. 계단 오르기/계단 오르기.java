import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long total = 0;
		int[] arr = new int[n+1];
		int[] d = new int[n+1];
		for(int i=1; i<=n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			total += arr[i];
		}
		if(n<=2) {
			System.out.println(total);
			return;
		}
		// d[1] 최솟값 : d[1]
		// d[2] 최솟값 : d[2]
		d[1] = arr[1];
		d[2] = arr[2];
		d[3] = arr[3];
		for(int i=4; i<n; i++) {
			d[i] = arr[i]+Math.min(d[i-2], d[i-3]);
		}
		int result = Math.min(d[n-1], d[n-2]);
		System.out.println(total - result);
	}
}
