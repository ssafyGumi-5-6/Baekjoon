import java.util.ArrayDeque;

public class Main {
	static int solution(int [] p, int l) {
		ArrayDeque<Integer> dq = new ArrayDeque<>();
		ArrayDeque<Integer> idx = new ArrayDeque<>();
		int answer = 0;
		for (int i = 0; i < p.length; i++) {
			dq.add(p[i]); idx.add(i);
		}
		while (dq.size() > 0) {
			int temp1 = dq.pollFirst();
			int temp2 = idx.pollFirst();
			boolean flag = false;
			for (int i : dq) {
				if (i > temp1) {
					flag = true;
					break;
				}
			}
			if (flag == true) {
				dq.offerLast(temp1);
				idx.offerLast(temp2);
			} else {
				answer++;
				if (temp2 == l) return answer;
			}
		}
		return 0;
	}
	public static void main(String[] args) {
		int [] temp = {1,1,9,1,1,1}; System.out.println(solution(temp, 0));
	}
}
