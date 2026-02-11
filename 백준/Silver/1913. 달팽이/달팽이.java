import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int target = sc.nextInt();
        int[][] arr = new int[N][N];
        int num = N*N;
        int r = 0;
        int c = 0;
        int dir = 0;
        int[] dr = {1,0,-1,0};
        int[] dc = {0,1,0,-1};
        while (num>0) {
            // 아래 -> 오른 -> 위 -> 왼
            arr[r][c] = num--;
            int nr = r + dr[dir];
            int nc = c + dc[dir];
            if (!inRange(nr,nc) || arr[nr][nc]!=0) {
                dir = (dir+1)%4;  // 방향 전환
                r += dr[dir];
                c += dc[dir];
            } else {
                r = nr;
                c = nc;
            }
        }

        int targetR = -1;
        int targetC = -1;
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                System.out.print(arr[i][j]+" ");
                if (arr[i][j]==target) {
                    targetR = i+1;
                    targetC = j+1;
                }
            }
            System.out.println();
        }
        System.out.println(targetR+" "+targetC);
    }

    private static boolean inRange(int r, int c) {
        return r>=0 && r<N && c>=0 && c<N;
    }
}
