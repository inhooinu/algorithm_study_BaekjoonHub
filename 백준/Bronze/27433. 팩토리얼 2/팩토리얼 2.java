import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();

        System.out.println(f(N));
    }

    public static long f(long n) {
        if (n==0) {
            return 1;
        } else {
            return n * f(n-1);
        }
    }

}
