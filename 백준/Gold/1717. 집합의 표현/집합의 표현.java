import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[] parents;
    static int[] size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        parents = new int[n+1];
        size = new int[n+1];

        makeSet();

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());


            if (command==0) {  // 합집합 연산
                union(a,b);
            } else {  // 같은 집합인지 확인하는 연산
                if (findSet(a)==findSet(b)) System.out.println("YES");
                else System.out.println("NO");
            }
        }
    }

    private static void makeSet() {
        for (int i=1; i<=n; i++) {
            parents[i] = i;
            size[i] = 1;
        }
    }

    private static boolean union(int a, int b) {
        int aRoot = findSet(a);
        int bRoot = findSet(b);

        if (aRoot==bRoot) return false;
        if (size[aRoot] < size[bRoot]) {
            size[bRoot] += size[aRoot];
            parents[aRoot] = bRoot;
        } else {
            size[aRoot] += size[bRoot];
            parents[bRoot] = aRoot;
        }
        return true;
    }

    private static int findSet(int x) {
        if (parents[x]==x) return parents[x];
        return parents[x] = findSet(parents[x]);
    }
}
