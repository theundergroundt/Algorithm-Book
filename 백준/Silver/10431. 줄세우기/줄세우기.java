import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int p = Integer.parseInt(br.readLine());
		for(int t=0; t<p; t++) {
			int[] arr = new int[1001];
			StringTokenizer st = new StringTokenizer(br.readLine());
			System.out.print(st.nextToken()+" ");
			int cnt = 0;
			for(int i = 0; i<20; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				
				if(i == 0) continue;
				
				int tmp = arr[i];
				//if(arr[i-1]<tmp) continue;
				for(int cur = i-1; cur>=0; cur--) {
					if(arr[cur]<tmp) continue;
					cnt++;
				}				
			}
			System.out.println(cnt);
		}
	}
}
