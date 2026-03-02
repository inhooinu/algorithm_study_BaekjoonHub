import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;
    static ArrayList<Integer>[] graph;
    static int[] indeg;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N+1];
        indeg = new int[N+1];
        for (int i=1; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            indeg[b]++;
        }

        topoSort();
    }

    private static void topoSort() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i=1; i<=N; i++) {
            if (indeg[i]==0) {
                pq.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            int cur = pq.poll();
            sb.append(cur).append(" ");
            for (int next: graph[cur]) {
                indeg[next]--;
                if (indeg[next]==0) {
                    pq.add(next);
                }
            }
        }

        System.out.println(sb);
    }
}
