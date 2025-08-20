import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int test=1; test<=t; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int x=0, y=0;
			char[][] matrix = new char[h][w];
			for(int i=0; i<h; i++) {
				String a = br.readLine();
				for(int j=0; j<w; j++) {
					char c = a.charAt(j);
					matrix[i][j] = c;
					if(c == '>'|| c == '<' || c == '^' || c == 'v') {
						x = i;
						y = j;
					}
				}
			}
			int n = Integer.parseInt(br.readLine());
			String order = br.readLine();
			System.out.print("#"+test+" ");
			for(char c : order.toCharArray()) {
				// shoot
				if(c == 'S') {
					char dir = matrix[x][y];
					int tmpX = x;
					int tmpY = y;
					while(true) {
						if(dir == '>') tmpY++;
						else if(dir == '<') tmpY--;
						else if(dir == '^') tmpX--;
						else if(dir == 'v') tmpX++;
						
						if(tmpX<0 || tmpX>=h || tmpY<0 || tmpY>=w) break;
						char cur = matrix[tmpX][tmpY];
						// 강철
						if(cur == '#') break;
						// 벽돌
						if(cur == '*') {
							matrix[tmpX][tmpY] = '.';
							break;
						}
						
					}					
				}
				else {
					char nextdir = matrix[x][y];
					int nextX = x;
					int nextY = y;
					
					if(c == 'U') {
						nextX--;
						nextdir = '^';
					}else if(c == 'D') {
						nextX++;
						nextdir = 'v';
					}else if(c == 'L') {
						nextY--;
						nextdir = '<';
					}else if(c == 'R') {
						nextY++;
						nextdir = '>';
					}
					
					
					matrix[x][y] = nextdir;
					if(nextX >= 0 && nextX < h && nextY >= 0 && nextY < w && matrix[nextX][nextY] == '.') {
						matrix[nextX][nextY] = matrix[x][y];
                        matrix[x][y] = '.';
						x = nextX;
						y = nextY;
					}
				}				
			}
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					System.out.print(matrix[i][j]);
				}
				System.out.println("");
			}
		}			
	}
}
