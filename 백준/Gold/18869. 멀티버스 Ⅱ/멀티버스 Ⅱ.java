import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeSet;

// 이분탐색으로 풀어보기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] space = new int[m][n];

        for(int i=0; i<m; i++){
            int[] arr = new int[n];
            TreeSet<Integer> sortli = new TreeSet<>();
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                arr[j] = Integer.parseInt(st.nextToken());
                sortli.add(arr[j]);
            }
            // Treeset에 저장하면 자동정렬 + unique

            List<Integer> li = new ArrayList<>(sortli);

            // rank 저장하기
            int a = 0;
            for(int c : arr){
                int rank = Collections.binarySearch(li, c);
                space[i][a++] = rank;
            }
        }

        int count = 0;
        for(int i=0; i<m; i++){
            for(int j=i+1; j<m; j++){
                if(Arrays.equals(space[i], space[j])) count++;
            }
        }
        System.out.println(count);
    }
}
