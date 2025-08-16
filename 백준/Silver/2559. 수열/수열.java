import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int maxnum=Integer.MIN_VALUE;
        int[] arr = new int[n+1];
        int num=0;
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            int a = Integer.parseInt(st1.nextToken());
            if(k==1){
                arr[i] = a;
                num = a;
            }
            else if(i<k){
                if(i!=0) {
                    arr[i]=arr[i-1]+a;
                    num = arr[i];
                }
                else {
                    arr[i] = a;
                }
            }
            else{
                arr[i]=arr[i-1]+a;
                num = arr[i]-arr[i-k];
            }

            if(i>=k-1){
                if(maxnum<num)maxnum = num;
            }

        }
        System.out.println(maxnum);
    }
}
// 3 1 -3 -12 -12 -9