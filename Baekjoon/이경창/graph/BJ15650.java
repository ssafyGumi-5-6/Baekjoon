import java.io.*;
import java.util.StringTokenizer;

public class BJ15650 {
	
	static int n, m;
	static int[] input, number;

	public static void comb(int cnt, int start){
		if(cnt == m){
			for(int i =0;i<m;i++){
				System.out.print(number[i] + " ");
			}
			System.out.println();
			return;
		}
		for(int i =start;i<n;i++){
			number[cnt] = input[i];
			comb(cnt+1,i+1);

		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		input = new int[n];
		number = new int[m];
		
		for(int i =0;i<n;i++){
			input[i] = i+1;
		}

		comb(0, 0);
		
		
		br.close();
		
	}
}
