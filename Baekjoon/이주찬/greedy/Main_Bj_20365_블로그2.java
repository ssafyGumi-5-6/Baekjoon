package st0818;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_Bj_20365_블로그2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		String input = br.readLine();
		
		int cnt = 1;
		char start = input.charAt(0);
		char before = start;
		for(int i = 1; i < N; i++) {
			char temp = input.charAt(i);
			if(temp != before) {
				before = temp;
				if(temp != start) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
		
	}

}
