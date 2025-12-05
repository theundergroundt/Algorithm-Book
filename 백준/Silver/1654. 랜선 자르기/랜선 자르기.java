import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[K];
        long maxnum = 0;
        for(int i = 0; i<K; i++){
            arr[i] = Integer.parseInt(br.readLine());
            if(arr[i]>maxnum) maxnum = arr[i];
        }

        long min = 1;
        long mid = 0;
        while(min<=maxnum){
            mid = (min + maxnum)/2;

            long count = 0;

            for(int i = 0; i<arr.length; i++){
                count += arr[i]/mid;
            }
            
            if(count<N){
                maxnum = mid-1;
            }else{
                min = mid+1;
            }
        }
        System.out.println(maxnum);
    }
}