import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N = 19;
    static int[][] arr = new int[N][N];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int c = 0; c < N; c++) {
            for (int r = 0; r < N; r++) {
                if (arr[r][c] == 0) continue;

                int color = arr[r][c];
                boolean win = false;

                // 오른쪽 방향 체크
                boolean ok = true;
                // 시작점 체크: 왼쪽에 같은 돌 있으면 시작점 아님
                if (c - 1 >= 0 && arr[r][c - 1] == color) ok = false;
                // 5개 들어갈 공간 있는지
                if (ok && c + 4 >= N) ok = false;
                // 5개 연속 확인 (c+1 ~ c+4)
                if (ok) {
                    for (int k = 1; k <= 4; k++) {
                        if (arr[r][c + k] != color) {
                            ok = false;
                            break;
                        }
                    }
                }
                // 6목 방지: c+5가 같은 돌이면 탈락
                if (ok && c + 5 < N && arr[r][c + 5] == color) ok = false;
                if (ok) win = true;

                // 아래 방향 체크
                ok = true;
                // 시작점 체크
                if (r - 1 >= 0 && arr[r - 1][c] == color) ok = false;
                // 5개 들어갈 공간 있는지
                if (ok && r + 4 >= N) ok = false;
                // 5개 연속 확인
                if (ok) {
                    for (int k = 1; k <= 4; k++) {
                        if (arr[r + k][c] != color) {
                            ok = false;
                            break;
                        }
                    }
                }
                // 6목 방지
                if (ok && r + 5 < N && arr[r + 5][c] == color) ok = false;
                if (ok) win = true;

                // 오른쪽 아래 방향 체크
                ok = true;
                // 시작점 체크
                if (r - 1 >= 0 && c - 1 >= 0 && arr[r - 1][c - 1] == color) ok = false;
                // 5개 들어갈 공간 있는지
                if (ok && (r + 4 >= N || c + 4 >= N)) ok = false;
                // 5개 연속 확인
                if (ok) {
                    for (int k = 1; k <= 4; k++) {
                        if (arr[r + k][c + k] != color) {
                            ok = false;
                            break;
                        }
                    }
                }
                // 6목 방지
                if (ok && r + 5 < N && c + 5 < N && arr[r + 5][c + 5] == color) ok = false;
                if (ok) win = true;

                // 오른쪽 위 방향 체크
                ok = true;
                // 시작점 체크
                if (r + 1 < N && c - 1 >= 0 && arr[r + 1][c - 1] == color) ok = false;
                // 5개 들어갈 공간 있는지
                if (ok && (r - 4 < 0 || c + 4 >= N)) ok = false;
                // 5개 연속 확인
                if (ok) {
                    for (int k = 1; k <= 4; k++) {
                        if (arr[r - k][c + k] != color) {
                            ok = false;
                            break;
                        }
                    }
                }
                // 6목 방지
                if (ok && r - 5 >= 0 && c + 5 < N && arr[r - 5][c + 5] == color) ok = false;
                if (ok) win = true;

                if (win) {
                    System.out.println(color);
                    System.out.println((r + 1) + " " + (c + 1));
                    return;
                }
            }
        }

        System.out.println(0);
    }
}
