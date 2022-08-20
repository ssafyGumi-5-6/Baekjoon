import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		char [] s = br.readLine().toCharArray();
		StringBuilder sbMax = new StringBuilder();
		StringBuilder sbMin = new StringBuilder();
//		System.out.println(Arrays.toString(s));
		int cnt = 0;
		for (char i : s) {
			if(i == 'K') {
//				System.out.println(cnt);
				sbMax.append("5");
				for(int x = 0; x < cnt; x++) sbMax.append("0");
				if(cnt >= 1) {
					sbMin.append("1");
					for(int x = 0; x < cnt-1; x++) sbMin.append("0");
					sbMin.append("5");
				} else {
					sbMin.append("5");
				}
				cnt = 0;
			} else {
				cnt++;
			}
		}
		if (cnt > 0) {
//			System.out.println(cnt);
			for(int x = 0; x < cnt; x++) sbMax.append("1");
			sbMin.append("1");
			for(int x = 0; x < cnt-1; x++) sbMin.append("0");
		}
		System.out.println(sbMax);
		System.out.println(sbMin);
	}
}