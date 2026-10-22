import java.util.*;

class Solution {
    int[] dx = {1,0,-1,0};
    int[] dy = {0,1,0,-1};
    public int solution(String[] board) {
        int answer = 0;
        int n = board.length;
        int m = board[0].length();
        
        int[][] arr = new int[n][m];
        int i=0; 
        int startx=0, starty=0, targetx=0, targety=0;
        for(String b : board){
            for(int j=0; j<m; j++){
                char c = b.charAt(j);
                if(c == 'R'){
                    startx = i;
                    starty = j;
                }else if(c == 'G'){
                    targetx = i;
                    targety = j;
                }else if(c == 'D'){
                    arr[i][j] = -1;
                    continue;
                }else arr[i][j] = 0;
            }
            i++;
        }
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{startx, starty});
        
        int[][] dist = new int[n][m];
        for(int t=0; t<n; t++)Arrays.fill(dist[t], -1);
        dist[startx][starty] = 0;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            if(cur[0] == targetx && cur[1] == targety) return dist[cur[0]][cur[1]];
            
            for(int d=0; d<4; d++){
                int nx = cur[0];
                int ny = cur[1];
                while(true){
                    int tx = nx + dx[d];
                    int ty = ny + dy[d];
                    if(tx<0 || tx>=n || ty<0 || ty>=m || arr[tx][ty] ==-1) break;
                    nx = tx;
                    ny = ty;
                }
                
                
                if(dist[nx][ny] == -1){
                    dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
                    q.offer(new int[]{nx, ny});
                }
            }
            
        }
        return -1;
    }
}