import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] [] query = new String[3][];
		for (int i = 0; i < 3; i++) {
			query[i] = br.readLine().split(" ");
		}
		for (String[] i : query) {
			int sabaki = 0;
			for (int j = 0; j < 4; j++) {
				sabaki += Integer.parseInt(i[j]);
			}
			if (sabaki == 0) {
				System.out.println("D");
			}else if (sabaki == 1) {
				System.out.println("C");
			}else if (sabaki == 2) {
				System.out.println("B");
			}else if (sabaki == 3) {
				System.out.println("A");
			}else if (sabaki == 4) {
				System.out.println("E");
			}
		}
	}
}
