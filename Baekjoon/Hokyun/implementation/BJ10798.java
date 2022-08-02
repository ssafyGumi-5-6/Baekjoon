import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ10798 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[][] board = new char[5][];
		String s;

		for (int i = 0; i < 5; i++) {
			s = br.readLine();
			board[i] = s.toCharArray();
		}

		s = "";

		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 5; j++) {
				if (i >= board[j].length || board[j][i] == '\0')
					continue;
				s += board[j][i];
			}
		}
		
		System.out.println(s);
	}

}
