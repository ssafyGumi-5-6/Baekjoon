import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Country {
	int name;
	int gold;
	int silver;
	int bronze;
	public Country(int name, int gold, int silver, int bronze) {
		this.name = name;
		this.gold = gold;
		this.silver = silver;
		this.bronze = bronze;
	}
}

public class BJ8979 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int numberOfCountry = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int kGold = 0;
		int kSilver = 0;
		int kBronze = 0;
		int kRank = 1;
		Country[] countries = new Country[numberOfCountry];
		
		for(int i = 0; i < numberOfCountry; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int countryName = Integer.parseInt(st.nextToken());
			// 금메달이 많으면 짱이다.
			int gold = Integer.parseInt(st.nextToken());
			int silver = Integer.parseInt(st.nextToken());
			int bronze = Integer.parseInt(st.nextToken());
			if(countryName == k) {
				kGold = gold;
				kSilver = silver;
				kBronze = bronze;
			}
			countries[i] = new Country(countryName, gold, silver, bronze);
		}
		
		for(int i = 0; i < countries.length; i++) {
			if(countries[i].name == k) continue;
			if(countries[i].gold > kGold) {
				kRank++;
			} else if(countries[i].gold == kGold) {
				if (countries[i].silver > kSilver) {
					kRank++;
				} else if(countries[i].silver == kSilver) {
					if(countries[i].bronze > kBronze) {
						kRank++;
					}
				}
			}
		}
		
		System.out.println(kRank);
	}

}
