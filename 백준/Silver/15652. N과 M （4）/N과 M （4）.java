import java.util.Scanner;

public class Main {

    static int N;
    static int M;
    static int[] nums;
    static int[] result;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        // 1부터 N까지 자연수 중 M개를 고른 수열
        // 같은 수를 여러 번 골라도 됨
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        nums = new int[N];
        result = new int[M];

        for (int i=0; i<N; i++) {
            nums[i] = i+1;
        }

        select(0);  // 0번째 위치의 숫자 고르기
        System.out.println(sb);
    }

    static void select(int idx) {
        if (idx==M) {
            for (int i=0; i<M; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i=0; i<N; i++) {
            if (idx>0 && result[idx-1]>nums[i]) continue;
            result[idx] = nums[i];
            select(idx+1);
        }
    }
}
