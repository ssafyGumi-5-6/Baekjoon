import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Fish implements Comparable<Fish> {
	int y;
	int x;
	int size;

	public Fish(int y, int x, int size) {
		super();
		this.y = y;
		this.x = x;
		this.size = size;
	}

	@Override
	public int compareTo(Fish o) {
		if (this.y == o.y)
			return this.x - o.x;
		return this.y - o.y;
	}
}

public class Main_Bj_16236_아기상어 {
	// 상 좌 우 하
	static int[] se = { -1, 0, 0, 1 };
	static int[] ga = { 0, -1, 1, 0 };

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[][] map = new int[N][N];
		Fish shark = null;
		// List<Fish> fishs = new ArrayList<>();
		int fishCnt = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					map[i][j] = 0;
					shark = new Fish(i, j, 2);
				} else if (map[i][j] != 0) {
					// fishs.add(new Fish(i, j, map[i][j]));
					fishCnt++;
				}
			}
		}
		int sec = 0;
		int exp = 0;
		while (true) {
			// for(int i = 0; i < N; i++) {
			// for(int j = 0; j < N; j++) {
			// if(shark.x == j && shark.y == i) {
			// System.out.print("# ");
			// }else System.out.print(map[i][j] + " ");
			// }
			// System.out.println();
			// }
			int tmp = eating(shark, map, N, N);
			// System.out.println(tmp + " " + shark.size + " " + (exp + 1));
			if (tmp == -1) {
				break;
			} else
				sec += tmp;

			exp++;
			if (exp == shark.size) {
				exp = 0;
				shark.size++;
			}
		}

		System.out.println(sec);

	}

	static int eating(Fish shark, int[][] map, int R, int C) {
		int sec = 0;
		Queue<Fish> q = new ArrayDeque<>();
		q.offer(shark);
		boolean[][] visit = new boolean[R][C];
		visit[shark.y][shark.x] = true;
		while (!q.isEmpty()) {
			Queue<Fish> pq = new PriorityQueue<>();
			int secSize = q.size();
			while (secSize-- > 0) {
				Fish f = q.poll();
				if (map[f.y][f.x] != 0 && map[f.y][f.x] < shark.size) {
					pq.add(new Fish(f.y, f.x, 0));
				}
				for (int i = 0; i < 4; i++) {
					int ys = f.y + se[i];
					int xg = f.x + ga[i];
					if (ys < 0 || xg < 0 || ys >= R || xg >= C || visit[ys][xg]
							|| map[ys][xg] > shark.size)
						continue;
					visit[ys][xg] = true;
					q.offer(new Fish(ys, xg, shark.size));
				}
			}
			if (!pq.isEmpty()) {
				Fish f = pq.poll();
				map[f.y][f.x] = 0;
				shark.y = f.y;
				shark.x = f.x;
				return sec;
			}
			sec++;
		}

		return -1;
	}

}
