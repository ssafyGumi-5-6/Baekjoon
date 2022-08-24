package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2141 {
	
	static class Data implements Comparable<Data>{
		int index, data;
		
		public Data(int index, int data) {
			this.index = index;
			this.data = data;
		}

		@Override
		public int compareTo(Data o) {
			return Integer.compare(this.index, o.index);
		}
		
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int result = 0;
		Data[] dataArray = new Data[N];
		long totalSum = 0;
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int index = Integer.parseInt(st.nextToken());
			int data = Integer.parseInt(st.nextToken());
			
			dataArray[i] = new Data(index, data);
			totalSum += data;
		}
	
		Arrays.sort(dataArray);
		long sum = 0;
		totalSum = totalSum % 2 == 1 ? totalSum / 2 + 1 : totalSum / 2;
		while(sum < totalSum) {
			sum += dataArray[result++].data;
		}
		
		result--;
		System.out.println(dataArray[result].index);
	}

}
