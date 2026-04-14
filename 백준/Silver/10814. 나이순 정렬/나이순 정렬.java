import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static class Member {
		int age;
		String name;
		
		public Member(int age, String name) {
			this.age=age; this.name=name;
		}
		
		public String toString() {
			return age+" "+name;
		}
	}
	static ArrayList<Member> club;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		club = new ArrayList<>();
		
		// 나이가 증가하는 순, 먼저 가입한 사람 순
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			club.add(new Member(age, name));
		}
		club.sort((a,b)-> a.age-b.age);
		
		for (int i=0; i<N; i++) {
			System.out.println(club.get(i));
		}
	}
}
