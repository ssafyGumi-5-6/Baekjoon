
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_Bj_10799_쇠막대기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
	
		int level = 0;
		int cnt = 0;
		for(int i = 0; i < input.length(); i++) {
			char in = input.charAt(i);
			if(in == '(') {
				level++;
				cnt++;
			}else {
				if(input.charAt(i - 1) == '(') {
					cnt += --level;
					cnt--;
				} else {
					level--;
				}
			}
		}
		System.out.println(cnt);
		
	}

}
