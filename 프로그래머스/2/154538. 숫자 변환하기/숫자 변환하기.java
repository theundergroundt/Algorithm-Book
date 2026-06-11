import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        if(x == y) return 0;
        
        // bfs 
        Queue<int[]> q = new LinkedList<>();
        // x중복값 관리 
        Set<Integer> vis = new HashSet<>();
        
        q.offer(new int[]{x,0});
        vis.add(x);
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int curx = cur[0];
            int count = cur[1];
            
            int[] arr = {curx+n, curx*2, curx*3};
            
            for(int t : arr){
                if(t == y) return count+1;
                
                if(t < y && vis.contains(t) == false){
                    vis.add(t);
                    q.offer(new int[]{t, count+1});
                }
            }
        }
        return -1;
    }
}