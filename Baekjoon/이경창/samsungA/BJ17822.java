

import java.io.*;
import java.util.StringTokenizer;

public class BJ17822 {

    static int N, M, T;
    static int[][] arr;

    // 시계 방향, 반시계 방향으로 회전
    // cnt : 방향 움직임 개수
    // idx : 현재 인덱스
    // leftright : 시계, 반시계
    static void swap(int idx, int cnt, int leftright) {
        if (leftright == 1) {
            // 반시계 방향
            for (int k = 0; k < cnt; k++) {
                int tmp = arr[idx][0];
                for (int i = 0; i < M - 1; i++) {
                    arr[idx][i] = arr[idx][i + 1];
                }
                arr[idx][M - 1] = tmp;
            }
        } else if (leftright == 0) {
            // 시계 방향
            for (int k = 0; k < cnt; k++) {
                int tmp = arr[idx][M - 1];
                for (int i = M - 1; i > 0; i--) {
                    arr[idx][i] = arr[idx][i - 1];
                }
                arr[idx][0] = tmp;
            }
        }
    }


    // 상하좌우에 같은 수가 있는지 확인하는 함수
    static boolean udlr() {
        boolean check = false;
        int[][] arr2 = new int[N + 1][M];
        // 배열 복사
        for (int i = 0; i < N; i++) {
            System.arraycopy(arr[i], 0, arr2[i], 0, M);
        }

        for (int i = 0; i < N; i++) {
            for (int inIdx = 0; inIdx < M; inIdx++) {
                // 값이 0이 아닐 때
                if (arr[i][inIdx] != 0) {
                    // 행 위 현재 비교
                    if (i > 0 && arr[i - 1][inIdx] == arr[i][inIdx]) {
                        arr2[i - 1][inIdx] = 0;
                        arr2[i][inIdx] = 0;
                        check = true;
                    }

                    // 행 아래 현재 비교
                    if (i < N - 1 && arr[i + 1][inIdx] == arr[i][inIdx]) {
                        arr2[i + 1][inIdx] = 0;
                        arr2[i][inIdx] = 0;
                        check = true;
                    }

                    // 열 왼쪽 현재 비교
                    if (inIdx > 0 && arr[i][inIdx - 1] == arr[i][inIdx]) {
                        arr2[i][inIdx - 1] = 0;
                        arr2[i][inIdx] = 0;
                        check = true;
                    }

                    // 열 오른쪽 현재 비교
                    if (inIdx < M - 1 && arr[i][inIdx + 1] == arr[i][inIdx]) {
                        arr2[i][inIdx + 1] = 0;
                        arr2[i][inIdx] = 0;
                        check = true;
                    }

                    // 열 마지막과 처음을 비교
                    if (inIdx == 0 && arr[i][M - 1] == arr[i][inIdx]) {
                        arr2[i][M - 1] = 0;
                        arr2[i][inIdx] = 0;
                        check = true;
                    }

                }
            }
        }
        arr = arr2;

        return check;
    }

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // x, d, k 입력 받고 회전을 한다.
        for (int inI = 0; inI < T; inI++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            // 0 : 시계방향, 1 : 반시계방향
            // 배열 수 만큼 해당 방향을으로 회전
            for (int xValue = x; xValue <= N; xValue += x) {
                int curidx = xValue - 1;
                swap(curidx, k, d);
            }

            // 상하좌우 변경된게 없다면
            if (!udlr()) {
                double sum = 0;
                int cnt = 0;

                // 총합과 개수를 센다.
                for (int i = 0; i < N; i++) {
                    for (int inIdx = 0; inIdx < M; inIdx++) {
                        if (arr[i][inIdx] != 0) {
                            cnt += 1;
                            sum += arr[i][inIdx];
                        }
                    }
                }
                sum /= cnt;
                for (int i = 0; i < N; i++) {
                    for (int inIdx = 0; inIdx < M; inIdx++) {
                        // 0이 아닐시 평균보다 작거나 큰지 확인한 후 +-1을 한다.
                        if (arr[i][inIdx] != 0) {
                            if (sum > arr[i][inIdx]) {
                                arr[i][inIdx] += 1;
                            } else if (sum < arr[i][inIdx]) {
                                arr[i][inIdx] -= 1;
                            }
                        }
                    }
                }

            }
        }

        // 0이 아닐경우 덧셈하여 답을 구한다.
        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int inIdx = 0; inIdx < M; inIdx++) {
                if (arr[i][inIdx] != 0) {
                    answer += arr[i][inIdx];
                }
            }
        }

        System.out.println(answer);

        br.close();
    }

}
