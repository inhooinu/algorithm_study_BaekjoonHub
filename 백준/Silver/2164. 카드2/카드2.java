import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
	
	static int N;
	static ArrayDeque<Integer> cards;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		cards = new ArrayDeque<>();
		
		for (int i=1; i<=N; i++) {
			cards.offer(i);
		}
		
//		System.out.println(cards);
		while(cards.size()>1) {
			cards.pollFirst();
//			System.out.println(cards);
			
			int card = cards.poll();
			cards.offer(card);
//			System.out.println(cards);
		}
		System.out.println(cards.poll());
	}
}
