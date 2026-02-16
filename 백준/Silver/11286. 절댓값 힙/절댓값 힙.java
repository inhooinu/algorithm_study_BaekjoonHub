import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 배열에서 절댓값이 가장 작은 값을 출력하고 그 값을 배열에서 제거한다.
        // 절댓값이 가장 작은 값이 여러개일 때는 가장 작은 수를 출력하고 그 값을 배열에서 제거한다.
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (a,b) -> {
                    if (Math.abs(a)==Math.abs(b)) {
                        return a-b;
                    }
                    return Math.abs(a)-Math.abs(b);
                }
        );

        int N = sc.nextInt();
        for (int i=0; i<N; i++) {
            int x = sc.nextInt();
            if (x==0) {
                if (pq.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(pq.poll());
                }
            } else {
                pq.offer(x);
            }
        }
    }
}
