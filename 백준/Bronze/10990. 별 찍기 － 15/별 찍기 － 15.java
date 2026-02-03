import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] arr = new int[N][2*N-1];

        for (int i=0; i<N; i++) {
            arr[i][N-1-i] = 1;
            arr[i][N-1+i] = 1;
        }

        for (int i=0; i<N; i++) {
            for (int j=0; j<N+i; j++) {
                if (arr[i][j]==1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
