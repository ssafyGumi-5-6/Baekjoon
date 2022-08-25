
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

class Node2 {
    int x;
    int y;

    public Node2() {
    }

    public Node2(int x, int y) {
        super();
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}

public class test {



    private static int[][] arr;
    private static boolean[] isSelect;

    private static int N;
    private static int M;
    private static Node2[] resultA;
    private static Node2[] resultB;
    private static Node2[] data;
    private static int differnt;

    public static void main(String[] args) throws NumberFormatException, IOException {
        /*
         * 0.입력파일 읽어들이기
         */
//        System.setIn(new FileInputStream("sample_input.txt"));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        /*
         * 1. 입력 파일 객체화
         */
        int T = Integer.parseInt(in.readLine());
        for (int testcase = 1; testcase <= 1; testcase++) {

            sb.append("#" + testcase + " ");

            String[] split = in.readLine().split(" ");
            N = Integer.parseInt(split[0]);
            M = N / 2;
            differnt = Integer.MAX_VALUE;
            isSelect = new boolean[(N * N - N) / 2];

            data = new Node2[(N * N - N) / 2];
            resultA = new Node2[N / 2];
            resultB = new Node2[N / 2];
            arr = new int[N][N];

            for (int i = 0; i < N; i++) {
                split = in.readLine().split(" ");
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(split[j]);
                }
            }

            int datanum = 0;
            for (int i = 1; i < N; i++) {
                for (int j = 0; j < i; j++) {

                    data[datanum] = new Node2(i, j);
                    datanum++;
                }
            }

            /*
             * 2. 알고리즘 풀기
             */

            comb(0, 0);
            sb.append(differnt).append("\n");
            /*
             * 3.결과물 출력
             */

        }
        System.out.println(sb);
    }

    private static void comb(int index, int start) {
        if (index == M) {
            int sumA = 0;
            int sumB = 0;

            System.out.println("실행 : ");
            for(int i =0; i< data.length;i++){
                System.out.println(data[i].getX() + " " + data[i].getY());
            }

            for (int i = 0; i < (N * N - N) / 2; i++) {
                if (!isSelect[i]) {
                    sumB += arr[data[i].getX()][data[i].getY()] + arr[data[i].getY()][data[i].getX()];

                } else if (isSelect[i]) {
                    sumA += arr[data[i].getX()][data[i].getY()] + arr[data[i].getY()][data[i].getX()];
                }
            }
            System.out.println("sumA, sumB : " + sumA + " " + sumB);

            if (differnt > Math.abs(sumA - sumB)) {
                differnt = Math.abs(sumA - sumB);
            }

            return;
        }

        // 유도부
        for (int i = start; i < (N * N - N) / 2; i++) {
            if (!isSelect[i]) {
                isSelect[i] = true;
//            resultA[index] = data[i];
                comb(index + 1, i + 1);
                isSelect[i] = false;
            }
        }

    }
}
