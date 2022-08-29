

import java.io.*;
import java.util.StringTokenizer;

public class BJ17281 {

    static int N;
    static int[][] arr;
    static int[] number;
    static int[] input;
    static boolean[] isSelected;
    static int result;

    static void gameStart(int[] checkNumber) {
        int[][] checkArr = new int[N][9];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 9; j++) {
                if (j == 3) {
                    checkArr[i][j] = arr[i][j];
                } else {
                    if (j < 3)
                        checkArr[i][j] = arr[i][checkNumber[j]];
                    else
                        checkArr[i][j] = arr[i][checkNumber[j - 1]];
                }
            }
        }

        int gameIdx = 0;
        int sum = 0;

        int answer = 0;
        for (int i = 0; i < N; i++) {
            int j = gameIdx;
            int gameCnt = 0;
            int[] boll = new int[4];
            while (gameCnt < 3) {
                if (checkArr[i][j] == 0) {
                    gameCnt++;
                } else {
                    if (checkArr[i][j] == 1) {
                        // 3이 1이면 1점
                        if (boll[3] == 1) {
                            boll[3] = 0;
                            sum += 1;
                        }
                        boll[3] = boll[2];
                        boll[2] = boll[1];
                        boll[1] = 1;
                    } else if (checkArr[i][j] == 2) {
                        // 3이 1이면 1점
                        if (boll[3] == 1) {
                            boll[3] = 0;
                            sum += 1;
                        }
                        // 2가 1이면 1점
                        if (boll[2] == 1) {
                            boll[2] = 0;
                            sum += 1;
                        }
                        boll[3] = boll[1];
                        boll[1] = 0;
                        boll[2] = 1;
                    } else if (checkArr[i][j] == 3) {
                        // 3이 1이면 1점
                        if (boll[3] == 1) {
                            boll[3] = 0;
                            sum += 1;
                        }
                        // 2이 1이면 1점
                        if (boll[2] == 1) {
                            boll[2] = 0;
                            sum += 1;
                        }
                        // 1이 1이면 1점
                        if (boll[1] == 1) {
                            boll[1] = 0;
                            sum += 1;
                        }

                        boll[3] = 1;

                    } else if (checkArr[i][j] == 4) {
                        if (boll[3] == 1) {
                            boll[3] = 0;
                            sum += 1;
                        }
                        // 2이 1이면 1점
                        if (boll[2] == 1) {
                            boll[2] = 0;
                            sum += 1;
                        }
                        // 1이 1이면 1점
                        if (boll[1] == 1) {
                            boll[1] = 0;
                            sum += 1;
                        }

                        sum += 1;
                    }

                }

                j++;

                if (j == 9)
                    j = 0;
            }

            gameIdx = j;
            if (gameIdx == 9)
                gameIdx = 0;
        }

        result = Math.max(result, sum);
    }

    static void perm(int cnt) {
        if (cnt == 8) {
            gameStart(number);
            return;
        }

        for (int i = 0; i < 8; i++) {
            if (!isSelected[i]) {
                isSelected[i] = true;
                number[cnt] = input[i];
                perm(cnt + 1);
                isSelected[i] = false;
            }
        }
    }

    static int swap(int a, int b) {
        return a;
    }

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][9];
        number = new int[8];
        isSelected = new boolean[8];
        input = new int[8];

        for (int i = 0; i < 8; i++) {
            if (i < 3) {
                input[i] = i;
            } else {
                input[i] = i + 1;
            }
        }

        for (int nk = 0; nk < N; nk++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 9; i++) {
                arr[nk][i] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            arr[i][4 - 1] = swap(arr[i][1 - 1], arr[i][1 - 1] = arr[i][4 - 1]);
        }

        // 순열
        perm(0);
        System.out.println(result);

        br.close();
    }

}
