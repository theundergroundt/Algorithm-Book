import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new int[m][n];
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int total = 0;
        for(int i=0; i<m-1; i++){
            for(int j = i+1; j<m; j++){
                if(!compare(arr[i], arr[j])) total++;
            }
        }
        System.out.println(total);
    }
    private static boolean compare(int[] arr1, int[] arr2){
        for(int i = 0; i< n-1; i++){
            for(int j = i+1; j<n; j++){
                if(arr1[i] > arr1[j]) {
                    if(arr2[i] <= arr2[j]) {
                        return true;
                    }
                }else if(arr1[i] < arr1[j]) {
                    if(arr2[i] >= arr2[j]) {
                        return true;
                    }
                }else {
                    if(arr2[i] != arr2[j]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}