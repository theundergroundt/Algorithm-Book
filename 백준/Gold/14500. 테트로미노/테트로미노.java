import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { // 클래스 이름 변경
	static int n, m, maxnum = 0;
	static int[][] map;
	static boolean[][] visited; // ✨ int[][] 대신 boolean[][] 사용
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visited = new boolean[n][m]; // ✨ boolean으로 변경

		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				// ✨ DFS 시작 방식 변경
				visited[i][j] = true;
				dfs(i, j, 1, map[i][j]);
				visited[i][j] = false; // ✨ 시작점에 대한 탐색이 모두 끝나면 방문 표시 해제
				
				// 'ㅜ' 모양 체크는 그대로 둡니다.
				checkTShape(i, j);
			}
		}
		System.out.println(maxnum);
	}

	// ✨✨✨ 올바른 백트래킹 DFS 로직 ✨✨✨
	public static void dfs(int x, int y, int depth, int sum) {
		// 1. 깊이가 4가 되면 최댓값 갱신 후 종료
		if(depth == 4) {
			maxnum = Math.max(maxnum, sum);
			return;
		}
		
		// 2. 현재 위치에서 상하좌우 탐색
		for(int d=0; d<4; d++) {
			int nx = x+dx[d];
			int ny = y+dy[d];
			
			// 3. 맵을 벗어나거나, 이미 방문한 곳이면 건너뜀
			if(nx<0 || nx>=n || ny<0 || ny>=m || visited[nx][ny]) {
                continue;
            }
			
			// 4. 다음 위치 방문
			visited[nx][ny] = true;
			dfs(nx, ny, depth + 1, sum + map[nx][ny]);
			
			// 5. 다음 위치에 대한 탐색이 모두 끝나면, 다른 경로를 위해 방문 표시 해제
			visited[nx][ny] = false; 
		}
	}

	// 'ㅜ' 모양 체크 로직은 그대로 사용
    public static void checkTShape(int i, int j) {
        int sum = map[i][j];
        int wingCount = 0;
        int minWingValue = 1001;

        for(int d=0; d<4; d++){
            int nx = i + dx[d];
            int ny = j + dy[d];
            if(nx < 0 || nx >= n || ny < 0 || ny >= m) {
                continue;
            }
            wingCount++;
            sum += map[nx][ny];
            minWingValue = Math.min(minWingValue, map[nx][ny]);
        }
        
        if (wingCount == 4) {
            maxnum = Math.max(maxnum, sum - minWingValue);
        } else if (wingCount == 3) {
            maxnum = Math.max(maxnum, sum);
        }
    }
}