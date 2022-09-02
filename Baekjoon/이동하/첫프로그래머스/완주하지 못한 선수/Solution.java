import java.util.HashMap;

class Solution {
    static public String solution(String[] participant, String[] completion) {
    	HashMap<String, Integer> who = new HashMap<>();
    	for (String p : participant) {
    		if (who.get(p) == null) who.put(p, 0);
    		who.put(p,who.get(p)+1);
    	}
    	for (String c : completion) {
    		who.put(c, who.get(c)-1);
    	}
    	for (String k : who.keySet()) {
    		if (who.get(k) == 1) return k;
    	}
        return "\0";
    }
    public static void main(String[] args) {
    	String [] a = {"leo", "kiki", "eden"};
    	String [] b = {"eden", "kiki"};
		System.out.println(solution(a, b));
	}
}