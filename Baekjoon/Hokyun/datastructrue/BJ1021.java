import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1021 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		LinkedList<Integer> dequeue = new LinkedList<>();
		for(int i = 1; i <= N; i++) {
			dequeue.add(i);
		}
		Queue<Integer> mqueue = new ArrayDeque<>(N);
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < M; i++) {
			mqueue.add(Integer.parseInt(st.nextToken()));
		}
		
		int count = 0;
		while(!mqueue.isEmpty()) {
			int mFirst = mqueue.peek();
			int findIdx = dequeue.indexOf(mFirst);
			if(Math.abs(findIdx - 0) > Math.abs(findIdx - dequeue.size())) {				
				while(dequeue.peek() != mqueue.peek()) {
					count++;
					dequeue.addFirst(dequeue.removeLast());
				}
			} else {
				while(dequeue.peek() != mqueue.peek()) {
					count++;
					dequeue.addLast(dequeue.removeFirst());
				}
			}
			
			mqueue.poll();
			dequeue.poll();
		}
		
		System.out.println(count);
	}

}
