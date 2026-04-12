import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static HashSet<String> strings;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        strings = new HashSet<>();
        for (int i=0; i<N; i++) {
            strings.add(br.readLine());
        }

        int cnt = 0;
        for (int i=0; i<M; i++) {
            String line = br.readLine();
            if (strings.contains(line)) cnt++;
        }

        System.out.println(cnt);
    }
}
