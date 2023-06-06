import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while(true) {
            int[] sides = new int[3];
            int total = 0;
            int longest = 0;
            int shortest = 1001;
            
            for(int i = 0; i < 3; i++) {
                sides[i] = sc.nextInt();
                total += sides[i];
                longest = Math.max(longest, sides[i]);
                shortest = Math.min(shortest, sides[i]);
            }
            
            if(total == 0)
                break;
            
            if(sides[0] == sides[1] && sides[1] == sides[2]) {
                System.out.println("Equilateral");
                continue;
            }
            
            int middle = total - (longest + shortest);
            
            if(longest >= shortest + middle) {
                System.out.println("Invalid");
                continue;
            }
            
            if(longest == middle || shortest == middle) {
                System.out.println("Isosceles");
            } else {
                System.out.println("Scalene");
            }
            
        }
        sc.close();
    }
}
