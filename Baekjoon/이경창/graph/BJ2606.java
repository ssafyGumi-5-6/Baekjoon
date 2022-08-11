
import java.io.*;
import java.util.StringTokenizer;

public class BJ2606 {
    static int[][] arr;
    static boolean[] visited;
    static int computer_cnt, answer;

    public static void dfs(int idx) {
        answer += 1;
        visited[idx] = true;

        for (int i = 1; i <= computer_cnt; i++) {
            if (arr[idx][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        computer_cnt = Integer.parseInt(br.readLine());
        int pairs = Integer.parseInt(br.readLine());
        arr = new int[computer_cnt + 1][computer_cnt + 1];

        for (int i = 0; i < pairs; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x][y] = arr[y][x] = 1;
        }

        visited = new boolean[computer_cnt + 1];

        dfs(1);

        System.out.println(answer - 1);

        br.close();
    }
}
