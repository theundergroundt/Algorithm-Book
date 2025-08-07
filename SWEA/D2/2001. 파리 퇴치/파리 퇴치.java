import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int s=0; s<t; s++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[][] arr = new int[n][n];
			int[][] count = new int[n][n];
			int max=0;
			for(int i=0; i<n; i++) {			
				StringTokenizer st1 = new StringTokenizer(br.readLine());
				for(int j=0; j<n; j++) {
					arr[i][j] = Integer.parseInt(st1.nextToken());
					if(i>=m-1 && j>=m-1) {
						for(int l = i; l>=i-m+1; l--) {
							for(int k = j; k>=j-m+1; k--) {
								count[i][j]+=arr[l][k];
							}
						}
					}
					if(max<count[i][j]) max = count[i][j];
				}
            }			
			System.out.println("#"+(s+1)+" "+max);
		}
	}
}
