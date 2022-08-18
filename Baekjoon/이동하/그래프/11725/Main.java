import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
		for (int i = 1; i <= n; i++) graph.put(i, new ArrayList<Integer>());
		boolean [] visit = new boolean [n+1];
		for(int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b); graph.get(b).add(a);
		}
		LinkedList<Integer> queue = new LinkedList<>();
		queue.offer(1);
		visit[1] = true;
		HashMap<Integer, Integer> answer = new HashMap<>();
		while (queue.size() > 0) {
			int temp = queue.poll();
			for (int i : graph.get(temp)) {
				if (visit[i] == false) {
					visit[i] = true;
					queue.offer(i);
					answer.put(i, temp);					
				}
			}
		}
		for (int i = 2; i <= n; i++) {
			System.out.println(answer.get(i));
		}
	}
}