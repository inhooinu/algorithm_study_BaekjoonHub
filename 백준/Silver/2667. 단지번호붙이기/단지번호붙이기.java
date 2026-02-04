import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    static int N;
    static int map[][];
    static boolean visited[][];
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
    static int cnt;
    static List<Integer> cnts = new ArrayList();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        for (int i=0; i<N; i++) {
            String line = br.readLine();
            for (int j=0; j<N; j++) {
                map[i][j] = line.charAt(j)-'0';
            }
        }
//        // map 출력
//        for (int i=0; i<N; i++) {
//            System.out.println(Arrays.toString(map[i]));
//        }

        int total = 0;
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (map[i][j]==1 && !visited[i][j]) {
                    total++;
                    cnt = 0;
                    dfs(i,j);
                    cnts.add(cnt);
                }
            }
        }
        System.out.println(total);
        Collections.sort(cnts);
        for (int i=0; i<total; i++) {
            System.out.println(cnts.get(i));
        }
    }

    private static void dfs(int r, int c) {
        if (!inRange(r, c)) return;  // 범위를 벗어나면
        if (visited[r][c]) return;  // 이미 방문했으면
        if (map[r][c]==0) return;  // 집이 없는 곳이면

        visited[r][c] = true;
        cnt++;

        for (int dir=0; dir<4; dir++) {
            int nr = r + dr[dir];
            int nc = c + dc[dir];
            dfs(nr, nc);
        }
    }

    private static boolean inRange(int r, int c) {
        return r>=0 && r<N && c>=0 && c<N;
    }
}
