import java.util.Scanner;

public class Main {

    static int targetR;
    static int targetC;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        targetR = sc.nextInt();
        targetC = sc.nextInt();
        int size = (int) Math.pow(2, N);

        visit(0,0,size,0);
//        for (int i=0; i<size; i++) {
//            for (int j=0; j<size; j++) {
//                System.out.print(arr[i][j]+" ");
//            }
//            System.out.println();
//        }
    }

    private static void visit(int r, int c, int size, int num) {
        if (size==1) {
            System.out.println(num);
            return;
        }
        int half = size/2;
        if (targetR<r+half && targetC<c+half) visit(r,c,half,num);
        if (targetR<r+half && targetC>=c+half) visit(r,c+half,half,num+half*half);
        if (targetR>=r+half && targetC<c+half) visit(r+half,c,half,num+half*half*2);
        if (targetR>=r+half && targetC>=c+half) visit(r+half,c+half,half,num+half*half*3);
    }
}
