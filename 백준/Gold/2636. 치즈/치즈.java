import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};
        int cheesenum = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) {
                    cheesenum++;
                }
            }
        }

        int num = 0;
        int lastcheese = 0;
        while(cheesenum>0){
            Queue<int[]> q = new LinkedList<>();
            int[][] vis = new int[n][m];

            q.add(new int[]{0,0});
            vis[0][0] = 1;
            num++;
            lastcheese = cheesenum;
            while(!q.isEmpty()){
                int[] cur = q.poll();
                for(int d = 0; d<4; d++){
                    int nx = cur[0] + dx[d];
                    int ny = cur[1] + dy[d];
                    if(nx<0 || nx>=n || ny<0 ||ny>=m || vis[nx][ny] == 1) continue;
                    // 1 이면 vis에 0으로 처리하고 continue;
                    if(map[nx][ny] == 1) {
                        // 치즈 녹음
                        cheesenum--;
                        vis[nx][ny] = 1;
                        map[nx][ny] = 0;
                        continue;
                    }
                    vis[nx][ny] = 1;
                    q.add(new int[]{nx,ny});
                }
            }
        }
        System.out.println(num);
        System.out.println(lastcheese);
    }
}