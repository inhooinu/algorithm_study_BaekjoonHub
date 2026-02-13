import java.util.Scanner;

// 어떤 자연수 + 어떤 자연수의 각 자리수의 합 = 입력받은 자연수 N
// 이를 만족하는 가장 작은 자연수 구하기
public class Main {

    static int result = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int num=1; num<N; num++) {
            int sum = digitSum(num);
            if ((num+sum)==N) {
                result = num;
                break;
            }
        }
        System.out.println(result);
    }

    // 각 자리수의 합 구하기
    private static int digitSum(int num) {
        int sum = 0;
        while (num>0) {
            sum += num%10;
            num /= 10;
        }
        return sum;
    }
}
