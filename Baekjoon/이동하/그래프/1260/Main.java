import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n;
	static int m;
	static int v;
	static ArrayList<Integer>[] graph;
	static boolean [] visit;
	static LinkedList<Integer> queue = new LinkedList<Integer>();
	
	static void dfs(int p) {
		System.out.print(p + " ");
		for (int i : graph[p]) {
			if (visit[i] == false) {
				visit[i] = true;
				dfs(i);
			}
		}
	}
	
	static void bfs() {
		while (queue.size() > 0) {
			int temp = queue.poll();
			System.out.print(temp + " ");
			for(int i : graph[temp]) {
				if (visit[i] == false) {
					visit[i] = true;
					queue.offer(i);
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());
		graph = new ArrayList[n+1];
		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int temp1 = Integer.parseInt(st.nextToken());
			int temp2 = Integer.parseInt(st.nextToken());
			graph[temp1].add(temp2); graph[temp2].add(temp1);
		}
		
		for (int i = 1; i <= n; i++) {
			Collections.sort(graph[i]);
		}
		
		visit = new boolean [n+1];
		visit[v] = true;
		dfs(v);
		
		System.out.println();

		visit = new boolean [n+1];
		visit[v] = true;
		queue.offer(v);
		bfs();
	}
}