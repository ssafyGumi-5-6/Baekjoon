package datastructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ11866 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int length = Integer.parseInt(st.nextToken());
		int index = Integer.parseInt(st.nextToken());
		
		Queue<Integer> queue = new ArrayDeque<>();
		for(int i = 1; i <= length; i++) {
			queue.add(i);
		}
		
		sb.append('<');
		while(queue.size() > 1) {
			for(int i = 0; i < index - 1; i++) {
				queue.add(queue.poll());
			}
			
			sb.append(queue.poll() + ", ");
		}
		
		sb.append(queue.poll());
		sb.append('>');
		System.out.println(sb);
	}
}
