import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Integer>[] li;
    static int[] vis;
    static int total=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        li = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            li[i] = new ArrayList<>();
        }
        for(int i=0; i<m; i++){
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st1.nextToken());
            int b = Integer.parseInt(st1.nextToken());
            // b를 해킹하면 a도 됌
            li[b].add(a);
        }
        int[] number = new int[n+1];
        for(int i=1; i<=n; i++){
            vis = new int[n+1];
            total = 0;
            dfs(i);
            number[i] =total;
        }
        int max = 0;
        for(int num : number){
            if(max<=num) max =num;
        }
        for(int i=1; i<=n; i++){
            if(number[i] == max) System.out.print(i+" ");
        }
    }
    public static void dfs(int start){
        vis[start] = 1;
        total++;
        for(int c : li[start]){
            // 사이클 방지
            if(vis[c] == 1) continue;
            dfs(c);

        }
        return;
    }
}
