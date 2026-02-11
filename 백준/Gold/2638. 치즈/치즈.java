import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] cheese;
    static boolean[][] visited;
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        cheese = new int[N][M];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                cheese[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0;
        while (true) {
            bfs(0,0);  // 녹을 치즈 후보 찾기
            int cnt = melt();
            time++;

            if (cnt==0) break;  // 녹은 치즈가 없으면 중지
        }

        System.out.println(time-1);
    }

    private static int melt() {
        int cnt = 0;
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (cheese[i][j]>2) {  // 녹음
                    cnt++;
                    cheese[i][j] = 0;
                } else if (cheese[i][j]==2) {
                    cheese[i][j] = 1;
                }
            }
        }
        return cnt;
    }

    private static void bfs(int startR, int startC) {
        Queue<int[]> queue = new ArrayDeque<>();
        visited = new boolean[N][M];

        visited[startR][startC] = true;
        queue.offer(new int[] {startR,startC});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];

            for (int dir=0; dir<4; dir++) {
                int nr = r + dr[dir];
                int nc = c + dc[dir];
                if (!inRange(nr,nc)) continue;
                if (visited[nr][nc]) continue;
                if (cheese[nr][nc]!=0) {
                    cheese[nr][nc]+=1;
                    continue;
                };
                if (cheese[nr][nc]==0) {
                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }
    }

    private static boolean inRange(int r, int c) {
        return r>=0 && r<N && c>=0 && c<M;
    }
}
