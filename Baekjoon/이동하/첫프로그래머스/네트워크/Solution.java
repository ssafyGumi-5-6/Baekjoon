import java.util.Arrays;

class Solution {
	static int [] root;
	
	static int rooting(int k) {
		if (root[k] == k) return k;
		return root[k] = rooting(root[k]);
	}
    static public int solution(int n, int[][] computers) {
    	root = new int [n];
    	for (int i = 0; i < n; i++) root[i] = i;
    	for (int i = 0; i < n-1; i++) {
    		for (int j = i+1; j < n; j++) {
    			if (computers[i][j] == 0) continue;
    			root[rooting(j)] = root[rooting(i)];
    		}
    	}
    	
    	boolean [] helper = new boolean [n];
    	int answer = 0;
    	for (int i : root) {
    		if (helper[rooting(i)] == true) continue;
    		helper[rooting(i)] = true;
    		answer++;
    	}
    	System.out.println(Arrays.toString(root));
    	return answer;
    }
    public static void main(String[] args) {
		int n = 6;
		int [] [] computers = {{1, 0, 1, 1, 0, 0}, {0, 1, 0, 0, 1, 1}, {1, 0, 1, 1, 1, 1}, {1, 0, 1, 1, 1, 1}, {0, 1, 1, 1, 1, 1}, {0, 1, 1, 1, 1, 1}};
		System.out.println(solution(n, computers));
	}
}