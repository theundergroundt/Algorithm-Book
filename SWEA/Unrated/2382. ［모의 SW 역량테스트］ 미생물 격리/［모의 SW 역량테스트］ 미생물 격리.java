import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	public static class Node {
		int x, y, cost, d;

		public Node(int x, int y, int cost, int d) {
			this.x = x;
			this.y = y;
			this.cost = cost;
			this.d = d;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		// 상 하 좌 우 0 1 2 3
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };
		for (int test = 1; test <= t; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 셀의 개수 N, 격리 시간 M, 미생물 군집의 개수 K
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int[][] map = new int[n][n];
			List<Node> li = new ArrayList<>();
			int total = 0;
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int num = Integer.parseInt(st.nextToken());
				int dd = Integer.parseInt(st.nextToken());
				li.add(new Node(a, b, num, dd - 1));
				map[a][b] = num;
				total += num;
			}
			for (int M = 1; M <= m; M++) {
				int idx = 0;
				List<Node>[][] nextMap = new ArrayList[n][n];
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						nextMap[i][j] = new ArrayList<>();
					}
				}
				List<Node> nextli = new ArrayList<>();
				for (Node cur : li) {
					int nx = cur.x + dx[cur.d];
					int ny = cur.y + dy[cur.d];
					// 약품 칠해진 구역
					if (nx == 0 || nx == n - 1 || ny == 0 || ny == n - 1) {
						// 방향 바꾸기
						int tmpdir = 0;
						if (cur.d == 0)
							tmpdir = 1;
						else if (cur.d == 1)
							tmpdir = 0;
						else if (cur.d == 2)
							tmpdir = 3;
						else
							tmpdir = 2;

						nextMap[nx][ny].add(new Node(nx, ny, cur.cost / 2, tmpdir));

						// li.set(idx, new Node(nx, ny, cur.cost/2, tmpdir));
						/*
						 * // 값 옮기기 map[nx][ny] = cur.cost; map[cur.x][cur.y] = 0;
						 */
					} else
						nextMap[nx][ny].add(new Node(nx, ny, cur.cost, cur.d));
				}

				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						if (nextMap[i][j].size() > 0) {
							if (nextMap[i][j].size() == 1) {
								nextli.add(nextMap[i][j].get(0));
							} else {
								int sumcost = 0;
								int nextdir = 0;
								int maxcost = 0;
								for (Node cell : nextMap[i][j]) {
									sumcost += cell.cost;
									if (maxcost < cell.cost) {
										maxcost = cell.cost;
										nextdir = cell.d;
									}
								}
								nextli.add(new Node(i, j, sumcost, nextdir));
							}
						}

					}
				}
				li = nextli;
			}
			// 미생물 수의 총합
			int totalcost = 0;
			for (Node a : li) {
				totalcost += a.cost;
			}
			System.out.println("#" + test + " " + totalcost);
		}
	}
}
