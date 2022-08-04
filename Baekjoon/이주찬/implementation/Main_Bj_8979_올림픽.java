import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_Bj_8979_올림픽 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken()) - 1;
		
		long[] nation = new long[n];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken()) - 1;
			
			for(int j = 0; j < 3; j++) {
				nation[num] += (long)(Integer.parseInt(st.nextToken()) * (10000000000000L / Math.pow(1000000, j)));
			}
		}
		int rank = 1;
		for(int i = 0; i < n; i++) {
			if(nation[i] > nation[m]) rank++;
		}
		
		System.out.println(rank);
	}
}
