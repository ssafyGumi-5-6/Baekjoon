import java.util.ArrayList;

public class Main {
	static String solution(int[] numbers) {
		ArrayList<Integer> data = new ArrayList<>();
		for (int i = 0; i < numbers.length; i++) data.add(numbers[i]);
		data.sort((o1, o2) -> {
			String oo1 = String.valueOf(o1); String oo2 = String.valueOf(o2);
			return -Integer.compare(Integer.valueOf(oo1 + oo2), Integer.valueOf(oo2 + oo1));
		});
		String answer = "";
		StringBuilder sb = new StringBuilder();
		for (int i : data) {
			sb.append(i);
		}
		answer = sb.toString();
        if (answer.charAt(0) == '0') return "0";
		return answer;

	}
	public static void main(String[] args) {
		int [] temp = {1,1,9,1}; System.out.println(solution(temp));
	}
}
