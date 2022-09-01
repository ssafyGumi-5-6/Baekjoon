import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_Bj_14890_경사로 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		int[][] pan = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				pan[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int res = 0;
		for (int i = 0; i < N; i++) {
			boolean posb = true;
			boolean[] tilting = new boolean[N];
			for (int j = 0; j < N - 1; j++) {
				int diff = pan[i][j + 1] - pan[i][j];
				if (Math.abs(diff) > 1) {
					posb = false;
					break;
				}
				if (diff == 1) {
					for (int l = 0; l < L; l++) {
						if (j - l < 0 || tilting[j - l] || !(pan[i][j - l] == pan[i][j])) {
							posb = false;
							break;
						}
						tilting[j - l] = true;
					}
					if (!posb)
						break;
				} else if (diff == -1) {
					for (int l = 1; l <= L; l++) {
						if (j + l >= N || tilting[j + l] || !(pan[i][j + l] == pan[i][j] - 1)) {
							posb = false;
							break;
						}
						tilting[j + l] = true;
					}
					if (!posb)
						break;
				}
			}
			if (posb) {
				// System.out.println("i : " + i);
				res++;
			}
		}

		for (int i = 0; i < N; i++) {
			boolean posb = true;
			boolean[] tilting = new boolean[N];
			for (int j = 0; j < N - 1; j++) {
				int diff = pan[j + 1][i] - pan[j][i];
				if (Math.abs(diff) > 1) {
					posb = false;
					break;
				}
				if (diff == 1) {
					for (int l = 0; l < L; l++) {
						if (j - l < 0 || tilting[j - l] || !(pan[j - l][i] == pan[j][i])) {
							posb = false;
							break;
						}
						tilting[j - l] = true;
					}
					if (!posb)
						break;
				} else if (diff == -1) {
					for (int l = 1; l <= L; l++) {
						if (j + l >= N || tilting[j + l] || !(pan[j + l][i] == pan[j][i] - 1)) {
							posb = false;
							break;
						}
						tilting[j + l] = true;
					}
					if (!posb)
						break;
				}
			}
			if (posb) {
				// System.out.println("j : " + i);
				res++;
			}
		}

		System.out.println(res);
	}
}
