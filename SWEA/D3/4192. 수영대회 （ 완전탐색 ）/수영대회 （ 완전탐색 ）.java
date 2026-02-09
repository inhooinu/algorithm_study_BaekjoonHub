import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

// 출발지점에서 도착지점까지 걸리는 시간 구하기
public class Solution {

    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int A, B;
    static int C, D;
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
    static class Node {
        int r;
        int c;
        int time;
        Node(int r, int c, int time) {
            this.r = r;
            this.c = c;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int t=1; t<=T; t++) {

            N = Integer.parseInt(br.readLine());
            map = new int[N+2][N+2];
            visited = new boolean[N+2][N+2];
            for (int i=0; i<N+2; i++) {
                Arrays.fill(map[i], 1);
            }
            for (int i=1; i<=N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j=1; j<=N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            C = Integer.parseInt(st.nextToken());
            D = Integer.parseInt(st.nextToken());

//            System.out.println(A+" "+B+" "+C+" "+D);
//            for (int i=0; i<N+2; i++) {
//                System.out.println(Arrays.toString(map[i]));
//            }

            int result = bfs(A+1, B+1);
            System.out.printf("#%d %d", t, result);
            System.out.println();
        }
    }

    private static int bfs(int r, int c) {
        Queue<Node> queue = new ArrayDeque<>();
        visited[r][c] = true;  // 방문처리
        queue.offer(new Node(r, c, 0));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int curR = node.r;
            int curC = node.c;
            if (curR==(C+1) && curC==(D+1)) {  // 도착
                return node.time;
            }

            for (int dir=0; dir<4; dir++) {
                int nr = curR + dr[dir];
                int nc = curC + dc[dir];
                if (!inRange(nr, nc)) continue;  // 범위를 벗어난 경우
                if (visited[nr][nc]) continue;  // 이미 방문한 경우
                if (map[nr][nc]==1) continue;  // 장애물이 있는 경우
                visited[nr][nc] = true;
                queue.offer(new Node(nr,nc,node.time+1));
            }
        }

        return -1;
    }

    private static boolean inRange(int r, int c) {
        return r>=0 && r<N+2 && c>=0 && c<N+2;
    }
}
