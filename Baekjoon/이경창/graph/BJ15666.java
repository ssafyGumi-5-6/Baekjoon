import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ15666 {

	static int[] number, input;
	static int N, M, inputsize;
	static ArrayList<int[]> list = new ArrayList<>();

	public static void comb(int cnt, int start) {
//		System.out.println("cnt, start " + cnt + " " + start);
		if (cnt == M) {
			int[] arr = Arrays.copyOf(number, M);
			boolean checkresult = false;
			for (int i = 0; i < list.size(); i++) {
				boolean check = false;
				int[] r = list.get(i);

				for (int j = 0; j < M; j++) {
					if (arr[j] != r[j]) {
						check = true;
						break;
					}
				}

				if (!check) {
					checkresult = true;
					break;
				}
			}

			if (!checkresult || list.size() == 0) {
				list.add(arr);
			}

			return;
		}

		for (int i = start; i < inputsize; i++) {

			number[cnt] = input[i];
			comb(cnt + 1, i);

			comb(cnt + 1, i + 1);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);
		input = new int[N];
		number = new int[M];
		int before = arr[0];
		input[0] = before;
		inputsize = 1;
		for (int i = 1; i < N; i++) {
			if (before != arr[i]) {
				input[inputsize++] = arr[i];
				before = arr[i];
			}
		}

		comb(0, 0);
		for (int i = 0; i < list.size(); i++) {
			for(int j =0; j< list.get(i).length; j++) {
				System.out.print(list.get(i)[j] + " ");
			}
			System.out.println();
		}

		br.close();
	}
}
