import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int test = 1; test<=t; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			// 1234567891
			long[] func = new long[1000001];
			func[0]=1;
			for(int i=1; i<=n; i++) {
				func[i] = (func[i-1]*i)%1234567891;
			}
			long np = func[n];
			long nmr = func[n-r];
			long rp = func[r];
			long tmpo = nmr*rp%1234567891;
			long exp = power(tmpo, 1234567891-2);
			long total = np*exp%1234567891;
			System.out.println("#"+test+" "+total);
		}
	}
	public static long power(long a, long exp) {
		long result = 1;
		a%= 1234567891;
		while(exp>0) {
			if(exp%2 == 1) {
				result = (result*a)%1234567891;
			}
			a = (a*a)%1234567891;
			exp /= 2;
		}
		return result;
	}
}
