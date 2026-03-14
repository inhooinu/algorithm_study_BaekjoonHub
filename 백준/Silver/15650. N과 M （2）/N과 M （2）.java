import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static int N, M;
    public static int[] result;

    // 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
    // 조합
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        result = new int[M];

        select(0,1);
    }

    private static void select(int cnt, int start) {
        if (cnt==M) {
            for (int i=0; i<result.length; i++) {
                System.out.print(result[i]+" ");
            }
            System.out.println();
            return;
        }

        for (int i=start; i<=N; i++) {
            result[cnt] = i;
            select(cnt+1, i+1);
        }
    }
}
