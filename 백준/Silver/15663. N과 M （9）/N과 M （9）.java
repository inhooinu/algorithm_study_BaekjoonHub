import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// N개의 자연수 중에서 M개를 고른 수열
public class Main {

    static int N;
    static int M;
    static int[] nums;
    static boolean[] visited;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[N];
        visited = new boolean[N];
        result = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);
//        System.out.println(Arrays.toString(nums));
        select(0);
    }

    private static void select(int idx) {
        if (idx==M) {
            for (int i=0; i<M; i++) {
                System.out.print(result[i]+" ");
            }
            System.out.println();
            return;
        }

        int prev = -1;
        for (int i=0; i<N; i++) {
            if (visited[i]) continue;
            if (nums[i]==prev) continue;

            visited[i] = true;
            result[idx] = nums[i];
            prev = nums[i];
            select(idx+1);
            result[idx] = 0;
            visited[i] = false;
        }
    }
}
