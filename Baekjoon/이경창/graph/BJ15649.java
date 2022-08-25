import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ15649 {
	
	static StringBuilder sb;
	static int n, m;
	static int[] input, number;
	static boolean[] visited;
	
	public static void perm(int cnt) {
		if(cnt == m) {
			for(int i =0; i<cnt;i++) {
				sb.append(number[i]).append(' ');
			}
			sb.append('\n');
			
			return;
		}
		
		for(int i=0; i< n;i++) {
			if(!visited[i]) {
				visited[i] = true;
				number[cnt] = input[i];
				perm(cnt+1);
				visited[i] = false;
			}
		}
	}
	
	// 순열을 사용한다.0
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		input = new int[n];
		number = new int[m];
		visited = new boolean[n];
		sb = new StringBuilder();
		
		
		for(int i = 0; i< n; i++) {
			input[i] = i+1;
		}
		
		perm(0);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
