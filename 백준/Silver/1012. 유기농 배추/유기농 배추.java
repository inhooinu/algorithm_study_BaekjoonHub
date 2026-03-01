import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int T;
    static int M, N, K;
    static int map[][];
    static boolean visited[][];
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for (int t=1; t<=T; t++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            map = new int[N][M];
            cnt = 0;
            visited = new boolean[N][M];
            for (int i=0; i<K; i++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                map[Y][X] = 1;
            }
//            printMap();

            for (int i=0; i<N; i++) {
                for (int j=0; j<M; j++) {
                    if (map[i][j]==1 && !visited[i][j]) {
                        cnt++;
                        dfs(i,j);
                    }
                }
            }
            System.out.println(cnt);
        }
    }

    private static void dfs(int startR, int startC) {
        visited[startR][startC] = true;
        for (int dir=0; dir<4; dir++) {
            int nr = startR+dr[dir];
            int nc = startC+dc[dir];
            if (!inRange(nr,nc)) continue;
            if (visited[nr][nc]) continue;
            if (map[nr][nc]==0) continue;
            dfs(nr,nc);
        }
    }

    private static boolean inRange(int r, int c) {
        return r>=0 && r<N && c>=0 && c<M;
    }

    private static void printMap() {
        for (int i=0; i<N; i++) {
            System.out.println(Arrays.toString(map[i]));
        }
        System.out.println();
    }
}
