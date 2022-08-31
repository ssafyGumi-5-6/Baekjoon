import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Node {
	int r;
	int c;
	Node(int r, int c) {
		this.r = r;
		this.c = c;
	}
}

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		LinkedList<Integer> [] pan = new LinkedList [n];
		int answer = 0;
		int answercnt = n*m;
		for (int i = 0; i < n; i++) {
			pan[i] = new LinkedList<Integer>();
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				int su = Integer.parseInt(st.nextToken());
				answer += su;
				pan[i].offer(su);
			}
		}
		int [] [] delta = {{0,1},{1,0},{0,-1},{-1,0}};
		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken()) - 1;
			int d = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
//			for (LinkedList pp : pan) System.out.println(pp);
//			System.out.println();
			int xx = x;
			while (true) {
				if (d == 0) {
					for (int kk = 0; kk < k; kk++) pan[xx].offerFirst(pan[xx].pollLast());
				} else {
					for (int kk = 0; kk < k; kk++) pan[xx].offer(pan[xx].poll());
				}
				if ((xx+1) + x+1 > n) break;
				xx += x+1;
			}
//			for (LinkedList<Integer> pp : pan) System.out.println(pp);
//			System.out.println();
			boolean [] [] visit = new boolean [n] [m];
			boolean f = false;
			for (int r = 0; r < n; r++) {
				for (int c = 0; c < m; c++) {
					if (visit[r][c] == true) continue;
					if (pan[r].get(c) == 0) continue;
					visit[r][c] = true;
					int temp = pan[r].get(c);
					LinkedList<Node> q = new LinkedList<>();
					q.offer(new Node(r, c));
					int cc = 0;
					while (q.size() > 0) {
						cc++;
						Node p = q.poll();
						answer -= pan[p.r].get(p.c);
						answercnt--;
//						System.out.println(p.r + " " + p.c);
						pan[p.r].set(p.c, 0);
						for (int [] delt : delta) {
							int next_r = p.r + delt[0];
							int next_c = (p.c + delt[1] + m) % m;
							if (next_r < 0 || next_r >= n) continue;
							if (visit[next_r][next_c] == true) continue;
							if (pan[next_r].get(next_c) != temp) continue;
							visit[next_r][next_c] = true;
							q.offer(new Node(next_r, next_c));
						}
					}
					if (cc == 1) {
						pan[r].set(c, temp);
						answer += temp;
						answercnt++;
					} else {
						f = true;
					}
//					System.out.println();
				}
			}
			if (f == false) {
				int dd = 0;
				for (LinkedList<Integer> pa : pan) {
					for (int j = 0; j < m; j++) {
						if (pa.get(j) == 0) continue;
						if ((double)pa.get(j) < (double)answer/answercnt) {
							pa.set(j, pa.get(j)+1);
							dd++;
						}else if ((double)pa.get(j) > (double)answer/answercnt) {
							pa.set(j, pa.get(j)-1);
							dd--;
						}
					}
				}
				answer += dd;
			}
			
//			for (LinkedList pp : pan) System.out.println(pp);
//			System.out.println(answer + " " + answercnt);
//			System.out.println();
		}
		System.out.println(answer);
	}
}
