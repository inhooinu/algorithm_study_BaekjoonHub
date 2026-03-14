import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int N, M;
    static int[] result;
    static StringBuilder sb;

    // 1부터 N까지 자연수 중에서 M개를 고른 수열
    // 중복허용
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        result = new int[M];
        sb = new StringBuilder();

        select(0);
        System.out.println(sb);
    }

    private static void select(int cnt) {
        if (cnt==M) {
            for (int i=0; i<result.length; i++) {
                sb.append(result[i]+" ");
            }
            sb.append("\n");
            return;
        }

        for (int i=1; i<=N; i++) {
            result[cnt]=i;
            select(cnt+1);
        }
    }
}
