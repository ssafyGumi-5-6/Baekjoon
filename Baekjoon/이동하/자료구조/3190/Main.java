import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int [] [] map = new int [n] [n];
		int [] [] dd = new int [n] [n];
		int [] head = {0,0};
		int [] tail = {0,0};
		int len = 1;
		map[0][0] = 2;
		int k = Integer.parseInt(br.readLine());
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			map[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = 1;
		}
		int time = 0;
		int[][] d = {{-1,0}, {0,1}, {1,0}, {0,-1}};
		int last = 1;
		
		boolean answerflag = false;
		int l = Integer.parseInt(br.readLine());
		Loop1:
		for (int i = 0; i < l; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int looptime = Integer.parseInt(st.nextToken());
			for (int j = time; j < looptime; j++) {
				if (head[0] + d[last][0] >= 0 && head[0] + d[last][0] < n && head[1] + d[last][1] >= 0 && head[1] + d[last][1] < n &&
					     map[head[0] + d[last][0]][head[1] + d[last][1]] != 2) {
					dd[head[0]][head[1]] = last;
					head[0] += d[last][0]; head[1] += d[last][1];
					boolean isApple = false;
					if (map[head[0]][head[1]] == 1) isApple = true;
					map[head[0]][head[1]] = 2;
					if (isApple == false) {
						map[tail[0]][tail[1]] = 0;
						int temp1 = d[dd[tail[0]][tail[1]]][0]; int temp2 = d[dd[tail[0]][tail[1]]][1];
						tail[0] += temp1;
						tail[1] += temp2;
					}
				}else {
					answerflag = true;
					System.out.println(j+1);
					break Loop1;
				}
			}
			char turnd = st.nextToken().charAt(0);
			if (turnd == 'L') last += 3; last %= 4;
			if (turnd == 'D') last += 1; last %= 4;
			time = looptime;
		}
		if (answerflag == false) {
			while (true) {
				if (head[0] + d[last][0] >= 0 && head[0] + d[last][0] < n && head[1] + d[last][1] >= 0 && head[1] + d[last][1] < n &&
					     map[head[0] + d[last][0]][head[1] + d[last][1]] != 2) {
					dd[head[0]][head[1]] = last;
					head[0] += d[last][0]; head[1] += d[last][1];
					boolean isApple = false;
					if (map[head[0]][head[1]] == 1) isApple = true;
					map[head[0]][head[1]] = 2;
					if (isApple == false) {
						map[tail[0]][tail[1]] = 0;
						int temp1 = d[dd[tail[0]][tail[1]]][0]; int temp2 = d[dd[tail[0]][tail[1]]][1];
						tail[0] += temp1;
						tail[1] += temp2;
					}
					time++;
				} else {
					break;
				}
				
			}
			System.out.println(time+1);
		}
	}
}