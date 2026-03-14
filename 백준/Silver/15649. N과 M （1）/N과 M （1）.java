import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int N, M;
    static boolean[] visited;
    static int[] result;

    // 1부터 N까지의 자연수 중에서 중복 없이 M개를 고른 수열
    // 순열
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        visited = new boolean[N+1];
        result = new int[M];

        select(0);
    }

    private static void select(int cnt) {
        if (cnt==M) {
            for (int i=0; i<result.length; i++) {
                System.out.print(result[i]+" ");
            }
            System.out.println();
            return;
        }

        for (int i=1; i<=N; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            result[cnt] = i;
            select(cnt+1);
            result[cnt] = 0;
            visited[i] = false;
        }
    }
}
