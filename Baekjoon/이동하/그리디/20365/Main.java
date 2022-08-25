import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		char [] s = br.readLine().toCharArray();
		
		int start = -1;
		int end = n-1;
		char startValue = '\0';
		int answer = 0;
		while (start < end) {
			start++;
			if (startValue != s[start]) {
				answer++;
				startValue= s[start];
				while (s[end] != startValue) {
					end--;
				}
			}
		}
		if (s[0] != s[n-1]) answer++;
		System.out.println(answer);
	}
}