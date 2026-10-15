import java.util.*;

class Solution {
    
    public int solution(int[][] routes) {
        
        // [-20,-15], [-18,-13], [-14,-5], [-5,-3]
        // 다음 노드 첫번째원소가 현재 노드 두번째 원소보다 작은지 큰지
        
        // 첫번째 원소 기준 오름차순 정렬
        Arrays.sort(routes,(a, b) -> Integer.compare(a[1], b[1]));
        

        int countcam = 1;
        int en = routes[0][1];
        for(int i=1; i<routes.length; i++){
            if(routes[i][0] > en){
                en = routes[i][1];
                countcam++;
            }           
            
        }
        
        return countcam;
    }
}