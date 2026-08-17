import java.util.*;

class Solution {
    static int[] arr;
    public int solution(int n, int[][] wires) {
        int answer = n+1;
        arr = new int[n+1];
        
        // 하나를 끊기
        for(int t=0; t<wires.length; t++){
            for (int i=1; i<=n; i++) arr[i] = i;
            
            for(int i=0; i<wires.length; i++){
                if(t == i) continue;
                int a = wires[i][0];
                int b = wires[i][1];

                uni(a,b);
            }
            
            int num=0;
            for(int i=1; i<=n; i++){
                if(fin(1) == fin(i)) num++;
            }
            
            int result = Math.abs(num - n + num);
            answer = Math.min(answer, result);
        }
        
        return answer;
    }
    static void uni(int a, int b){
        int fir = fin(a);
        int sec = fin(b);
        if(fir == sec) return;
        arr[fir] = sec;
        return;
    }
    
    static int fin(int a){
        if(arr[a] == a) return a;
        return arr[a] = fin(arr[a]);
    }
}