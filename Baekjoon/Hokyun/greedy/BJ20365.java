package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ20365 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		StringTokenizer blue = new StringTokenizer(str, "B");
		StringTokenizer red = new StringTokenizer(str, "R");
		int blueCount = blue.countTokens();
		int redCount = red.countTokens();
		if(blueCount < redCount) {
			System.out.println((blueCount + 1));
		} else {
			System.out.println((redCount + 1));
		}
	}
}
