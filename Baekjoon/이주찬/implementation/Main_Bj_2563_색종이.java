import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_Bj_2563_색종이 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		boolean[][] pan = new boolean[100][100];
		for(int t = 0; t < n; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			for(int i = y; i < y + 10; i++) {
				for(int j = x; j < x + 10; j++) {
					pan[i][j] = true;
				}
			}
		}
		int cnt = 0;
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				if(pan[i][j]) cnt++;
			}
		}
		System.out.println(cnt);
	}

}
