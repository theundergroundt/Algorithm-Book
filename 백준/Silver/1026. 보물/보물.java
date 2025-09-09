import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		List<Integer> li = new ArrayList<>();
		List<Integer> li2 = new ArrayList<>();
		for(int i=0; i<n; i++) {			
			int a = Integer.parseInt(st.nextToken());
			li.add(a);
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			int a = Integer.parseInt(st.nextToken());
			li2.add(a);
		}
		Collections.sort(li);
		Collections.sort(li2);
		int sum = 0;
		for(int i=0; i<n; i++) {
			sum+=(li.get(i) * li2.get(n-i-1));
		}
		System.out.println(sum);
	}
}
