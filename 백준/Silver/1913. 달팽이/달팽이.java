import java.util.Scanner;

public class Main {
    static int N;
    static int target;
    static int[][] result;
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        target = sc.nextInt();
        result = new int[N][N];

        int nr = N/2;  // 중앙에서 시작
        int nc = N/2;  // 중앙에서 시작
        int num = 1;
        result[nr][nc] = num++;  // 1부터

        int dir = 0;  // 이동 방향
        int moveNum = 1;  // 이동할 횟수
        while (true) {
            for (int i=0; i<moveNum; i++) {
                nr = nr + dr[dir];
                nc = nc + dc[dir];

                result[nr][nc]=num++;
                if (nr==0 && nc==0) break;
            }
            if (num>N*N) break;
            dir = (dir+1)%4;  // 방향 전환
            if (dir==0 || dir==2) moveNum++;  // 이동할 횟수 증가
        }

        // 배열 출력
        int targetR = -1;
        int targetC = -1;
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                System.out.print(result[i][j]+" ");
                if (result[i][j]==target) {
                    targetR = i+1;
                    targetC = j+1;
                }
            }
            System.out.println();
        }
        // 좌표 출력
        System.out.println(targetR + " " + targetC);
    }

}
