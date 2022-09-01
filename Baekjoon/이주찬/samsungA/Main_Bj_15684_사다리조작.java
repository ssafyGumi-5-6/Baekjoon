import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_Bj_15684_사다리조작 {
    static int min = -1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()) - 1; // 세로선 개수
        int M = Integer.parseInt(st.nextToken()); // 가로선 개수
        int H = Integer.parseInt(st.nextToken()); // 가로선 위치 개수

        boolean[][] garo = new boolean[H][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            garo[a][b] = true;
        }
        int n = H * N;
        if (isPass(garo)) {
            System.out.println(0);
            return;
        }
        for (int i = 1; i <= 3; i++) {
            boolean[][] visit = new boolean[H][N];
            dfs(0, n, i, garo, visit, N);
            if (min != -1)
                break;
        }
        System.out.println(min);

    }

    static void dfs(int cnt, int n, int r, boolean[][] garo, boolean[][] visit, int g) {
        if (cnt == r) {
            if (isPass(garo)) {
                min = r;
            }
            return;
        }
        for (int i = 0; i < n; i++) {
            int y = i / g;
            int x = i % g;
            if (!isPosb(garo, y, x) || visit[y][x])
                continue;
            garo[y][x] = true;
            dfs(cnt + 1, n, r, garo, visit, g);
            garo[y][x] = false;
            visit[y][x] = false;
        }
    }

    static boolean isPosb(boolean[][] garo, int y, int x) {
        if (!garo[y][x]
                && (x > 0 && !garo[y][x - 1] || x < garo[0].length - 1 && !garo[y][x + 1] || garo[0].length == 1)) {
            return true;
        } else
            return false;
    }

    static boolean isPass(boolean[][] garo) {
        for (int i = 0; i < garo[0].length + 1; i++) {
            int cur = i;
            for (int j = 0; j < garo.length; j++) {
                if (cur < garo[0].length && garo[j][cur]) {
                    cur++;
                } else if (cur > 0 && garo[j][cur - 1]) {
                    cur--;
                }
            }
            if (cur != i)
                return false;
        }
        return true;
    }
}
