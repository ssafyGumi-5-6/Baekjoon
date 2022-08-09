package datastructure;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BJ18258 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Deque<Integer> queue = new ArrayDeque<>();
		
		int numberOfCommand = Integer.parseInt(br.readLine());
		for(int i = 0; i < numberOfCommand; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String command = st.nextToken();
			if (command.equals("push")) {
				queue.add(Integer.parseInt(st.nextToken()));
			} else if(command.equals("pop")) {
				if(!queue.isEmpty())
					sb.append(queue.poll());
				else
					sb.append(-1);
				sb.append("\n");
			} else if(command.equals("size")) {
				sb.append(queue.size());
				sb.append("\n");
			} else if(command.equals("empty")) {
				if(queue.isEmpty())
					sb.append(1);
				else
					sb.append(0);
				sb.append("\n");
			} else if(command.equals("front")) {
				if(queue.isEmpty())
					sb.append(-1);
				else
					sb.append(queue.getFirst());
				sb.append("\n");
			} else if(command.equals("back")) {
				if(queue.isEmpty())
					sb.append(-1);
				else
					sb.append(queue.getLast());
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}

}
