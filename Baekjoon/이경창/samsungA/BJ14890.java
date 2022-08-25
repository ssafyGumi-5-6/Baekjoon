import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ14890 {
    static int N, L;
    static int[][] arr;
    static int answer;

    public static void runway(){

        // 행 체크
        for(int row = 0; row < N;row++){
            int beforeData = arr[row][0];
            int curL = 1;
            boolean checkUp = false;
            int col;
//            System.out.println("현재 인덱스 시작 : " + row);
            for(col = 1; col <N;col++){
                // 같을 경우
//                System.out.println("col : " + col + " beforeData : " + beforeData + " arr : " + arr[row][col] + " curL" + curL);
                if(beforeData == arr[row][col] && !checkUp){
                    curL += 1;
                }else if(beforeData == arr[row][col] && checkUp){
                    if(curL == 0){
                        curL = 1;
                        checkUp = false;
                    }else{
                        curL -= 1;
                    }
                }
                else {
                    // 다를 경우
                    // 둘의 차이가 1인 경우

                    if (beforeData - arr[row][col] == -1 && !checkUp) {
                        if (curL >= L) {
                            beforeData = arr[row][col];
                            curL = 1;
                        } else {
                            break;
                        }
                    }
                    // 둘의 차이가 -1인 경우
                    else if (beforeData - arr[row][col] == 1 && !checkUp) {
//                        System.out.println("-1인 경우 col : " + col + " " + curL);
                        beforeData = arr[row][col];
                        curL = L;
                        checkUp = true;
                        if( col +1 < N && arr[row][col] == arr[row][col+1]){
                            col -= 1;
                        }
//                        if (arr[row][0] == beforeData || curL >= L) {
//
//                        } else {
//                            break;
//                        }
                    } else {
//                        System.out.println("아웃");
                        break;
                    }
                }
            }

            if(curL == 0 && checkUp){
                checkUp = false;
            }

            if(col == N && !checkUp){
//                System.out.println("curL : "  + curL);
//                System.out.println("성공");
                answer += 1;
            }
//            System.out.println();
        }

//        System.out.println(answer);
//        System.out.println();

        for(int col = 0; col < N;col++){
            int beforeData = arr[0][col];
            int curL = 1;
            boolean checkUp = false;
            int row;
//            System.out.println("현재 인덱스 시작 : " + col);
            for(row = 1; row <N;row++){

//                System.out.println(row);
                // 같을 경우
//                System.out.println("col : " + col + " beforeData : " + beforeData + " arr : " + arr[row][col] + " curL" + curL);
                if(beforeData == arr[row][col] && !checkUp){
                    curL += 1;
                }else if(beforeData == arr[row][col] && checkUp){
                    if(curL == 0){
                        curL = 1;
                        checkUp = false;
                    }else{
                        curL -= 1;
                    }
                }
                else {
                    // 다를 경우
                    // 둘의 차이가 1인 경우

                    if (beforeData - arr[row][col] == -1 && !checkUp) {
                        if (curL >= L) {
                            beforeData = arr[row][col];
                            curL = 1;
                        } else {
                            break;
                        }
                    }
                    // 둘의 차이가 -1인 경우
                    else if (beforeData - arr[row][col] == 1) {
//                        System.out.println("-1인 경우 col : " + col + " " + curL);
                        beforeData = arr[row][col];
                        curL = L;
                        checkUp = true;
                        if( row +1 < N && arr[row][col] == arr[row +1][col]){
                            curL -= 1;
                        }
                    } else {
                        break;
                    }
                }
            }

            if(curL == 0 && checkUp){
                checkUp = false;
            }

            if(row == N && !checkUp){
//                System.out.println("성공");
                answer += 1;
            }
        }

//        System.out.println(answer);

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        answer = 0;

        for(int i =0; i <N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0 ; j <N ;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        runway();
        System.out.println(answer);

        // 열 체크

        br.close();
    }
}
