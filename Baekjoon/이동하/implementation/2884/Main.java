import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] rawData = br.readLine().split(" ");
		int [] data = new int[2];
		for(int i = 0; i < 2; i++) {
			data[i] = Integer.parseInt(rawData[i]);
		}
		int a;
		int b;
		b = (data[1] + 15) / 60;
		System.out.println(((data[0] + (b-1) + 24) % 24) + " " + (data[1] - 45 + 60 * (-b + 1)));
	}
}