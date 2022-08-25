package st0818;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_Bj_21314_민겸수 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		
		StringBuilder max = new StringBuilder();
		StringBuilder min = new StringBuilder();
		int cnt = 0;
		for(int i = 0, size = input.length(); i < size; i++) {
			char temp = input.charAt(i);
			if(temp == 'M') {
				cnt++;
			}else {
				max.append(5);
				for(int q = 0; q < cnt; q++) {
					max.append(0);
				}
				if(cnt > 0) {
					min.append(1);
					for(int q = 0; q < cnt - 1; q++) {
						min.append(0);
					}
					min.append(5);
				}else if(cnt == 0) {
					min.append(5);
				}
				cnt = 0;
				cnt = 0;
			}
		}
		if(input.charAt(input.length() - 1) == 'M') {
			min.append(1);
			for(int q = 0; q < cnt - 1; q++) {
				min.append(0);
			}
			for(int i = 0; i < cnt; i++) {
				max.append(1);
			}
		}
		System.out.println(max.toString());
		System.out.println(min.toString());
	}

}
