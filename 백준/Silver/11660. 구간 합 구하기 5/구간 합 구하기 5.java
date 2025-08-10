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
        int[][] arr = new int[n+1][n+1];
        for(int i=1; i<=n; i++){
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++){
                arr[i][j] = Integer.parseInt(st1.nextToken());
                arr[i][j]+=arr[i][j-1];
            }
        }
        for(int i=0; i<m; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            int c = Integer.parseInt(st2.nextToken());
            int d = Integer.parseInt(st2.nextToken());
            int total=0;
            for(int j=a; j<=c; j++){
                total+= arr[j][d]-arr[j][b-1];
            }
            System.out.println(total);
        }
    }
}