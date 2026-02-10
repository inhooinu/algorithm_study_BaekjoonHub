import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[][] canvas = new int[102][102];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        for (int i=0; i<num; i++) {  // 색종이 붙이기
            st = new StringTokenizer(br.readLine());
            int startR = Integer.parseInt(st.nextToken())+1;
            int startC = Integer.parseInt(st.nextToken())+1;
            for (int r=0; r<10; r++) {
                for (int c=0; c<10; c++) {
                    canvas[startR+r][startC+c] = 1;
                }
            }
        }

        int h = 0;
        int w = 0;
        for (int i=0; i<101; i++) {
            for (int j=0; j<101; j++) {
                if (canvas[i][j]!=canvas[i][j+1]) h++;
                if (canvas[i][j]!=canvas[i+1][j]) w++;
            }
        }
//        System.out.println(h+" "+w);
        System.out.println(h+w);
    }
}
