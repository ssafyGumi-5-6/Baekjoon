import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ21314 {

    static String maxMinK = "";
    static String minMinK = "";

    public static String mulTexRe(char c, long cnt, char plusC) {

        String s = "";
        s += c;

        for (int i = 1; i <= cnt; i++) {
            s += plusC;
        }

        return s;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();


        long mCnt = 0;
        // 제일 큰 것
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'K') {
                maxMinK += mulTexRe('5', mCnt, '0');
                mCnt = 0;
            } else {
                mCnt += 1;
            }
        }

        if (mCnt > 0) {
            maxMinK += mulTexRe('1', mCnt-1, '1');
        }

        mCnt = 0;

        // 제일 작은 것
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'K') {
                if (mCnt >= 1) {
                    minMinK += mulTexRe('1', mCnt - 1, '0');
                }
                minMinK += '5';
                mCnt = 0;
            } else {
                mCnt += 1;
            }
        }

        if (mCnt > 0) {
            minMinK += mulTexRe('1', mCnt - 1, '0');
        }

        System.out.println(maxMinK);
        System.out.println(minMinK);

        br.close();
    }
}
