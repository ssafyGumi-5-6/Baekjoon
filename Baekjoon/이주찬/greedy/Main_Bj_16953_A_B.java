package st0818;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_Bj_16953_A_B {

	static int res = -1;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long A = Integer.parseInt(st.nextToken());
		long B = Integer.parseInt(st.nextToken());
		
		dfs(A, B, 0);
		
		System.out.println(res);
	}
	
	static void dfs(long A, long B, int n) {
		if(A == B) {
			res = n + 1;
			return;
		}
		if(A > B) {
			return;
		}
		dfs(calc1(A), B, n + 1);
		dfs(calc2(A), B, n + 1);
	}
	
	static long calc1(long A) {
		return A * 2;
	}
	static long calc2(long A) {
		return A * 10 + 1;
	}

}
