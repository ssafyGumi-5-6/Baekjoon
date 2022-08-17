package graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ5567 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arraySize = Integer.parseInt(br.readLine());
		int[][] friends = new int[N + 1][N + 1];
		for(int i = 0; i < arraySize; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int row = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());
			friends[row][col] = col;
			friends[col][row] = row;
			
		}
		System.out.println(bfs(N, friends));
	}
	
	public static int bfs(int N, int[][] friends) {
		int count = 0;
		boolean[] isVisited = new boolean[N + 1]; 
		Queue<Integer> queue = new LinkedList<>(); 
		queue.offer(1); 
		isVisited[1] = true;
		int level = 1;
		while(!queue.isEmpty() && level < 3) {
			int size = queue.size();
			while(--size >= 0) { // 큐의 크기 만큼 진행
				int current = queue.poll(); 
				for(int i = 1, iSize = friends[current].length; i < iSize; i++) {
					if(friends[current][i] != 0 && !isVisited[i]) {
						count++;
						queue.offer(i); 
						isVisited[i] = true;
					}
				}				
			}
			level++;	
		}
		
		return count;
	}
}
