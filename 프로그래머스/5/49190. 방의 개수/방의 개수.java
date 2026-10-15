import java.util.*;

class Solution {
    static int dx[] = {0, 1, 1, 1, 0, -1, -1, -1};
    static int dy[] = {1, 1, 0, -1, -1, -1, 0, 1};
    // 메모리 제한 256mb = 4바이트 * 67000000칸 -> int[8000][8000] 한계임
    public int solution(int[] arrows) {
        
        Set<Long> visPoints = new HashSet<>();
        Set<Long> visEdges = new HashSet<>();
        
        visPoints.add(encode(0,0));
        
        int x=0;
        int y=0;
        int answer = 0;
        
        for(int a : arrows){
            for(int step =0; step<2; step++){
                // 한칸에 2번씩 이동
                int nx = x + dx[a];
                int ny = y + dy[a];
            
                long nextPoint = encode(nx, ny);
                long edge = encodeEdge(x, y, nx, ny);
            
                // 이미 방문한 점 + 처음 지나는 간선
                if(visPoints.contains(nextPoint) && !visEdges.contains(edge)) {
                    answer++;
                    //System.out.println("방! 좌표(" + nx + "," + ny + ") step에서");
                }
            
                visPoints.add(nextPoint);
                visEdges.add(edge);
            
                x = nx;
                y = ny;
        
            }
        }
        return answer;
    }
    // 점 하나를 long 키로 변환
    static long encode(int x, int y){
        return (long)(x + 100000)*1000000 + (y+100000);
    }
    // 두 점을 long 키로
    static long encodeEdge(int x1, int y1, int x2, int y2){
        long p1 = encode(x1, y1);
        long p2 = encode(x2, y2);
        
        return Math.min(p1, p2)*10000000000L + Math.max(p1, p2);
    }
}