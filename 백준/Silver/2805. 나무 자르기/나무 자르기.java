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
        int maxnum=0;
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i =0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if(maxnum<arr[i]) maxnum = arr[i];
        }
        long low = 0;
        long high = maxnum;
        long resulth = 0;
        while(low<=high){
            long mid = low+(high-low)/2;
            long treecut = 0;
            for(int tree : arr){
                if(tree>mid){
                    treecut+=tree - mid;
                }
            }
            if(treecut>=m){
                resulth = mid;
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        System.out.println(resulth);
    }
}
