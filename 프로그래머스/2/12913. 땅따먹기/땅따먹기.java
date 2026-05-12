class Solution {
    int solution(int[][] land) {
        int answer = 0;
        
        int n = land.length;
        // 행
        for(int i=1; i<n; i++){
            // 열
            for(int j=0; j<4; j++){
                int maxnum =0;
                for(int k = 0; k<4; k++){
                    if(j == k) continue;
                    maxnum = Math.max(maxnum, land[i-1][k]);
                }
                land[i][j]+=maxnum;
            }         
        }
        for(int i=0; i<4; i++){
            answer = Math.max(land[n-1][i], answer);
        }

        return answer;
    }
}