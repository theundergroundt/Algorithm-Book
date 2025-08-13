import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    static List<Integer>[] li;
    static List<Integer> result;
    static int n, m, total=0;
    public static void main(String[] args) throws NumberFormatException, IOException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i=1; i<=t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            li = new ArrayList[n+1];
            for(int j=0; j<n; j++) {
                li[j] = new ArrayList<>();
            }
            for(int j=1; j<n+1; j++) {
                li[j] = new ArrayList<>();
            }
            for(int j=1; j<=m; j++) {
                StringTokenizer st1 = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st1.nextToken());
                int b = Integer.parseInt(st1.nextToken());
                li[a].add(b);
                li[b].add(a);
            }

            total=0;
            result = new ArrayList<>();
            func(1);
            System.out.println("#"+i+" "+total);
        }
    }
    public static void func(int start) {
        if(start >n) {
            total++;
            return;
        }
        // 선택x
        func(start+1);
        // 선택o 
        boolean chk = true;
        for(int i : result) {
            if(li[start].contains(i)){
                chk = false;
                break;
            }
        }
        // 상극아닐때 
        if(chk == true){
            result.add(start);
            func(start+1);
            // 방금 들어간거 지우기
            result.remove(result.size()-1);
        }
    }
}