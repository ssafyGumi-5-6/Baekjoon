package ws0809;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class Main_Bj_1406_에디터 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		String input = br.readLine();
		List<Character> list = new LinkedList<Character>();
		for(int i = 0; i < input.length(); i++) {
			list.add(input.charAt(i));
		}
		
		int N = Integer.parseInt(br.readLine());
		
		ListIterator<Character> cursor = list.listIterator(list.size());
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			char cmd = st.nextToken().charAt(0);
			switch(cmd) {
			case 'L':
				if(cursor.hasPrevious()) cursor.previous();
				break;
			case 'D':
				if(cursor.hasNext()) cursor.next();
				break;
			case 'B':
				if(cursor.hasPrevious()) {
					cursor.previous();
					cursor.remove();
				}
				break;
			case 'P':
				char tmp = st.nextToken().charAt(0);
				cursor.add(tmp);
				break;
			}
		}
		
		for(char c: list) {
			sb.append(c);
		}
		System.out.println(sb.toString());
	}
}
