import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ2884 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] time = br.readLine().split(" ");
		int hour = Integer.parseInt(time[0]);
		int min = Integer.parseInt(time[1]);
		
		if (min - 45 < 0) {
			hour = hour == 0 ? 23 : hour - 1;
			min += 15;
		} else {
			min -= 45;
		}
		
		System.out.println(hour + " " + min);
	}

}
