package datastructure;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ10828 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		
		int numberOfCommand = Integer.parseInt(br.readLine());
		for(int i = 0; i < numberOfCommand; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String command = st.nextToken();
			if (command.equals("push")) {
				stack.push(Integer.parseInt(st.nextToken()));
			} else if(command.equals("pop")) {
				if(!stack.isEmpty())
					sb.append(stack.pop());
				else
					sb.append(-1);
				sb.append("\n");
			} else if(command.equals("size")) {
				sb.append(stack.size());
				sb.append("\n");
			} else if(command.equals("empty")) {
				if(stack.isEmpty())
					sb.append(1);
				else
					sb.append(0);
				sb.append("\n");
			} else if(command.equals("top")) {
				if(stack.isEmpty())
					sb.append(-1);
				else
					sb.append(stack.peek());
				sb.append("\n");
			}
		}
		System.out.println(sb);

	}

}
