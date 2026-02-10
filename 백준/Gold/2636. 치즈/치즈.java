import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int h, w;
    static int cheese[][];
    static int dr[] = {-1,0,1,0};
    static int dc[] = {0,1,0,-1};
    static boolean visited[][];
    static int time, last;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        cheese = new int[h][w];

        for (int i=0; i<h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<w; j++) {
                cheese[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            bfs(0,0);  // 녹아 없어질 치즈 후보 찾기
//            for (int i=0; i<h; i++) {
//                System.out.println(Arrays.toString(cheese[i]));
//            }
//            System.out.println();

            int melted = melt();
            if (melted>0) {
                time++;
                last = melted;
            } else {
                break;  // 치즈가 모두 녹은 경우 break
            }
        }

        System.out.println(time);
        System.out.println(last);
    }

    private static void bfs(int startR, int startC) {
        Queue<int[]> queue = new ArrayDeque<>();
        visited = new boolean[h][w];

        visited[startR][startC] = true;
        queue.offer(new int[] {startR, startC});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];
            for (int dir=0; dir<4; dir++) {
                int nr = r + dr[dir];
                int nc = c + dc[dir];

                if (!inRange(nr,nc)) continue;
                if (visited[nr][nc]) continue;
                if (cheese[nr][nc]==1) {
                    cheese[nr][nc] = 2;
                    visited[nr][nc] = true;
                    continue;
                }
                visited[nr][nc] = true;
                queue.offer(new int[] {nr, nc});
            }
        }
    }

    private static boolean inRange(int r, int c) {
        return r>=0 && r<h && c>=0 && c<w;
    }

    private static int melt() {
        int cnt=0;
        for (int i=0; i<h; i++) {
            for (int j=0; j<w; j++) {
                if (cheese[i][j]==2) {
                    cheese[i][j] = 0;
                    cnt++;
                }
            }
        }

        return cnt;
    }
}
