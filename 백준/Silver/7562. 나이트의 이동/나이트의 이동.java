import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 나이트가 최소 몇 번만에 이동할 수 있는지 구하기
public class Main {

    static int T;
    static int l;
    static int startR, startC;
    static int targetR, targetC;
    static int dist;
    static int[] dr = {-2,-1, 1, 2, 2, 1,-1,-2};
    static int[] dc = { 1, 2, 2, 1,-1,-2,-2,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for (int t=1; t<=T; t++) {
            l = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            startR = Integer.parseInt(st.nextToken());
            startC = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            targetR = Integer.parseInt(st.nextToken());
            targetC = Integer.parseInt(st.nextToken());
            dist = 0;

            bfs();
        }
    }

    private static void bfs() {
        boolean[][] visited = new boolean[l][l];
        Queue<int[]> q = new ArrayDeque<>();

        visited[startR][startC] = true;
        q.offer(new int[] {startR, startC, dist});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            int d = cur[2];

            if (r==targetR && c==targetC) {
                System.out.println(d);
                return;
            }

            for (int dir=0; dir<8; dir++) {
                int nr = r + dr[dir];
                int nc = c + dc[dir];
                if (!inRange(nr,nc)) continue;
                if (visited[nr][nc]) continue;
                visited[nr][nc] = true;
                q.offer(new int[] {nr,nc,d+1});
            }
        }
    }

    private static boolean inRange(int r, int c) {
        return r>=0 && r<l && c>=0 && c<l;
    }
}
