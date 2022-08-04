package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BJ14719 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] arr = new int[c];

        st = new StringTokenizer(br.readLine());

        for(int i =0; i< c; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;

        // 매번 인덱스마다 왼쪽와 오른쪽 중 가장 값을 기준으로 작은 값이 현재 값보다 크다면 길이를 젠다.
        // 반복문을 돌며 매번 현재 위치를 기준으로 한다.
        for(int i = 1; i < c; i++){
            int current = arr[i];
            int leftMaxim = current;
            int rightMaxim = current;
            

            // 왼쪽 오른쪽 중 작은 값이 현재 높이보다 크다면 덧셈 해준다.
            // 왼쪽에서 가장 큰 값을 찾는다.
            for(int j = i - 1; j >=0 ; j--){
                if(leftMaxim < arr[j]) leftMaxim = arr[j];
            }

            // 오른쪽에서 가장 큰 값을 찾는다.
            for(int j = i + 1; j < c ; j++){
                if(rightMaxim < arr[j]) rightMaxim = arr[j];
            }

            if(Math.min(leftMaxim, rightMaxim) > current){
                answer += Math.min(leftMaxim, rightMaxim) - arr[i];
            }
        }
        System.out.println(answer);




        br.close();
    }
}
