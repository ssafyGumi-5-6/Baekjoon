import java.util.ArrayList;

class Solution {
    static public String solution(int[] numbers) {
        ArrayList<Integer> data = new ArrayList<>();
		for (int i = 0; i < numbers.length; i++) data.add(numbers[i]);
		data.sort((o1, o2) -> {
			String oo1 = String.valueOf(o1); String oo2 = String.valueOf(o2);
			return -((oo1+oo1+oo1+oo1).compareTo(oo2+oo2+oo2+oo2));
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
		int [] numbers = {6, 10, 2};
		System.out.println(solution(numbers));
	}
}