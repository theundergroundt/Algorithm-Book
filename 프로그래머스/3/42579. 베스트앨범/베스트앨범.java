import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer ;
        
        // 장르별 총 재생수
        Map<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<genres.length; i++){
            map.put(genres[i], map.getOrDefault(genres[i], 0)+plays[i]);
        }
        
        // 장르별 곡 목록(번호, 재생수)
        Map<String, List<int[]>> genresSongs = new HashMap<>();
        for(int i=0; i<genres.length; i++){
            genresSongs.putIfAbsent(genres[i], new ArrayList<>());
            genresSongs.get(genres[i]).add(new int[]{i, plays[i]});
        }
        
        // 총 재생수 내림차순 기준 장르 정렬 
        List<String> genreOrder = new ArrayList<>(map.keySet());
        // 내림차순 정렬
        genreOrder.sort((a, b) -> map.get(b) - map.get(a));
        
        // 각 장르에서 최대 2곡 뽑기
        List<Integer> result = new ArrayList<>();
        for(String s : genreOrder){
            List<int[]> songs = genresSongs.get(s);
            
            songs.sort((a, b) -> b[1] - a[1]);
            
            for(int k=0; k<Math.min(2, songs.size()); k++){
                result.add(songs.get(k)[0]);
            }
        }
        
        answer = new int[result.size()];
        for(int i=0; i<result.size(); i++){
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}