import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

// N명의 학생 줄 세우기
public class Main {

    static int N, M;
    static ArrayList<Integer>[] height;
    static int[] indeg;  // 진입차수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        height = new ArrayList[N+1];
        indeg = new int[N+1];
        for (int i=1; i<=N; i++) {
            height[i] = new ArrayList<>();
        }
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            height[A].add(B);
            indeg[B]++;
        }

        topoSort();
    }

    private static void topoSort() {
        Queue<Integer> q = new ArrayDeque<>();
        for (int i=1; i<=N; i++) {
            if (indeg[i]==0) {  // 진입차수가 0인 노드 큐에 삽입
                q.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            int cur = q.poll();
            sb.append(cur).append(" ");

            for (int next: height[cur]) {
                indeg[next]--;
                if (indeg[next]==0) {
                    q.add(next);
                }
            }
        }

        System.out.println(sb);
    }
}
