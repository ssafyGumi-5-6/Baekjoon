
import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Node16236 {
    int x;
    int y;

    public Node16236(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class BJ16236 {

    static int N;
    static int[][] place;
    static int sharkX, sharkY, sharkWeight, shark_eat;
    static boolean[][] visited;
    static int time;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static boolean bfs() {
        Queue<Node16236> queue = new ArrayDeque<>();
        visited = new boolean[N][N];
        queue.add(new Node16236(sharkX, sharkY));
        visited[sharkX][sharkY] = true;
        int feed_i = N;
        int feed_j = N;
        int dist = 0;
        while (queue.size() > 0) {
            int size = queue.size();

            for (int s = 0; s < size; s++) {
                Node16236 node = queue.poll();

                // 만약 node가 상하좌우에 있다면
                for (int i = 0; i < 4; i++) {
                    int nx = dx[i] + node.x;
                    int ny = dy[i] + node.y;

                    if (0 <= nx && nx < N && 0 <= ny && ny < N) {
                        if (place[nx][ny] > sharkWeight) {
                            continue;
                        } else if ((place[nx][ny] == sharkWeight || place[nx][ny] == 0) && !visited[nx][ny]) {
                            queue.add(new Node16236(nx, ny));
                            visited[nx][ny] = true;
                        } else if (place[nx][ny] > 0 && place[nx][ny] < sharkWeight) {
                            if (nx < feed_i) {
                                feed_i = nx;
                                feed_j = ny;
                            } else if (nx == feed_i) {
                                feed_j = Math.min(feed_j, ny);
                            }
                        }
                    }
                }
            }
            dist += 1;

            if (feed_i < N && feed_j < N) {
                sharkX = feed_i;
                sharkY = feed_j;
                shark_eat++;
                place[sharkX][sharkY] = 0;
                if (shark_eat == sharkWeight) {
                    shark_eat = 0;
                    sharkWeight++;
                }
                time += dist;

//                System.out.println("현재 시간 : " + time);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        place = new int[N][N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                place[i][j] = Integer.parseInt(st.nextToken());
                if (place[i][j] == 9) {
                    sharkX = i;
                    sharkY = j;
                    sharkWeight = 2;
                    place[i][j] = 0;
                }
            }
        }

        while (true) {
            if (!bfs()) {
                break;
            }
        }

        System.out.println(time);

        br.close();
    }


}
