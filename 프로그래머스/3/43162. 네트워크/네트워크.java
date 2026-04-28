import java.util.*;

class Solution {

    static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        
        int answer = 0;
        for (int i=0; i<n; i++) {
            if (!visited[i]) {
                answer++;
                bfs(i, n, computers);
            }
        }
        
        return answer;
    }
    
    public void bfs(int s, int n, int[][] computers) {
        Queue<Integer> q = new ArrayDeque();
        visited[s] = true;
        q.offer(s);
        
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i=0; i<n; i++) {
                if (computers[cur][i]==0) continue;
                if (visited[i]) continue;
                visited[i] = true;
                q.offer(i);
            }
        }
    }
}