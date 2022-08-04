import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Ant {
	char name;
	int direction;
	Ant(char name, int direction) {
		this.name = name;
		this.direction = direction;
	}
	
	
}

public class Main_Bj_3048_개미 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		Ant[] ant = new Ant[n + m];
		
		String tmpStr = br.readLine();
		for(int i = n - 1, idx = 0; i >= 0; i--) {
			ant[i] = new Ant(tmpStr.charAt(idx++), 1);
		}
		tmpStr = br.readLine();
		for(int i = n, idx = 0; i < n + m; i++) {
			ant[i] = new Ant(tmpStr.charAt(idx++), -1);
		}
		
		int t = Integer.parseInt(br.readLine());
		
		for(int q = 0; q < t; q++) {
			for(int i = 0; i < ant.length - 1; i++) {
				if(ant[i].direction > ant[i + 1].direction) {
					Ant tmp = ant[i];
					ant[i] = ant[i + 1];
					ant[i + 1] = tmp;
					i++;
				}
			}
		}
		Arrays.asList(ant).stream().forEach(a -> System.out.print(a.name));
	}
}
