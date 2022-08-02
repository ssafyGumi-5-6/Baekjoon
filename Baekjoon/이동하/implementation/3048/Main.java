import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] rawData = new String[4];
		for (int i = 0; i < 4; i++) {
			rawData[i] = br.readLine();
		}
		String[] p0 = rawData[0].split(" ");
		int alen = Integer.parseInt(p0[0]);
		int blen = Integer.parseInt(p0[1]);
		char [] aline = rawData[1].toCharArray();
		char [] bline = rawData[2].toCharArray();
		int fidx = Integer.parseInt(rawData[3]);
		
		char [] answer = new char[alen + blen];
		for (int i = 0; i < blen; i++) {
			answer[i + alen - Math.min(Math.max(0,(fidx - i)), alen)] = bline[i];
		}
		for (int i = 0; i < alen; i++) {
			answer[i + (Math.min(Math.max(0,(fidx - (alen - i - 1))), blen))] = aline[alen - i - 1];
		}
		System.out.println(new String(answer));
	}
}
