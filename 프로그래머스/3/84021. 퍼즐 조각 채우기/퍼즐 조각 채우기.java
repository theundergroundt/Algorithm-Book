import java.util.*;
class Solution {
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    
    public int solution(int[][] game_board, int[][] table) {
        int answer = 0;
        
        int n = table.length;
        Queue<int[]> q = new LinkedList<>();
        int[][] arr = new int[n][n];
        // 개수 및 섬 번호 저장
        List<List<Integer>> number = new ArrayList<>();
        for(int i=0; i<n*n+1; i++) number.add(new ArrayList<>());
        // 섬 번호 및 회전 정보
        List<List<int[]>> li = new ArrayList<>();
        for(int i=0; i<n*n+1; i++) li.add(new ArrayList<>());
        
        // table 정보 그룹핑
        int num = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(arr[i][j] > 0 || table[i][j] == 0) continue;
                
                int totalnumber = 1;
                
                num++;
                arr[i][j] = num;
                q.offer(new int[]{i,j});
                li.get(num).add(new int[]{i,j});
                while(!q.isEmpty()){
                    int[] cur = q.poll();
                    
                    for(int d=0; d<4; d++){
                        int nx = cur[0] + dx[d];
                        int ny = cur[1] + dy[d];
                        if(nx<0 || nx>=n || ny<0 || ny>=n) continue;
                        if(arr[nx][ny] == num || table[nx][ny] == 0) continue;
                        totalnumber++;
                        
                        li.get(num).add(new int[]{nx, ny});
                        q.offer(new int[]{nx,ny});
                        arr[nx][ny] = num;
                        
                    }
                }
                number.get(totalnumber).add(num);
            }
        }
        
        boolean[] used = new boolean[num + 1];
        
        // game_board
        q = new LinkedList<>();
        List<int[]> game;
        int[][] vis = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(game_board[i][j] == 1 || vis[i][j] == 1) continue;
                
                game = new ArrayList<>();
                // 개수 찾기        
                int tmpnum=1;
                q.offer(new int[]{i, j});
                vis[i][j] = 1;
                game.add(new int[]{i, j});
                while(!q.isEmpty()){
                    int[] cur = q.poll();
                    
                    for(int d=0; d<4; d++){
                        int nx = cur[0] + dx[d];
                        int ny = cur[1] + dy[d];
                        if(nx<0 || nx>=n || ny<0 || ny>=n) continue;
                        if(game_board[nx][ny] == 1 || vis[nx][ny] == 1) continue;
                        tmpnum++;
                        vis[nx][ny] = 1;
                        q.offer(new int[]{nx, ny});
                        
                        game.add(new int[]{nx, ny});
                        
                    }
                }
                List<int[]> blank = normalize(game);
                for(Integer idx : number.get(tmpnum)){
                    if(used[idx]) continue;
                    
                    List<int[]> shape = li.get(idx);
                    boolean ismatch = false;
                    for(int d=0; d<4; d++){
                        if(same(normalize(shape), blank)){
                            ismatch = true;
                            break;
                        }
                        shape = rotate(shape);
                    }
                    if(ismatch){
                        used[idx] = true;
                        answer += tmpnum;
                        break;
                    }
                }
            }
        }
        
        return answer;
    }
    
    static List<int[]> normalize(List<int[]> t){
        int minnum1 = Integer.MAX_VALUE;
        int minnum2 = Integer.MAX_VALUE;
        for(int[] tmp : t){
            minnum1 = Math.min(tmp[0], minnum1);
            minnum2 = Math.min(tmp[1], minnum2);
        }
        List<int[]> res = new ArrayList<>();
        for(int[] tmp : t){
            res.add(new int[]{tmp[0] - minnum1, tmp[1] - minnum2});
        }
        res.sort((a,b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        return res;
    }
    
    // 90도 회전
    static List<int[]> rotate(List<int[]> cells) {
        List<int[]> res = new ArrayList<>();
        for (int[] c : cells) {
            res.add(new int[]{c[1], -c[0]});
        }
        return res;
    }
 
    // 정규화된 두좌표 목록이 같은지
    static boolean same(List<int[]> a, List<int[]> b) {
        if (a.size() != b.size()) return false;
        
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i)[0] != b.get(i)[0] || a.get(i)[1] != b.get(i)[1]) return false;
        }
        return true;
    }
}