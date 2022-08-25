import java.io.InputStreamReader;

import java.io.*;
import java.util.*;

public class BJ1931 {


    public static int[] swap(int[] a, int[] b) {
        return a;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }



        // 도착시간, 시작시간 기준으로 오름차순 정렬
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]){
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });
//        for (int i = 0; i < N; i++) {
//            for (int j = i + 1; j < N; j++) {
//                if (arr[i][1] > arr[j][1]) {
//                    arr[j] = swap(arr[i], arr[i] = arr[j]);
//                } else if (arr[i][1] == arr[j][1] && arr[i][0] > arr[j][0]) {
//                    arr[j] = swap(arr[i], arr[i] = arr[j]);
//                }
//            }
//        }

        // 이전 종료시간이 다음 시작시간보다 작다면 업데이트
        int answer = 0;
        int endTime = -1;
        for (int i = 0; i < N; i++) {
            if (arr[i][0] >= endTime) {
                endTime = arr[i][1];
                answer += 1;
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();

    }
}
