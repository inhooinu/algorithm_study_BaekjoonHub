import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

// 수빈이가 동생을 찾을 수 있는 가장 빠른 시간 구하기
public class Main {

    static int N, K;  // 수빈이의 위치, 동생의 위치

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        bfs();
    }

    private static void bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[] visited = new boolean[100001];
        visited[N] = true;
        q.offer(new int[] {N, 0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int location = cur[0];
            int time = cur[1];
            if (location==K) {
                System.out.println(time);
                return;
            }

            int next = location-1;
            if (next>=0 && next<100001 && !visited[next]) {
                visited[next] = true;
                q.offer(new int[] {next, time+1});
            }
            next = location+1;
            if (next>=0 && next<100001 && !visited[next]) {
                visited[next] = true;
                q.offer(new int[] {next, time+1});
            }
            next = location*2;
            if (next>=0 && next<100001 && !visited[next]) {
                visited[next] = true;
                q.offer(new int[] {next, time+1});
            }
        }
    }
}
