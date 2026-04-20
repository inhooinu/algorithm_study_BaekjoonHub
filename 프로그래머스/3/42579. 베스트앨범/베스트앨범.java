import java.util.*;

class Solution {
    
    static class Song {
        int idx;
        int play;
        
        Song(int idx, int play) {
            this.idx=idx; this.play=play;
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        
        Map<String, Integer> genreTotalPlay = new HashMap<>();
        Map<String, List<Song>> genreSongs = new HashMap<>();
        
        for (int i=0; i<genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            
            genreTotalPlay.put(genre, genreTotalPlay.getOrDefault(genre, 0)+play);
            
            genreSongs.putIfAbsent(genre, new ArrayList<>());
            genreSongs.get(genre).add(new Song(i, play));
        }
        
        // 총 재생 수 기준 정렬
        List<String> genreList = new ArrayList<>(genreTotalPlay.keySet());
        genreList.sort((a,b) -> genreTotalPlay.get(b) - genreTotalPlay.get(a));
        
        List<Integer> answerList = new ArrayList<>();
        
        for (String genre: genreList) {
            List<Song> songs = genreSongs.get(genre);
            
            // 장르 내 노래 정렬
            songs.sort((a,b) -> {
                if (b.play != a.play) {
                    return b.play - a.play;  // 재생 수 내림차순
                }
                return a.idx - b.idx;  // 고유번호 오름차순
            });
            
            for (int i=0; i<Math.min(2, songs.size()); i++) {
                answerList.add(songs.get(i).idx);
            }
        }
        
        int[] answer = new int[answerList.size()];
        for (int i=0; i<answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
}