import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int tc = Integer.parseInt(br.readLine());
		for (int testcase = 1; testcase <= tc; testcase++) {
			int n = Integer.parseInt(br.readLine());
			int [] [] data = new int [n][2];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				data[i][0] = Integer.parseInt(st.nextToken());
				data[i][1] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(data, (o1, o2) -> {return o1[0] - o2[0];});
			int answer = 1;
			int point = data[0][1];
			for (int i = 1; i < n; i++) {
				if (point > data[i][1]) {
					point = data[i][1];
					answer++;
				}
			}
			System.out.println(answer);
		}
	}
}