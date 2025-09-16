import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int test=1; test<=t; test++) {
			int n = Integer.parseInt(br.readLine());
			int len = n;
			String[] str = new String[n+1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 홀수
			if(n%2 == 1) n = n/2+1;
			// 짝수 
			else n/=2;
			int idx = 0;
			int idx2 = 1;
			for(int i=0; i<len; i++) {
				String s = st.nextToken();
				if(i<n) {
					str[idx] = s;
					idx+=2;
				}
				else {
					str[idx2] = s;
					idx2+=2;
				}
			}
			System.out.print("#"+test+" ");
			for(int i=0; i<len; i++) System.out.print(str[i]+" ");
			System.out.println();
		}
	}
}
