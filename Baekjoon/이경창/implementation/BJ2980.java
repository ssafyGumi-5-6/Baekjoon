package Baekjoon;

import java.util.*;

public class BJ2980 {
    // 현재 시간  + (시간 + 현재 거리 - 이전 거리) % (빨 + 파) < 빨 이면
    // 현재 시간 + (빨 - (시간 + 현재 거리 - 이전 거리) % (빨 + 파))
    // time += (현재거리 - 이전 거리)
    // time % (빨 + 파) <= 빨
    // - time += (빨 - (time) % (빨 + 파);
    // time % (빨 + 파) > 빨 는 패스

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();
        sc.nextLine();
        int[][] arr = new int[n][];
        for(int i = 0 ; i< n;i++){
            String[] s = sc.nextLine().split(" ");
            arr[i] = new int[s.length];
            for(int j = 0; j < s.length;j++) {
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }

        int time = 0, cd = 0;
        for(int i = 0 ; i < n ; i++){
            time += arr[i][0] - cd;
            cd = arr[i][0];
            int v = time % (arr[i][1] + arr[i][2]);
            if(v < arr[i][1]){
                time += arr[i][1] - v;
            }

        }
        time += (l - cd);

        System.out.println(time);

    }
}
