import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ21314 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] str = br.readLine().toCharArray();
		int count = 0;
		StringBuilder min = new StringBuilder();
		StringBuilder max = new StringBuilder();
		for(int i = 0, size = str.length; i < size; i++) {
			if (str[i] == 'M') count++;
			else {
				if(count != 0) min.append(1);
				for(int j = 0; j < count - 1; j++)
					min.append(0);
				min.append(5);
				max.append(5);
				for(int j = 0; j < count; j++)
					max.append(0);
				count = 0;
			}
		}
		
		if(count != 0) {
			min.append(1);
			max.append(1);
			for(int i = 0; i < count - 1; i++) {
				min.append(0);
				max.append(1);
			}
		}
		
		System.out.println(max);
		System.out.println(min);
	}
}