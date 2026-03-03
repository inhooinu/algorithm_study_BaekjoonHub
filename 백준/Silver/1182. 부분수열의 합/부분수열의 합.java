import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, S;
    static int[] nums;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
//        System.out.println(Arrays.toString(nums));

        for (int size=1; size<=N; size++) {  // 크기가 1~N인 부분수열 구하기
            int[] selected = new int[size];
            combination(0, 0, size, selected);
        }
        System.out.println(cnt);
    }

    private static void combination(int idx, int start, int size, int[] selected) {
        if (idx==size) {
//            System.out.println(Arrays.toString(selected));
            if (S==sum(selected)) cnt++;
            return;
        }

        for (int i=start; i<N; i++) {
            selected[idx] = nums[i];
            combination(idx+1,i+1, size, selected);
        }
    }

    private static int sum(int[] selected) {
        int s = 0;
        for (int n: selected) {
            s+=n;
        }
        return s;
    }
}
