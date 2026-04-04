import java.util.*;


class Solution {
    
    int[] dx = {1,0,-1,0};
    int[] dy = {0,1,0,-1};
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        
        int[][] map = new int[102][102];
        
        for(int[] r : rectangle){
            int x1 = r[0]*2;
            int y1 = r[1]*2;
            int x2 = r[2]*2;
            int y2 = r[3]*2;
            
            for(int x = x1; x<=x2; x++){
                for(int y = y1; y<=y2; y++){
                    if(map[x][y] == 2) continue;
                    
                    if(x == x1 || x == x2 || y == y1 || y == y2){
                        map[x][y] = 1;
                    }else{
                        map[x][y] = 2;
                    }
                }
            }
        }
        
        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[102][102];
        
        // 현재 x, 현재 y, 이동 거리
        q.offer(new int[]{characterX*2, characterY*2, 0});
        vis[characterX*2][characterY*2] = true;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int dist = cur[2];
            
            if(x == itemX*2 && y == itemY*2){
                return dist/2;
            }
            
            for(int d = 0; d<4; d++){
                int nx = dx[d] + x;
                int ny = dy[d] + y;
                
                if(nx>=0 && nx<=100 && ny>=0 && ny<=100){
                    if(!vis[nx][ny] && map[nx][ny] == 1){
                        vis[nx][ny] = true;
                        q.offer(new int[] {nx,ny, dist+1});
                    }
                }
            }
        }
        
        
        return 0;
    }
}