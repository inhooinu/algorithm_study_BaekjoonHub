import java.util.Scanner;

public class Main {
    static int N;
    static int M;
    static int[] nums;
    static int[] result;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        // 1부터 N까지 자연수 중에서 M개를 고른 수열
        // 중복 허용

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        nums = new int[N];
        result = new int[M];

        // 1부터 N까지 숫자 배열 만들기
        for (int i=0; i<N; i++) {
            nums[i] = i+1;
        }

        select(0);  // 0번째 위치부터 숫자 채우기
        System.out.print(sb);
    }

    public static void select(int idx) {
        if (idx==M) {
            for (int i=0; i<M; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i=0; i<N; i++) {
            result[idx]=nums[i];
            select(idx+1);
        }
    }
}
