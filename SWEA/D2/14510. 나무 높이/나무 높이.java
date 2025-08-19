import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int test =1; test<= t; test++) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n];
			int maxnum = Integer.MIN_VALUE;
			int total=0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<n; i++) {
				int a = Integer.parseInt(st.nextToken());
				arr[i] = a;
				total+=a;
				if(maxnum<a) maxnum = a;
			}
			total = maxnum*(n-1) - (total-maxnum);
			// 홀수 인 애들
			int cnt = 0;
			for(int i=0; i<n; i++) {
				if((maxnum-arr[i])%2 == 1) cnt++;
			}
			cnt = 2*cnt -1;
			
			if(total == 0) {
				System.out.println("#"+test+" "+0);
				continue;
			}
			
			int a = total/3;
			a*=2;
			int b = total%3;
			if(b>0) {
				if( b == 1) a +=1;
				else a = a+=2;
			}
			
			
			if(cnt<a)System.out.println("#"+test+" "+a);
			else System.out.println("#"+test+" "+cnt);
			
		}
	}
}

/*
5
2
5 5
2
4 2
2
3 4
4
2 3 10 5
4
1 2 3 4
*/