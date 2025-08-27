import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	static int[] map, arr, vis;
	static int result = Integer.MAX_VALUE, n;
	static List<Integer>[] li;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());		
		arr = new int[n+1];
		vis = new int[n+1];
		li = new ArrayList[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 인구수
		for(int i=1; i<=n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			li[i] = new ArrayList<>();
		}
		map = new int[n+1];
		for(int i=0; i<n; i++) map[i+1] = i+1;
		// 지역 연결
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			for(int j=0; j<num; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				li[i].add(tmp);
			}
		}		
		// 지역 부분집합
		dfs(1);
		if(result == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(result);
		}
			
	}
	public static void dfs(int index) {
		if(index == n + 1) { 
			List<Integer> groupA = new ArrayList<>();
            List<Integer> groupB = new ArrayList<>();
			
			for(int i=1; i<=n; i++) {
				if(vis[i] == 1) { 
					groupA.add(i);
				} else {
					groupB.add(i);
				}
			}
			
			if(groupA.isEmpty() || groupB.isEmpty()) {
				return;
			}
			
			if(iscorrect(groupA) && iscorrect(groupB)){
				int count1 = 0;
				for(int node : groupA) count1 += arr[node];

				int count2 = 0;
				for(int node : groupB) count2 += arr[node];

				result = Math.min(result, Math.abs(count1-count2));
			}
			return;
		}
		vis[index] = 1;
		dfs(index+1);
		vis[index] = 0;
		dfs(index+1);
		
	}
	public static boolean iscorrect(List<Integer> group) {
		if (group.size() <= 1) {
            return true;
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] visitedInGroup = new boolean[n + 1];
        
        int startNode = group.get(0);
        q.add(startNode);
        visitedInGroup[startNode] = true;
        int count = 1;

        while (!q.isEmpty()) {
            int current = q.poll();
            for (int neighbor : li[current]) {
                if (group.contains(neighbor) && !visitedInGroup[neighbor]) {
                    visitedInGroup[neighbor] = true;
                    q.add(neighbor);
                    count++;
                }
            }
        }
        return count == group.size();
	}
	/*
	public static int uni(int a, int b) {
		int fir = fin(a);
		int sec = fin(b);
		if(fir == sec) return 0;
		map[sec] = fir;
		return 1;
	}
	public static int fin(int c) {
		if(map[c] == c) return c;
		return map[c] = fin(map[c]);
	}
	*/
}
