import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] map = new int[2*N-1][4*N-3];  // 열: n + (2*(n-1)-1) + n

        for (int i=0; i<2*N-1; i++) {
            if (i==0 || i==2*N-2) {
                for (int j=0; j<N; j++) {
                    map[i][j] = 1;
                    map[i][(4*N-3)-j-1] = 1;
                }
            } else {
                int idx = -Math.abs(i-(N-1)) + (N-1);
                map[i][idx] = 1;
                map[i][(4*N-3)-idx-1] = 1;

                idx = idx+(N-1);
                map[i][idx] = 1;
                map[i][(4*N-3)-idx-1] = 1;
            }
        }


        // 별 찍기
//        for (int i=0; i<2*N-1; i++) {
//            System.out.println(Arrays.toString(map[i]));
//        }

        for (int i=0; i<2*N-1; i++) {
            for (int j=0; j<3*N-2+Math.abs(i-(N-1)); j++) {
                if (map[i][j]==1) {
                    sb.append("*");
                } else {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}