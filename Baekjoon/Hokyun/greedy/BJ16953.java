import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class BJ16953 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		
		System.out.println(bfs(A, B));
		sc.close();
	}
	
	private static int bfs(int A, int B) {
		Queue<Integer> q = new ArrayDeque<Integer>();
		q.offer(A);
		int depth = 1;
		while(!q.isEmpty()) {
			int size = q.size();
			while(--size >= 0) {
				int cur = q.poll();
				if(cur > 500000000) continue;
				int times = cur * 2;
				if(times == B) return depth + 1;
				if(times < B) {
					q.offer(times);
				}
				if(cur > 100000000) continue;
				int appendOne = cur * 10 + 1;
				if(appendOne == B) return depth + 1;
				if(appendOne < B) {
					q.offer(appendOne);
				}
			}
			depth++;
		}
		
		return -1;
	}
}