import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ16953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int cnt = 0;
        String sB;

        while(true){
            if(B <= A) {
                if (B == A) break;
                else if (B < A) {
                    cnt = -1;
                    break;
                }
            }

            // 10으로 나누었을 때 나머지가 1일 때
            if(B % 10 == 1){
                B = B / 10;

                cnt += 1;
            }else if(B % 2 == 0){
                // 2로 나누어 떨어질 때
                B = B / 2;

                cnt += 1;
            }else{
                // 3, 5, 7, 9 인 경우
                cnt = -1;
                break;
            }

        }

        if(cnt == -1){
            System.out.println(cnt);
        }else{
            System.out.println(cnt + 1);
        }

        br.close();
    }
}
