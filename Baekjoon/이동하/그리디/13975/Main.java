import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int tc = Integer.parseInt(br.readLine());
		for (int testcase = 1; testcase <= tc; testcase++) {
			long answer = 0;
			int n = Integer.parseInt(br.readLine());
			PriorityQueue<Long> pq = new PriorityQueue<>((o1, o2) -> {return o1.compareTo(o2);});
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < n; i++) pq.offer((long)Integer.parseInt(st.nextToken()));
			while (pq.size() > 1) {
				long temp = pq.poll() + pq.poll();
				pq.offer(temp);
				answer += temp;
			}
			System.out.println(answer);
		}
	}
}