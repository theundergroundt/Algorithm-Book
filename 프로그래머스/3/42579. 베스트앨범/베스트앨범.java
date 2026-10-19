import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer;
        
        // 장르별 총재생수
        Map<String, Integer> genreNum = new HashMap<>();
        for(int i=0; i<genres.length; i++){
            genreNum.put(genres[i], genreNum.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        List<String> genreOrder = new ArrayList<>(genreNum.keySet());
        // 1번 우선순위, 재생수 내림차순
        Collections.sort(genreOrder, (a,b) -> (genreNum.get(b) - genreNum.get(a)));
        
        // 장르별 {번호, 재생수}
        Map<String, List<int[]>> genreSongs = new HashMap<>();
        for(int i=0; i<genres.length; i++){
            genreSongs.putIfAbsent(genres[i], new ArrayList<>());
            genreSongs.get(genres[i]).add(new int[]{i, plays[i]});
        }
        
        List<Integer> result = new ArrayList<>();
        for(String s : genreOrder){
            List<int[]> songs = genreSongs.get(s);
            
            // 2번 우선순위, 많이 재생괸 노래 내림차순
            songs.sort((a,b) -> b[1]-a[1]);
            
            for(int i=0; i<Math.min(2, songs.size()); i++){
                result.add(songs.get(i)[0]);
            }
        }
        
        answer = new int[result.size()];
        for(int i=0; i<result.size(); i++){
            answer[i] = result.get(i);
        }
        
        
        return answer;
    }
}