import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static boolean [] flag;
	static int n;
	static int m;
	public static void main(String[] args) throws IOException{
		n = Integer.parseInt(br.readLine());
		flag = new boolean[n];
		m = Integer.parseInt(br.readLine());
		HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			if (graph.get(a) == null) {
				ArrayList<Integer> temp = new ArrayList<>();
				graph.put(a, temp);
				temp.add(b);
			} else {
				graph.get(a).add(b);
			}
			if (graph.get(b) == null) {
				ArrayList<Integer> temp = new ArrayList<>();
				graph.put(b, temp);
				temp.add(a);
			} else {
				graph.get(b).add(a);
			}
		}
		int answer = 0;
		flag[0] = true;
		Stack<Integer> stack = new Stack<>();
		stack.add(0);
		while (stack.size() > 0) {
			int popData = stack.pop();
			for(int i : graph.get(popData)) {
				if (flag[i] == false) {
					flag[i] = true;
					answer++;
					stack.push(i);
				}
			}
		}
		System.out.println(answer);
	}
}