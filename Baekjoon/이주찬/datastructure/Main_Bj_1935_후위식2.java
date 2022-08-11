import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_Bj_1935_후위식2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		String cmd = br.readLine();
		
		char[] cmds = new char[cmd.length()];
		for(int i = 0; i < cmds.length; i++) {
			cmds[i] = cmd.charAt(i);
		}
		
		double[] nums = new double[N];
		for(int i = 0; i < N; i++) {
			nums[i] = Double.valueOf(br.readLine());
		}
		
		Stack<Double> stack = new Stack<>();
		for(int i = 0; i < cmds.length; i++) {
			switch(cmds[i]) {
			case '+':
				stack.push(stack.pop() + stack.pop());
				break;
			case '-':
				double tmp = stack.pop();
				stack.push(stack.pop() - tmp);
				break;
			case '*':
				stack.push(stack.pop() * stack.pop());
				break;
			case '/':
				tmp = stack.pop();
				stack.push(stack.pop() / tmp);
				break;
			default:
				stack.push(nums[cmds[i] - 'A']);
			}
		}
		double result = stack.pop();
		
		System.out.printf("%.2f", result);
		
	}

}
