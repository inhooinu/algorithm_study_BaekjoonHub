import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// 0: 빈 칸, 1: 집, 2: 치킨집
// 도시의 치킨 거리를 최소화 할 수 있는 치킨집 M개 고르기
public class Main {

    static int N, M;
    static int[][] map;
    static List<int[]> locationH;
    static List<int[]> locationC;
    static int[][] dist;  // 집을 기준으로 한 모든 치킨집과의 거리
    static int[] selected;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N+1][N+1];
        locationH = new ArrayList<>();
        locationC = new ArrayList<>();
        selected = new int[M];
        result = 130000;
        for (int i=0; i<N+1; i++) {
            Arrays.fill(map[i], 0);
        }
        for (int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=1; j<=N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j]==1) {
                    locationH.add(new int[] {i,j});
                } else if (map[i][j]==2) {
                    locationC.add(new int[] {i,j});
                }
            }
        }
//        printMap();
        dist = new int[locationH.size()][locationC.size()];
        for (int i=0; i<locationH.size(); i++) {
            for (int j=0; j<locationC.size(); j++) {
                dist[i][j] = calcDist(i,j);
            }
        }

        select(0, 0);
        System.out.println(result);
    }

    private static void select(int cnt, int start) {
        if (cnt==M) {  // 폐업시키지 않을 치킨집을 모두 고르면
//            System.out.println(Arrays.toString(selected));

            // 도시의 치킨 거리 구하기
            int chickenDist = calcChickenDist(selected);

            // 최솟값으로 업데이트
            result = Math.min(result, chickenDist);

            return;
        }

        for (int i=start; i<locationC.size(); i++) {
            selected[cnt] = i;
            select(cnt+1, i+1);
        }
    }

    private static int calcChickenDist(int[] selected) {
        int chickenDist = 0;
        for (int i=0; i<locationH.size(); i++) {
            int d = 10000;  // i번째 집 기준의 치킨 거리
            for (int j=0; j<selected.length; j++) {
                int idxC = selected[j];
                d = Math.min(d, dist[i][idxC]);
            }
            chickenDist += d;
        }

        return chickenDist;
    }

    private static int calcDist(int idxH, int idxC) {
        int x1 = locationH.get(idxH)[0];
        int y1 = locationH.get(idxH)[1];
        int x2 = locationC.get(idxC)[0];
        int y2 = locationC.get(idxC)[1];
        return Math.abs(x1-x2) + Math.abs(y1-y2);
    }

    private static void printMap() {
        for (int i=0; i<N+1; i++) {
            System.out.println(Arrays.toString(map[i]));
        }
        System.out.println();
    }
}
