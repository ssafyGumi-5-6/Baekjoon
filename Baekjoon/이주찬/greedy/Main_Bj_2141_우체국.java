package st0818;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Bill implements Comparable<Bill>{
	long x;
	long people;
	public Bill(long x, long people) {
		super();
		this.x = x;
		this.people = people;
	}
	@Override
	public int compareTo(Bill o) {
		return Long.compare(this.x, o.x);
	}
	
}
public class Main_Bj_2141_우체국 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Bill[] pq = new Bill[N];;
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			long X = Integer.parseInt(st.nextToken());
			long A = Integer.parseInt(st.nextToken());
			pq[i] = new Bill(X, A);
		}
		Arrays.sort(pq);
		long res = 0;
		long min = Long.MAX_VALUE;
		for(int i = 0; i < N; i++) {
			long start = pq[i].x;
			long sum = 0;
			for(int j = 0; j < N; j++) {
				sum += Math.abs(pq[j].x - start) * pq[j].people;
			}
			if(sum < min) {
				min = sum;
				res = pq[i].x;
			}
		}
		
		System.out.println(res);
	}
	
}
