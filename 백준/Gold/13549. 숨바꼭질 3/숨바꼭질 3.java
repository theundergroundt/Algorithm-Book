import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] dist = new int[100002];
        Arrays.fill(dist, Integer.MAX_VALUE);
        // 1초 후에 X-1 또는 X+1로
        // 순간이동을 하는 경우에는 0초 후에 2*X, 순간이동은 수빈 뒤에 동생이 있을때
        PriorityQueue<int []> pq = new PriorityQueue<>((a, b) -> a[1]-b[1]);
        pq.add(new int[]{n, 0});
        dist[n] = 0;
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            // 최적화
            if(cur[1]>dist[cur[0]]) continue;
            for(int d=0; d<3; d++){
                if(cur[1]>dist[cur[0]]) continue;
                int dx;
                if(d==0) {
                    dx = cur[0]*2;
                    if(dx<0 || dx>100000) continue;
                    if(dist[dx] > cur[1]) {
                        dist[dx] = dist[cur[0]];
                        pq.add(new int[]{dx, dist[dx]});
                    }
                }
                else {
                    if(d==1) dx = cur[0]+1;
                    else dx = cur[0]-1;
                    if(dx<0 || dx>100000) continue;
                    if(dist[dx] > cur[1]+1) {
                        dist[dx] = dist[cur[0]] + 1;
                        pq.add(new int[]{dx, dist[dx]});
                    }

                }

            }
        }
        System.out.println(dist[k]);
    }
}
