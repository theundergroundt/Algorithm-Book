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
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int[] arr = new int[n+1];
        // 슬라이딩 윈도우
        for(int i=1; i<=n; i++){
            arr[i] = Integer.parseInt(st1.nextToken());
            arr[i]+=arr[i-1];
        }
        for(int i=0; i<m; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            System.out.println(arr[b]-arr[a-1]);
        }
    }
}