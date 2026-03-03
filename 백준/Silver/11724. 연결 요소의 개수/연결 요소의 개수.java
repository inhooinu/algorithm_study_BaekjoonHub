import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N+1];
        visited = new boolean[N+1];
        for (int i=1; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        for (int i=1; i<=N; i++) {  // 모든 정점에 대해
            if (visited[i]) continue;
            bfs(i);
        }
        System.out.println(cnt);
    }

    private static void bfs(int startNode) {
        Queue<Integer> q = new ArrayDeque<>();
        visited[startNode] = true;
        q.offer(startNode);

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next: graph[cur]) {
                if (visited[next]) continue;
                visited[next] = true;
                q.offer(next);
            }
        }
        cnt++;
    }
}
