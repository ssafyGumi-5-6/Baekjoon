import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		List<Integer> data = new ArrayList<>();
		for(int i = 1; i <= n; i++) data.add(i);
		int pointer = k - 1;
		System.out.print("<" + data.remove(pointer));
		while (data.size() > 0) {
			pointer = (pointer + k - 1) % data.size(); 
			System.out.print(", " + data.remove(pointer));
		}
		System.out.println(">");
	}
}