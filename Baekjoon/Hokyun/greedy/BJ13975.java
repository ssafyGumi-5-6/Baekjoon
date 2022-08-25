package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ13975 {
	static int min;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int testCase = 1; testCase <= T; testCase++) {
			int K = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			PriorityQueue<Long> minHeap = new PriorityQueue<>();
			for(int i = 0; i < K; i++) {
				minHeap.add(Long.parseLong(st.nextToken()));
			}
			
			long cost = 0;
			while(minHeap.size() > 1) {
				long a = minHeap.poll();
				long b = minHeap.poll();
				cost += a + b;
				minHeap.add(a + b);
			}
			
			System.out.println(cost);
			
		}
		

	}

}
