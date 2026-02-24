import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[][] paper;
    static int[] stock;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        paper = new int[10][10];
        stock = new int[] {0,5,5,5,5,5};
        result = Integer.MAX_VALUE;
        for (int i=0; i<10; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<10; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);
        System.out.println(result==Integer.MAX_VALUE? -1: result);
    }

    private static void dfs(int cnt) {
        if (cnt>=result) {  // 사용한 종이가 중간결과보다 큰 경우 가지치기
            return;
        }

        int[] location = findOne();  // 색종이를 붙일 위치 찾기
        int r = location[0];
        int c = location[1];
        if (r==-1 && c==-1) {  // 1이 없는 경우, 즉 1을 모두 덮은 경우
            result = Math.min(result, cnt);
            return;
        }

        for (int size=5; size>0; size--) {  // 선택지 5*5~1*1에 대해 탐색
            if (stock[size]==0) continue;
            if (!isAvailable(r,c,size)) continue;
            attach(r,c,size,0);
            stock[size]--;
//            printMap();
            dfs(cnt+1);
            stock[size]++;
            attach(r,c,size,1);  // 원상복구
        }
    }

    private static void printMap() {
        for (int i=0; i<10; i++) {
            System.out.println(Arrays.toString(paper[i]));
        }
        System.out.println();
    }

    private static void attach(int startR, int startC, int size, int num) {
        for (int i=0; i<size; i++) {
            for (int j=0; j<size; j++) {
                paper[startR+i][startC+j] = num;
            }
        }
    }

    private static boolean isAvailable(int startR, int startC, int size) {
        if (startR+size>10 || startC+size>10) return false;

        int cnt=0;
        for (int i=0; i<size; i++) {
            for (int j=0; j<size; j++) {
                cnt += paper[startR+i][startC+j];
            }
        }
        if (cnt==size*size) return true;
        return false;
    }

    private static int[] findOne() {
        int[] location = new int[] {-1,-1};

        for (int i=0; i<10; i++) {
            for (int j=0; j<10; j++) {
                if (paper[i][j]==1) {
                    location = new int[] {i,j};
                    return location;
                }
            }
        }
        return location;
    }
}
