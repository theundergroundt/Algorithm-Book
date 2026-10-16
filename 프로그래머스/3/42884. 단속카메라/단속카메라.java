import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 1;
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));
        
        int en = routes[0][1];
        for(int i=1; i<routes.length; i++){
            if(en < routes[i][0]){
                en = routes[i][1];
                answer++;
            }
        }
        return answer;
    }
}