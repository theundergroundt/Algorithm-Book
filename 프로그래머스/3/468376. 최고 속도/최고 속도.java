import java.util.*;
class Solution {
    public int[] solution(int[][] city, int[][] road) {
        
        TreeSet<Integer> xset = new TreeSet<>();
        TreeSet<Integer> yset = new TreeSet<>();
        
        // 도시 넣기
        for(int[] ct : city){
            xset.add(ct[0]);
            yset.add(ct[1]);
        }
        
        // 도로 양끝점, 카메라 넣기
        for(int[] rd : road){
            xset.add(rd[0]);   // 도로 시작 x
            xset.add(rd[2]);   // 도로 끝 x
            yset.add(rd[1]);   // 도로 시작 y
            yset.add(rd[3]);   // 도로 끝 y
            
            // 카메라는 도로 "중앙"에 있음 → (시작+끝)/2
            // 좌표가 ±10억이라 더하면 int 넘침 → long으로 계산
            xset.add((int)(((long)rd[0] + rd[2]) / 2));  // 카메라 x
            yset.add((int)(((long)rd[1] + rd[3]) / 2));  // 카메라 y
        }
        
        // 좌표를 번호로 압축
        int n = xset.size();
        int m = yset.size();
        
        Map<Integer, Integer> x2i = new HashMap<>();
        Map<Integer, Integer> y2i = new HashMap<>();
        
        int xi = 0;
        for(int x : xset) x2i.put(x, xi++);
        int yi = 0;
        for(int y : yset) y2i.put(y, yi++);
        
        // 격자 그래프 만들기
        List<List<Integer>> edges = new ArrayList<>();
        for(int k=0; k<n*m; k++) edges.add(new ArrayList<>());
        
        // 노드번호 - 카메라 제한속도
        Map<Integer, Integer> lim = new HashMap<>();
        
        for(int[] rd : road){
            int x1=rd[0], y1=rd[1], x2=rd[2], y2=rd[3], lm=rd[4];
            
            int xs = x2i.get(x1), xe = x2i.get(x2);  // x 시작번호, 끝번호
            int ys = y2i.get(y1), ye = y2i.get(y2);  // y 시작번호, 끝번호
            
            if(ys == ye){
                // ---- 가로 도로 (y가 같음) ----
                // x번호를 시작~끝까지 한 칸씩 이어줌
                for(int cx = xs; cx < xe; cx++){
                    int a = cx * m + ys;        // 현재 격자점 노드번호
                    int b = (cx+1) * m + ys;    // 오른쪽 옆 격자점
                    edges.get(a).add(b);        // a와 b 연결
                    edges.get(b).add(a);        // 양방향이니 반대도
                }
                // 카메라(도로 중앙) 노드에 제한속도 기록
                int xh = x2i.get((int)(((long)x1 + x2) / 2));  // 카메라 x의 번호
                int node = xh * m + ys;                        // 카메라 노드번호
                // 이미 카메라 있으면 더 낮은 걸로 (여러 카메라 → min)
                lim.put(node, Math.min(lim.getOrDefault(node, 1000000), lm));
            }
            else {
                // ---- 세로 도로 (x가 같음) ----
                for(int cy = ys; cy < ye; cy++){
                    int a = xs * m + cy;        // 현재 격자점
                    int b = xs * m + (cy+1);    // 위쪽 옆 격자점
                    edges.get(a).add(b);
                    edges.get(b).add(a);
                }
                int yh = y2i.get((int)(((long)y1 + y2) / 2));  // 카메라 y의 번호
                int node = xs * m + yh;
                lim.put(node, Math.min(lim.getOrDefault(node, 1000000), lm));
            }
        
        }
        int INF = 1000001;   // "카메라 안 만난 상태" (제한 없음)
        
        // table[node] = 그 노드까지 갈 수 있는 "최고 속도"
        //             = 경로 위 카메라 제한속도들의 최솟값을, 최대로 만든 값
        int[] table = new int[n*m];   // 기본 0 (미방문)
        
        // 시작 노드 = 1번 도시 (city[0])의 격자 위치
        int startNode = x2i.get(city[0][0]) * m + y2i.get(city[0][1]);
        table[startNode] = INF;   // 출발점은 제한 없음
        
        // 최대 힙! (Java 기본은 최소힙 → 비교자 뒤집어 최대힙으로)
        // {속도, 노드} → 속도 큰 것부터 꺼냄
        PriorityQueue<int[]> pq = new PriorityQueue<>((p, q) -> q[0] - p[0]);
        pq.offer(new int[]{INF, startNode});
        
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int sp = cur[0];   // 여기까지 경로의 최소 제한속도 (= 이 경로 최고속도)
            int a = cur[1];    // 현재 노드
            
            // 이미 더 좋은(높은) 값으로 처리됐으면 스킵
            if(sp < table[a]) continue;
            
            for(int na : edges.get(a)){   // 이웃 노드들
                int nsp = sp;
                // 다음 노드에 카메라 있으면 → 경로 최소속도 갱신 (min)
                if(lim.containsKey(na)){
                    nsp = Math.min(nsp, lim.get(na));
                }
                // 더 높은 속도로 그 노드에 도달 가능하면 갱신 (max)
                if(nsp > table[na]){
                    table[na] = nsp;
                    pq.offer(new int[]{nsp, na});
                }
            }
        }
        
        // ===== 5단계: 답 정리 =====
        // 2번 ~ n번 도시 순서대로 table 값 꺼내기
        int[] answer = new int[city.length - 1];
        for(int i=1; i<city.length; i++){
            int node = x2i.get(city[i][0]) * m + y2i.get(city[i][1]);
            int val = table[node];
            // INF 그대로면 카메라 한 번도 안 만남 → 0
            answer[i-1] = (val == INF) ? 0 : val;
        }
        return answer;
    }
}