import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main_Bj_17413_단어뒤집기 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		
		Stack<Character> stack = new Stack<>();
		
		Queue<Character> list = new LinkedList<>();
		
		boolean inversion = true;
		for(int i = 0; i < input.length(); i++) {
			char tmp = input.charAt(i);
			switch(tmp) {
			case '<':
				if(inversion) {
					while(!stack.isEmpty()) {
						list.add(stack.pop());
					}
				}
				inversion = false;
				list.add(tmp);
				break;
			case '>':
				inversion = true;
				list.add(tmp);
				break;
			case ' ':
				if(inversion) {
					while(!stack.isEmpty()) {
						list.add(stack.pop());
					}
				}
				list.add(tmp);
				break;
			default:
				if(inversion) stack.add(tmp);
				else list.add(tmp);
				break;
			}
		}
		if(inversion) {
			while(!stack.isEmpty()) {
				list.add(stack.pop());
			}
		}
		
		
		
		
		StringBuilder sb = new StringBuilder();
		for(Character c : list) {
			sb.append(c);
		}
		System.out.println(sb.toString());
	}

}
