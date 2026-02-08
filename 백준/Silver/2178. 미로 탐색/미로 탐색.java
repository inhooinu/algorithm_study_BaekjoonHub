import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int[][] map;
    static boolean[][] visited;
    static class Node {
        int r;
        int c;
        int dist;
        Node(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }

    static int[] dr = {1,0,-1,0};
    static int[] dc = {0,1,0,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N+2][M+2];
        visited = new boolean[N+2][M+2];
        for (int i=1; i<=N; i++) {
            String line = br.readLine();
            for (int j=1; j<=M; j++) {
                map[i][j] = line.charAt(j-1)-'0';
            }
        }

        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(1,1, 1));
        visited[1][1] = true;

        int result = 0;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();  // queue에서 꺼내기
            int r = cur.r;
            int c = cur.c;
            int dist = cur.dist;

            if (r==N && c==M) {
                result = dist;
                break;
            }
            for (int dir=0; dir<4; dir++) {
                int nr = r + dr[dir];
                int nc = c + dc[dir];

                if (!inRange(nr, nc)) continue;
                if (map[nr][nc]==0) continue;
                if (visited[nr][nc]) continue;

                visited[nr][nc] = true;
                queue.offer(new Node(nr, nc, dist+1));
            }
        }

        System.out.println(result);
    }

    public static boolean inRange(int r, int c) {
        return r>=0 && r<N+2 && c>=0 && c<M+2;
    }
}
