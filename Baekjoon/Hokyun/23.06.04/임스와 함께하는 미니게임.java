import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

class Main {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfMatchRequests = sc.nextInt();
        String matchType = sc.next();
        
        Set<String> userNames = new HashSet<>();
        sc.nextLine();
        for(int i = 1; i <= numberOfMatchRequests; i++) {
            userNames.add(sc.nextLine());
        }
        
        switch (matchType) {
            case "Y":
                System.out.println(userNames.size());
                break;
            case "F":
                System.out.println(userNames.size() / 2);
                break;
            case "O":
                System.out.println(userNames.size() / 3);
                break;
        }
        
        sc.close();
    }
}
