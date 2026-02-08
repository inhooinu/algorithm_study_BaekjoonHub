import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[][] canvas = new int[100][100];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int num = Integer.parseInt(br.readLine());
        for (int i=0; i<num; i++) {
            st = new StringTokenizer(br.readLine());
            int rStart = Integer.parseInt(st.nextToken());
            int cStart = Integer.parseInt(st.nextToken());
            for (int r=0; r<10; r++) {
                for (int c = 0; c < 10; c++) {
                    canvas[rStart + r][cStart + c] = 1;
                }
            }
        }

        int sum = 0;
        for (int i=0; i<100; i++) {
            for (int j=0; j<100; j++) {
                sum += canvas[i][j];
            }
        }
        System.out.println(sum);
    }
}
