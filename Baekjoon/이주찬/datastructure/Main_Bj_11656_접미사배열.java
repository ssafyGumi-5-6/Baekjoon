import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main_Bj_11656_접미사배열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String input = sc.nextLine();
		
		int n = input.length();
		
		List<String> res = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			res.add(input.substring(i));
		}
		
		Collections.sort(res);
		
		for(String s : res) {
			System.out.println(s);
		}
		sc.close();
	}
}
