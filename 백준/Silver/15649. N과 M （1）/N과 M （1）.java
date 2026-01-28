import java.util.Scanner;

public class Main {
    static int N;
    static int M;
    static int[] nums;
    static boolean[] visited;
    static int[] result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        nums = new int[N];
        visited = new boolean[N];
        result = new int[M];

        // 1~N 자연수 배열 만들기
        for (int i=0; i<N; i++) {
            nums[i] = i+1;
        }

        // 중복 없이 M개 고르기
        select(0);  // 0번째 위치부터 숫자 선택하기
    }

    public static void select(int idx) {
        if (idx==M) {  // 만약 M개를 모두 선택했으면
//            System.out.println(Arrays.toString(result));
            for (int i=0; i<M; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i=0; i<N; i++) {  // 숫자 후보 탐색
            if (visited[i]) continue;  // 이미 선택을 했으면 중복 선택을 할 수 없으므로 패스
            visited[i] = true;  // 선택한 숫자 표시
            result[idx] = nums[i];  // 선택한 숫자 결과 배열에 넣기
            select(idx+1);  // 다음 위치의 숫자 선택하기
            result[idx] = 0;
            visited[i] = false;
        }
    }
}
