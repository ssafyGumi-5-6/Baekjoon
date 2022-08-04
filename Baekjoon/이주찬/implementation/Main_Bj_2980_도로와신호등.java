import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_Bj_2980_도로와신호등 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		
		int[][] sign = new int[n][3];
		for(int i = 0 ; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; j++) {
				sign[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int time = 0;
		int dist = 0;
		Loop1: while(dist < l) {
			for(int i = 0 ; i < n; i++) {
				int f = sign[i][1] + sign[i][2];
				if(dist == sign[i][0] && time % f < sign[i][1]) {
					time++;
					continue Loop1;
				}
			}
			dist++;
			time++;
		}
		
		System.out.println(time);
	}

}
