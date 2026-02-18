import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

// 비어있는 곳은 .
// 물이 차있는 지역은 *
// 돌은 X
// 비버의 굴은 D
// 고슴도치의 위치는 S
public class Main {

    static int dr[] = {-1,0,1,0};
    static int dc[] = {0,1,0,-1};
    static int R, C;
    static int targetR, targetC;  // 목표지점
    static char[][] map;
    static boolean[][] visitedW;
    static boolean[][] visitedS;
    static Queue<int[]> water;
    static Queue<int[]> hedgehog;
    static int time;
    static boolean success;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visitedW = new boolean[R][C];
        visitedS = new boolean[R][C];
        water = new ArrayDeque<>();
        hedgehog = new ArrayDeque<>();
        for (int i=0; i<R; i++) {
            String line = br.readLine();
            for (int j=0; j<C; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j]=='*') {
                    visitedW[i][j] = true;
                    water.offer(new int[] {i,j});
                } else if (map[i][j]=='S') {
                    visitedS[i][j] = true;
                    hedgehog.offer(new int[] {i,j});
                    map[i][j] = '.';
                } else if (map[i][j]=='D') {
                    targetR = i;
                    targetC = j;
                }
            }
        }

        while (true) {
            spreadWater();
//            printMap();
            boolean isAvailable = move();
            if (!isAvailable) break;
        }

        if (success) {
            System.out.println(time);
        } else {
            System.out.println("KAKTUS");
        }

    }

    private static boolean move() {
        int s = hedgehog.size();
        boolean isAvailable = false;
        for (int i=0; i<s; i++) {
            int[] cur = hedgehog.poll();
            int r = cur[0];
            int c = cur[1];
            // 도착했으면
            if (r==targetR && c==targetC) {
                success = true;
                return false;
            }

            for (int dir=0; dir<4; dir++) {
                int nr = r + dr[dir];
                int nc = c + dc[dir];
                if (!inRange(nr,nc)) continue;
                if (visitedS[nr][nc]) continue;
                if (map[nr][nc]=='X' || map[nr][nc]=='*') continue;
                isAvailable = true;
                visitedS[nr][nc] = true;
                hedgehog.offer(new int[] {nr,nc});
            }
        }
        time++;
        return isAvailable;
    }

    private static void spreadWater() {
        int s = water.size();
        for (int i=0; i<s; i++) {
            int[] cur = water.poll();
            int r = cur[0];
            int c = cur[1];
            for (int dir=0; dir<4; dir++) {
                int nr = r+dr[dir];
                int nc = c+dc[dir];
                if (!inRange(nr,nc)) continue;
                if (visitedW[nr][nc]) continue;
                if (map[nr][nc]=='X' || map[nr][nc]=='D') continue;
                map[nr][nc] = '*';
                visitedW[nr][nc] = true;
                water.offer(new int[] {nr,nc});
            }
        }
    }

    private static boolean inRange(int r, int c) {
        return r>=0 && r<R && c>=0 && c<C;
    }

    private static void printMap() {
        for (int i=0; i<R; i++) {
            System.out.println(Arrays.toString(map[i]));
        }
        System.out.println();
    }
}
