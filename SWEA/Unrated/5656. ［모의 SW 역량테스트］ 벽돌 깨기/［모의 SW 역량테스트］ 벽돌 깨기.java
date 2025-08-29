import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 벽돌 깨기

public class Solution {
	static class Point {
        int r, c, power;

        public Point(int r, int c, int power) {
            this.r = r;
            this.c = c;
            this.power = power;
        }
    }
	static int n,w,h, minRemain;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        for (int test = 1; test <= T; test++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            int[][] map = new int[h][w];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            minRemain = Integer.MAX_VALUE;
            dropMarble(0, map);
            System.out.println("#"+test+" "+minRemain);
        }
	}
	private static void dropMarble(int count, int[][] map) {
		// 구슬을 n번 쐈을때
		if(count == n) {
			int remaint = countBricks(map);
			minRemain = Math.min(minRemain, remaint);
			return;
		}
		// 남은 벽돌이 0 일면 탐색 종료
		if(countBricks(map) == 0) {
			minRemain = 0;
			return;
		}
		// 모든 열에 구슬 쏘기 -> 중복순열
		for(int c = 0; c<w; c++) {
			// int배열 복사
			int[][] newMap = copyMap(map);
			
			int r = 0;
			while(r<h && newMap[r][c]==0) {
				r++;
			}
			if(r<h) {
				// 벽돌꺠기
				breakbrick(r, c, newMap);
				// 벽돌 내리기
				applyGravity(newMap);
			}
			// 다음 구슬 쏘기 
			dropMarble(count+1, newMap);
		}
	}
	private static void breakbrick(int startr, int startc, int[][]map) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(startr, startc, map[startr][startc]));
		// 돌맞은 벽 제거
		map[startr][startc] = 0;
		while(!q.isEmpty()) {
			Point cur = q.poll();
			for(int p = 1; p<cur.power; p++) {
				for(int d = 0; d<4; d++) {
					int nr = cur.r + dr[d]*p;
					int nc = cur.c + dc[d]*p;
					if(nr >= 0 && nr < h && nc >= 0 && nc < w && map[nr][nc] > 0) {
						q.add(new Point(nr, nc, map[nr][nc]));
						map[nr][nc] = 0;
					}
				}
				
			}
		}
	}
	// 벽돌 내리기
	private static void applyGravity(int[][] map) {
		for(int c = 0; c<w; c++) {
			int emptyrow = h-1;
			for(int r = h-1; r>=0; r--) {
				if(map[r][c]!= 0) {
					int temp = map[r][c];
					map[r][c] = 0;
					map[emptyrow][c] = temp;
					emptyrow--;
				}				
			}
		}
	}	
	// 남은 벽돌 세기
	private static int countBricks(int[][] map) {
		int count=0;
		for(int i=0; i<h; i++) {
			for(int j=0; j<w; j++) {
				if(map[i][j]!=0) count++;
			}
		}
		return count;
	}
	private static int[][] copyMap(int[][] map){
		int[][] newMap = new int[h][w];
		for(int i=0; i<h; i++) {
			System.arraycopy(map[i], 0, newMap[i], 0, w);
		}
		return newMap;
	}
}