import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] paper;
    static int result = 0;
    static int[][][] tetromino23 = {
            {{1,1,1},{1,0,0}}, {{1,1,1},{0,1,0}}, {{1,1,1},{0,0,1}},
            {{1,0,0},{1,1,1}}, {{0,1,0},{1,1,1}}, {{0,0,1},{1,1,1}},
            {{0,1,1},{1,1,0}}, {{1,1,0},{0,1,1}}
    };
    static int[][][] tetromino32 = {
            {{1,1},{1,0},{1,0}}, {{1,0},{1,1},{1,0}}, {{1,0},{1,0},{1,1}},
            {{1,1},{0,1},{0,1}}, {{0,1},{1,1},{0,1}}, {{0,1},{0,1},{1,1}},
            {{1,0},{1,1},{0,1}}, {{0,1},{1,1},{1,0}}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        paper = new int[N][M];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
//        for (int i=0; i<N; i++) {
//            System.out.println(Arrays.toString(paper[i]));
//        }

        // 1*4
        for (int i=0; i<N; i++) {
            for (int j=0; j<M-3; j++) {
                int sum = 0;
                for (int k=0; k<4; k++) {
                    sum += paper[i][j+k];
                }
                result = Math.max(result,sum);
            }
        }

        // 2*3
        for (int i=0; i<N-1; i++) {
            for (int j=0; j<M-2; j++) {
                for (int idx=0; idx<8; idx++) {  // 8가지 경우에 대해
                    int sum = 0;
                    for (int r=0; r<2; r++) {
                        for (int c=0; c<3; c++) {
                            sum += paper[i+r][j+c]*tetromino23[idx][r][c];
                        }
                    }
                    result = Math.max(result,sum);
                }

            }
        }

        // 3*2
        for (int i=0; i<N-2; i++) {
            for (int j=0; j<M-1; j++) {
                for (int idx=0; idx<8; idx++) {
                    int sum = 0;
                    for (int r=0; r<3; r++) {
                        for (int c=0; c<2; c++) {
                            sum += paper[i+r][j+c]*tetromino32[idx][r][c];
                        }
                    }
                    result = Math.max(result,sum);
                }
            }
        }

        // 4*1
        for (int i=0; i<N-3; i++) {
            for (int j=0; j<M; j++) {
                int sum = 0;
                for (int k=0; k<4; k++) {
                    sum += paper[i+k][j];
                }
                result = Math.max(result,sum);
            }
        }

        // 2*2
        for (int i=0; i<N-1; i++) {
            for (int j=0; j<M-1; j++) {
                int sum = 0;
                for (int r=0; r<2; r++) {
                    for (int c=0; c<2; c++) {
                        sum += paper[i+r][j+c];
                    }
                }
                result = Math.max(result,sum);
            }
        }

        System.out.println(result);
    }
}
