import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int w;
    static int h;
    static int[] location;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        int num = Integer.parseInt(br.readLine());
        location = new int[num+1];
        for (int i=0; i<num+1; i++) {
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            if (dir==1) {  // 북쪽
                location[i] = dist;
            } else if (dir==2) {  // 남쪽
                location[i] = w + h + (w-dist);
            } else if (dir==3) {  // 서쪽
                location[i] = w + h + w + (h - dist);
            } else {  // 동쪽
                location[i] = w + dist;
            }
        }

//        System.out.println(Arrays.toString(location));

        int sum = 0;
        for (int i=0; i<num; i++) {
            int minDist = Integer.MAX_VALUE;
            int d = Math.abs(location[num]-location[i]);
            minDist = Math.min(d, 2*w + 2*h - d);
            sum += minDist;
        }
        System.out.println(sum);
    }
}
