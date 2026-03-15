import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int N, M;
    static int[] result;
    static StringBuilder sb;

    // 1부터 N까지의 자연수 중에서 M개를 고른 수열
    // 중복 허용
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        result = new int[M];
        sb = new StringBuilder();

        select(0, 1);
        System.out.println(sb);
    }

    private static void select(int cnt, int start) {
        if (cnt==M) {
            for (int i=0; i<result.length; i++) {
                sb.append(result[i]+" ");
            }
            sb.append("\n");
            return;
        }

        for (int i=start; i<=N; i++) {
            result[cnt] = i;
            select(cnt + 1, i);
        }
    }
}
