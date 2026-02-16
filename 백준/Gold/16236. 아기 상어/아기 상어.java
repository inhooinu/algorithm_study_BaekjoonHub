import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
    static int N;
    static int[][] map;
    static int sr,sc;
    static int size = 2;
    static int eat = 0;
    static int time = 0;

    static class Node {
        int r,c;
        Node(int r, int c) {
            this.r=r; this.c=c;
        }
    }

    static class Target {
        int r,c,dist;
        Target(int r, int c, int dist) {
            this.r=r; this.c=c; this.dist=dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j]==9) {
                    sr = i;
                    sc = j;
                    map[i][j] = 0;  // 상어 위치 빈칸 처리
                }
            }
        }

        while (true) {
            Target t = bfsFindTarget();
            if (t==null) break;  // 더 이상 먹을 수 있는 물고기가 없는 경우

            // 먹을 수 있는 물고기가 있는 경우 이동 후 먹기
            time += t.dist;
            sr = t.r;
            sc = t.c;
            map[sr][sc] = 0;

            eat++;
            if (eat==size) {
                size++;
                eat = 0;
            }
        }
        System.out.println(time);
    }

    private static Target bfsFindTarget() {
        boolean[][] visited = new boolean[N][N];
        Queue<Node> q = new ArrayDeque<>();
        visited[sr][sc] = true;
        q.offer(new Node(sr,sc));

        // 같은 거리에서 발견된 먹이 후보
        PriorityQueue<Node> pq = new PriorityQueue<>(
                (a,b)-> {
                    if (a.r!=b.r) return a.r-b.r;
                    return a.c-b.c;
                }
        );

        int dist = 0;
        while (!q.isEmpty()) {
            int qs = q.size();
            dist++;

            for (int i=0; i<qs; i++) {
                Node cur = q.poll();
                for (int dir=0; dir<4; dir++) {
                    int nr = cur.r + dr[dir];
                    int nc = cur.c + dc[dir];

                    if (!inRange(nr,nc)) continue;
                    if (visited[nr][nc]) continue;
                    if (map[nr][nc]>size) continue;  // 큰 물고기가 있는 경우

                    visited[nr][nc] = true;
                    if (map[nr][nc]>0 && map[nr][nc]<size) {  // 먹이 후보 pq에 넣기
                        pq.offer(new Node(nr,nc));
                    }
                    q.offer(new Node(nr,nc));
                }
            }

            if (!pq.isEmpty()) {  // 먹이 후보가 하나라도 있는 경우
                Node selected = pq.poll();
                return new Target(selected.r,selected.c,dist);
            }
        }
        return null;
    }

    private static boolean inRange(int r, int c) {
        return r>=0 && r<N && c>=0 && c<N;
    }
}
