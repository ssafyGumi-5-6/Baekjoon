
import java.io.*;
import java.util.StringTokenizer;

public class Bj14503 {

    static int N, M, cnt;
    static int r, c, d;
    static int[][] arr;
    static int[] dx = {-1, 0 , 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static void dfs(int r, int c, int dir){
        // 1인 경우
        if(arr[r][c] == 1) return;
        else if(arr[r][c] == 0){
            // 0인경우 2로 변경
            // 1로는 변경 안됨
            arr[r][c] = 2;
            cnt += 1;
        }

        // 재귀 반복문, 4 방향으로 확인한다.
        int in_r = 0, in_c = 0;
        for(int i = 0; i < 4; i++){
            dir = (dir + 3) % 4;
            in_r = r + dx[dir];
            in_c = c + dy[dir];
            if(arr[in_r][in_c] > 0) continue;
            dfs(in_r, in_c, dir);
            return;
        }

        // 3. 네 방향 모두 청소가 이미 되어있거나 벽인 경우에는, 바라보는 방향을 유지한 채로 한 칸 후진을 하고 2번으로 돌아간다.
        dfs(r - dx[dir], c- dy[dir], dir);
        return;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for(int i = 0; i < N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(r, c, d);
        System.out.println(cnt);


        br.close();
    }
}
