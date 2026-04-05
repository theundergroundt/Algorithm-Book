import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        
        // 둘 다 오름차순 정렬
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        // 여벌 체육복 가져왔는데 도난
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                // 본인이라면
                if (lost[i] == reserve[j]) {
                    answer++; // 본인 것을 입고 수업 참가 가능
                    lost[i] = -1; // 더 이상 빌릴 필요 없음 (마킹)
                    reserve[j] = -1; // 더 이상 빌려줄 수 없음 (마킹)
                    break;
                }
            }
        }
        
        // 빌려주기
        for (int i = 0; i < lost.length; i++) {
            if (lost[i] == -1) continue; 
            
            for (int j = 0; j < reserve.length; j++) {
                if (reserve[j] == -1) continue; 
                
                // 앞번호나 뒷번호 학생에게 빌릴 수 있는지 확인
                if (lost[i] - 1 == reserve[j] || lost[i] + 1 == reserve[j]) {
                    answer++; 
                    reserve[j] = -1; 
                    break; 
                }
            }
        }
        
        return answer;
    }
}