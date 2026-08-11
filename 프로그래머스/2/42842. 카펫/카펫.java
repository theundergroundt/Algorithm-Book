import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        for(int h=3; h<brown+yellow+1; h++){
            for(int w=h; w<brown+yellow+1; w++){
                if(w*h == brown+yellow){
                    if((w-2)*(h-2) == yellow){
                        answer[0] = w;
                        answer[1] = h;
                        return answer;
                    }
                }
                if(w*h>brown + yellow) break;
            }
            
        }
        answer[0] = 0;
        answer[1] = 0;
        return answer;
    }
}