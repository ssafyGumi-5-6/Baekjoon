import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int [] [] map = new int [r][c];
		for(int i = 0; i < r; i++) {
			String temp = br.readLine();
			for(int j = 0; j < c; j++) {
				map[i][j] = temp.charAt(j) - '0';
			}
		}
		int [] dr = {0, 1, 0, -1};
		int [] dc = {1, 0, -1, 0};
		LinkedList<Integer> qr = new LinkedList<>();
		LinkedList<Integer> qc = new LinkedList<>();
		qr.offer(0); qc.offer(0); map[0][0] = -1;
		Loop1:
		while (qr.size() > 0 && qc.size() > 0) {
			int pr = qr.poll();
			int pc = qc.poll();
			for (int i = 0; i < 4; i++) {
				if (pr+dr[i] >= 0 && pr+dr[i] < r && pc+dc[i] >= 0 && pc+dc[i] < c && map[pr+dr[i]][pc+dc[i]] == 1) {
					if (pr+dr[i] == r-1 && pc+dc[i] == c-1) {System.out.println(-(map[pr][pc] - 1)); break Loop1;}
					map[pr+dr[i]][pc+dc[i]] = map[pr][pc] - 1;
					qr.offer(pr+dr[i]); qc.offer(pc+dc[i]);
				}
			}
		}
	}
}