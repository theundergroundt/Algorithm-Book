import java.util.*;

class Solution {
    static int[] dx = {0,1,1,1,0,-1,-1,-1};
    static int[] dy = {1,1,0,-1,-1,-1,0,1};
    public int solution(int[] arrows) {
        
        
        Set<Long> visPoints = new HashSet<>();
        Set<Long> visEdges = new HashSet<>();
        
        visPoints.add(encode(0,0));
        
        int x = 0, y=0;
        int answer = 0;
        
        for(int a : arrows){
            for(int step=0; step<2; step++){
                int nx = x+dx[a];
                int ny = y+dy[a];
            
                long nextPoint = encode(nx, ny);
                long edge = encodeEdge(x, y, nx, ny);
                
                if(visPoints.contains(nextPoint) && !visEdges.contains(edge)){
                    answer++;
                }
                
                visPoints.add(nextPoint);
                visEdges.add(edge);
                
                x = nx;
                y = ny;
            }   
        }
        return answer;
    }
    static long encode(int x, int y){
        return((long)(x+200000)*1000000+(y+200000));
    }
    static long encodeEdge(int x1, int y1, int x2, int y2){
        long p1 = encode(x1, y1);
        long p2 = encode(x2, y2);
        return Math.min(p1,p2)*100000000000L + Math.max(p1,p2);
    }
}