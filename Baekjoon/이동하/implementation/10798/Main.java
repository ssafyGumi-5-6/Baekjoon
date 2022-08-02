import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] data = new String[5];
		int [] strlen = new int[5];
		int maxlen = 0;
		String answer = "";
		for(int i = 0; i < 5; i++) {
			data[i] = br.readLine();
			strlen[i] = data[i].length();
			if (maxlen < strlen[i]) {
				maxlen = strlen[i];
			}
		}
		for(int i = 0; i < maxlen; i++) {
			for (int j = 0; j < 5; j++) {
				if (i < strlen[j])
					answer += data[j].charAt(i);
			}
		}
		System.out.println(answer);
	}
}
