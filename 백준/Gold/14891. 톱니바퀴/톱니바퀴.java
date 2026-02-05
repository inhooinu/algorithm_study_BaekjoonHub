import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] magnet;
    static int K;
    static boolean[] same;
    static int totalScore;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        magnet = new int[4][8];
        for (int i=0; i<4; i++) {
            String line = br.readLine();
            for (int j=0; j<8; j++) {
                magnet[i][j] = line.charAt(j)-'0';
            }
        }
        K = Integer.parseInt(br.readLine());  // 회전 횟수
        totalScore = 0;

        // 회전
        int mNum;  // 회전시킬 톱니바퀴 번호
        int rDir;  // 회전 방향 (1: 시계 방향, -1: 반시계 방향)
        for (int i=0; i<K; i++) {

            st = new StringTokenizer(br.readLine());
            mNum = Integer.parseInt(st.nextToken())-1;
            rDir = Integer.parseInt(st.nextToken());

            same = new boolean[3];
            for (int j=0; j<3; j++) {
                if (magnet[j][2]==magnet[j+1][6]) {
                    same[j] = true;
                }
            }
            rotate(mNum, rDir, 0);

//              for (int j=0; j<4; j++) {
//                  System.out.println(Arrays.toString(magnet[j]));
//              }
        }

        // 점수 계산
        for (int i=0; i<4; i++) {
            totalScore += magnet[i][0]*Math.pow(2, i);
        }
        System.out.println(totalScore);
    }

    // 맨처음만 양방향, 그 다음부터는 왼쪽 또는 오른쪽 자석만 보면서 돌려야함
    // 어느 방향을 볼 것인지 매개변수로
    private static void rotate(int mNum, int rDir, int dir) {

        if (mNum<0 || mNum>=4) return;
        if (dir<0) {  // 왼쪽 자석 보기
            if (mNum>=1 && !same[mNum-1]) rotate(mNum-1, -rDir, dir);
        } else if (dir>0) {  // 오른쪽 자석 보기
            if (mNum<3 && !same[mNum]) rotate(mNum+1, -rDir, dir);
        } else {  // 양쪽 자석 보기
            if (mNum>=1 && !same[mNum-1]) rotate(mNum-1, -rDir, -1);
            if (mNum<3 && !same[mNum]) rotate(mNum+1, -rDir, 1);
        }

        // 현재 자석 돌리기
        if (rDir==1) rotateR(mNum);
        if (rDir==-1) rotateL(mNum);
    }

    private static void rotateR(int mNum) {
        int temp = magnet[mNum][7];
        for (int i=7; i>0; i--) {
            magnet[mNum][i] = magnet[mNum][i-1];
        }
        magnet[mNum][0] = temp;
    }

    private static void rotateL(int mNum) {
        int temp = magnet[mNum][0];
        for (int i=0; i<7; i++) {
            magnet[mNum][i] = magnet[mNum][i+1];
        }
        magnet[mNum][7] = temp;
    }
}