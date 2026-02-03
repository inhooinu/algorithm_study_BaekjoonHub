import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 신맛과 쓴맛의 차이가 가장 작은 요리 만들기
public class Main {

    static int N;
    static int[][] ingredients;

    static boolean[] visited;  // true는 선택한 것, false는 선택하지 않은 것
    static int minDiff = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ingredients = new int[N][2];
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            ingredients[i][0] = Integer.parseInt(st.nextToken());
            ingredients[i][1] = Integer.parseInt(st.nextToken());
        }

//        for (int i=0; i<N; i++) {
//            System.out.println(Arrays.toString(ingredients[i]));
//        }

        visited = new boolean[N];
        subset(0);
        System.out.println(minDiff);
    }

    private static void subset(int depth) {
        if (depth==N) {  // 모든 재료들을 선택하거나 선택하지 않은 것으로 나눔
//            System.out.println(Arrays.toString(visited));
            int sour = 1;  // 신맛은 사용한 재료의 신맛의 곱
            int bitter = 0;  // 쓴맛은 사용한 재료의 쓴맛의 합
            for (int i=0; i<N; i++) {
                if (visited[i]) {  // 선택했으면
                    sour *= ingredients[i][0];
                    bitter += ingredients[i][1];
                }
            }
            if (bitter!=0) {  // 선택한 것이 하나라도 있는 경우
                minDiff = Math.min(minDiff, Math.abs(sour-bitter));
            }

            return;
        }

        visited[depth]=true;
        subset(depth+1);
        visited[depth]=false;
        subset(depth+1);
    }
}