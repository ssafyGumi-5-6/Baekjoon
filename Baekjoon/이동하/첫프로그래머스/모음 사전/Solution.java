import java.util.HashMap;

class Solution {
    static public int solution(String word) {
    	int [] helper = {781, 156, 31 , 6, 1};
    	char [] data = word.toCharArray();
    	int data_length = data.length;
    	HashMap<Character, Integer> dic = new HashMap<>();
    	dic.put('A', 0); dic.put('E', 1); dic.put('I', 2); dic.put('O', 3); dic.put('U', 4);
    	int answer = 0;
    	for (int i = 0; i < data_length; i++) {
    		answer += 1 + helper[i] * dic.get(data[i]);
    	}
    	return answer;
    }
    public static void main(String[] args) {
		String word = "EIO";
		System.out.println(solution(word));
	}
}