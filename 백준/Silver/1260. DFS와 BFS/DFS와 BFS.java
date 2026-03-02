import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M, V;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());  // 정점의 개수
        M = Integer.parseInt(st.nextToken());  // 간선의 개수
        V = Integer.parseInt(st.nextToken());  // 탐색을 시작할 정점의 번호
        graph = new ArrayList[N+1];
        visited = new boolean[N+1];
        for (int i=1; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i=1; i<=N; i++) {
            Collections.sort(graph[i]);
        }

        dfs(V);
        System.out.println();
        bfs();
    }

    private static void dfs(int node) {
        visited[node] = true;
        System.out.print(node+" ");
        for (int next: graph[node]) {
            if (visited[next]) continue;
            dfs(next);
        }
    }

    private static void bfs() {
        boolean[] visited = new boolean[N+1];
        Queue<Integer> q = new ArrayDeque<>();
        visited[V] = true;
        q.offer(V);
        while (!q.isEmpty()) {
            int cur = q.poll();
            System.out.print(cur+" ");
            for (int next: graph[cur]) {
                if (visited[next]) continue;
                visited[next] = true;
                q.offer(next);
            }
        }
    }
}
