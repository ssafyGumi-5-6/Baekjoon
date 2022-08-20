import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;	
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		double summation = 0;
		double maxnum = -1;
		while (st.hasMoreTokens()) {
			double temp = Double.parseDouble(st.nextToken());
			summation += temp;
			maxnum = Math.max(maxnum, temp);
		}
		System.out.println((summation + maxnum) / 2);
	}
}