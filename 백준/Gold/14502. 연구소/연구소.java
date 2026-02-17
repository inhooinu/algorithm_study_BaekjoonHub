import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N,M;
    static int[][] map;
    static int[][] virusMap;
    static List<int[]> list;
    static int result = 0;
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        list = new ArrayList<>();
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j]==2) {
                    list.add(new int[] {i,j});
                }
            }
        }

        setWall(0,0);
        System.out.println(result);
    }

    private static void setWall(int num, int start) {
        if (num==3) {
//            printMap();
            spread();  // 바이러스 확산
//            printVirusMap();
            int size = calculateSize();  // 안전영역의 크기 계산
            result = Math.max(result,size);

            return;
        }
        for (int i=start; i<N*M; i++) {
            int r = i/M;
            int c = i%M;
            if (map[r][c]!=0) continue;
            map[r][c] = 3;
            setWall(num+1, i+1);
            map[r][c] = 0;
        }
    }

    private static int calculateSize() {
        int size = 0;
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (virusMap[i][j]!=2 && map[i][j]==0) size++;
            }
        }
        return size;
    }

    private static void spread() {
        virusMap = new int[N][M];
        for (int i=0; i<list.size(); i++) {
            int[] cur = list.get(i);
            int r = cur[0];
            int c = cur[1];
            bfs(r,c);
        }
    }

    private static void bfs(int startR, int startC) {
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> q = new ArrayDeque<>();
        visited[startR][startC] = true;
        q.offer(new int[] {startR,startC});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            for (int dir=0; dir<4; dir++) {
                int nr = r + dr[dir];
                int nc = c + dc[dir];
                if (!inRange(nr,nc)) continue;
                if (visited[nr][nc]) continue;
                if (map[nr][nc]!=0) continue;
                virusMap[nr][nc] = 2;
                visited[nr][nc] = true;
                q.offer(new int[] {nr,nc});
            }
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
    private static void printVirusMap() {
        for (int i=0; i<N; i++) {
            System.out.println(Arrays.toString(virusMap[i]));
        }
        System.out.println();
    }
}
