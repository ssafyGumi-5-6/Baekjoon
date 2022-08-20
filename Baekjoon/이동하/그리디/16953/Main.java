import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		LinkedList<Long> queue = new LinkedList<>(); 
		LinkedList<Integer> level = new LinkedList<>(); 
		queue.offer(A);
		level.offer(1);
		
		boolean flag = false;
		while (queue.size() > 0) {
			long p = queue.poll();
			int plv = level.poll();
			if (p == B) {
				flag = true;
				System.out.println(plv);
				break;
			}
			if (p * 2 <= B) {
				queue.offer(p * 2);
				level.offer(plv + 1);
			} 
			if (p * 10 + 1 <= B){
				queue.offer(p * 10 + 1);
				level.offer(plv + 1);
			}
		}
		if (flag == false) {
			System.out.println(-1);
		}
	}
}