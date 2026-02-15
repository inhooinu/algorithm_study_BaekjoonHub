import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static ArrayList<Integer>[] graph;
    static int[] parent;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        graph = new ArrayList[N+1];
        for (int i=1; i<=N; i++) graph[i] = new ArrayList<>();

        for (int i=0; i<N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

//        for (int i=1; i<=N; i++) {
//            System.out.print(i+": ");
//            for (int node: graph[i]) {
//                System.out.print(node+" ");
//            }
//            System.out.println();
//        }

        parent = new int[N+1];
        visited = new boolean[N+1];
        bfs(1);
        StringBuilder sb = new StringBuilder();
        for (int i=2; i<=N; i++) {
            sb.append(parent[i]).append("\n");
        }
        System.out.println(sb);
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        visited[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int node: graph[cur]) {
                if (visited[node]) continue;
                visited[node] = true;
                parent[node] = cur;
                queue.offer(node);
            }
        }
    }
}
