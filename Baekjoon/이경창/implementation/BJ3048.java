package Baekjoon;

import java.util.*;
import java.io.*;

public class BJ3048 {

    private static int swap3(int localA, int localB){
        return localA;
    }

    private static boolean swap2(boolean localA, boolean localB){
        return localA;
    }

    // 이해 되지 않는 문제
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // n1, n2 입력
        int n1 = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(st.nextToken());

        int t;
        int i = 0, j = 0;

        // 개미 입력
        String[] ant = new String[2];
        while(i < 2 ){
            ant[i] = br.readLine();
            i++;
        }

        t = Integer.parseInt(br.readLine());


        // t가 n1 + n2 - 1 이상인 경우 개미의 순서는 똑같기 때문에 t = n1 + n2 - 1
        if(t > n1 + n2){
            t = n1 + n2 - 1;
        }

        // 첫 번째 개미 그룹(ant[0]) 문자열을 reverse
        StringBuilder sb0 = new StringBuilder(ant[0]);

        // 전체 개미 위치를 나타낼 문자배열과 방향을 나타내줄 상태배열
        ant[0] = sb0.reverse().append(ant[1]).toString();
        char[] ants = ant[0].toCharArray();
        boolean[] check = new boolean[n1 + n2];

        // 개미 그룹 1이면 true, 개미 그룹2이면 false
        for(i = 0 ; i< n1;i++)
            check[i] = true;
        for(; i < n1+n2; i++)
            check[i] = false;


        // swap 하는 과정
        while(t-- > 0){
            for(i = 0; i < n1 + n2 - 1 ; i++){
                if(check[i] && !check[i+1]){
                    swap3(ants[i],ants[i+1]);
                    swap2(check[i], check[i+1]);
                    i++;
                }
            }
        }


        for (char c : ants) {
            System.out.print(c);
        }

        br.close();
    }
}
