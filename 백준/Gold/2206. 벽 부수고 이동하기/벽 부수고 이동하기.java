import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] map;
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
    static class Node {
        int r,c,broken;
        Node(int r, int c, int broken) {
            this.r=r; this.c=c; this.broken=broken;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i=0; i<N; i++) {
            String line = br.readLine();
            for (int j=0; j<M; j++) {
                map[i][j] = line.charAt(j)-'0';
            }
        }
        System.out.println(bfs());
    }

    private static int bfs() {
        // dist[r][c][0]: 벽을 부수지 않고 도착한 최단거리
        // dist[r][c][1]: 벽을 한 번 부수고 도착한 최단거리
        int[][][] dist = new int[N][M][2];
        Queue<Node> q = new ArrayDeque<>();
        dist[0][0][0] = 1;
        q.offer(new Node(0,0,0));

        while (!q.isEmpty()) {
            Node cur = q.poll();
            int r = cur.r;
            int c = cur.c;
            int b = cur.broken;

            if (r==N-1 && c==M-1) return dist[r][c][b];  // 도착
            for (int dir=0; dir<4; dir++) {
                int nr = r + dr[dir];
                int nc = c + dc[dir];
                if (!inRange(nr,nc)) continue;

                if (map[nr][nc]==0) {
                    if (dist[nr][nc][b]==0) {  // 방문한 적이 없는 경우
                        dist[nr][nc][b] = dist[r][c][b] + 1;
                        q.offer(new Node(nr,nc,b));
                    }
                } else {
                    if (b==0 && dist[nr][nc][1]==0) {  // 벽을 부순 적이 없고 아직 방문하지 않은 경우
                        dist[nr][nc][1] = dist[r][c][0] + 1;  // 벽 부수고 이동
                        q.offer(new Node(nr,nc,1));
                    }
                }
            }
        }
        return -1;
    }

    private static boolean inRange(int r, int c) {
        return r>=0 && r<N && c>=0 && c<M;
    }
}