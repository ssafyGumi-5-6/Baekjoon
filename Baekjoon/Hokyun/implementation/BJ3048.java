package baekjoon.implement;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Ant {
	char name;
	int moveTime;
	public Ant(char name) {
		this.name = name;
	}
}

class FAnt extends Ant {
	public FAnt(char name, int time) {
		super(name);
		moveTime = time;
	}
	
	public boolean checkNext(Ant ant) {
		if(ant instanceof SAnt && moveTime <= 0) {
			return true;
		}
		return false;
	}
}

class SAnt extends Ant {
	public SAnt(char name) {
		super(name);
	}
}
public class BJ3048 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N1 = Integer.parseInt(st.nextToken());
		int N2 = Integer.parseInt(st.nextToken());
		char[] fAntName = br.readLine().toCharArray();
		char[] sAntName = br.readLine().toCharArray();
		int T = Integer.parseInt(br.readLine());
		Ant[] ants = new Ant[N1 + N2];
		
		for(int i = 0; i < N1 + N2; i++) {
			if(i < N1) {
				ants[i] = new FAnt(fAntName[N1 - 1 - i], N1 - 1 - i);
			} else {
				ants[i] = new SAnt(sAntName[i - N1]);
			}
		}
		
		for(int i = 0; i < T; i++) {
			for(int j = 0; j < N1 + N2 - 1; j++) {
				if(ants[j] instanceof FAnt) {
					FAnt ant = (FAnt)ants[j];
					if(ant.checkNext(ants[j + 1])) {
						Ant temp = ants[j];
						ants[j] = ants[j + 1];
						ants[j+ 1] = temp;
						j++;
					}
					ants[j].moveTime--;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(Ant a : ants) {
			sb.append(a.name);
		}
		System.out.println(sb);
	}

}
