import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class SangWatch {
	private int h;
	private int m;
	SangWatch(int h, int m) {
		this.h = h;
		this.m = m;
	}
	void early() {
		m -= 45;
		if(m < 0) {
			h--;
			m = 60 + m;
			if(h < 0) {
				h = 23;
			}
		}
	}
	int getH() {
		return this.h;
	}
	int getM() {
		return this.m;
	}
	
}
public class Main_Bj_2884_알람시계 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		SangWatch sw = new SangWatch(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		
		sw.early();
		
		System.out.println(sw.getH() + " " + sw.getM());
		
	}

}
