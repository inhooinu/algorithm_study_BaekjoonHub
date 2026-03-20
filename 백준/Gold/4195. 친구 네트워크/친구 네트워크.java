import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	
	static int T;
	static int F;
	static int[] parents;
	static int[] size;
	static Map<String, Integer> map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		for (int t=1; t<=T; t++) {
			
			F = Integer.parseInt(br.readLine());
			parents = new int[F*2];
			size = new int[F*2];
			
			makeSet();
			map = new HashMap<>();
			int index = 0;
			
			for (int i=0; i<F; i++) {  // 입력으로 들어오는 친구 관계에 대해
				st = new StringTokenizer(br.readLine());
				String name1 = st.nextToken();
				String name2 = st.nextToken();
				
				// 이름:인덱스 사전 구축
				if (!map.containsKey(name1)) {
					map.put(name1, index++);
				}
				if (!map.containsKey(name2)) {
					map.put(name2, index++);
				}
				
				// 친구 이름으로 인덱스 가져오기
				int a = map.get(name1);
				int b = map.get(name2);
				
				union(a,b);
				System.out.println(size[findSet(a)]);
			}
			
		}
	}

	private static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if (aRoot==bRoot) return false;
		if (size[aRoot]<size[bRoot]) {
			size[bRoot]+=size[aRoot];
			parents[aRoot] = bRoot;
		} else {
			size[aRoot]+=size[bRoot];
			parents[bRoot] = aRoot;
		}
		return true;
	}

	private static int findSet(int x) {
		if (x==parents[x]) return parents[x];
		return parents[x] = findSet(parents[x]);
	}

	private static void makeSet() {
		for (int i=0; i<F*2; i++) {
			parents[i] = i;
			size[i] = 1;
		}
	}
	
}
