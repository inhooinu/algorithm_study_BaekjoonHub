import java.util.*;

class Solution {
    
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
    static int n, m;
    
    public int solution(int[][] maps) {
        
        n = maps.length;
        m = maps[0].length;
        return bfs(maps,0,0,1);

    }
    
    public int bfs(int[][] maps, int startR, int startC, int dist) {
        
        ArrayDeque<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];
        
        visited[startR][startC] = true;
        q.offer(new int[] {startR, startC, dist});
        
        while (!q.isEmpty()) {
            
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            int d = cur[2];
            if (r==n-1 && c==m-1) return d;
            
            for (int dir=0; dir<4; dir++) {
                int nr = r + dr[dir];
                int nc = c + dc[dir];
                if (!inRange(nr, nc)) continue;
                if (visited[nr][nc]) continue;
                if (maps[nr][nc]==0) continue;
                visited[nr][nc] = true;
                q.offer(new int[] {nr, nc, d+1});
            }
        }
        
        return -1;
    }
    
    public boolean inRange(int r, int c) {
        return r>=0 && r<n && c>=0 && c<m;
    }
}