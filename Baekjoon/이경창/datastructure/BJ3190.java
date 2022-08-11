
import java.awt.*;
import java.io.*;
import java.util.*;


class Node {
    int x, y;

    public Node(int x, int y) {
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

public class BJ3190 {
    static int[][] dxy = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static int dxyIdx = 0;
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());


        graph = new int[n][n];
        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 2라면 사과가 있는 곳
            graph[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = 2;
        }

        int l = Integer.parseInt(br.readLine());
        Map<Integer, Character> map = new LinkedHashMap<>();

        for (int i = 0; i < l; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            map.put(Integer.parseInt(st.nextToken()), st.nextToken().charAt(0));
        }

        int time = 0;
        int loc = 0;
        int x = 0;
        int y = 0;
        boolean check = false;

        Queue<Node> q = new ArrayDeque<>();
        graph[x][y] = 1;
        q.offer(new Node(x, y));
        int idx = 0;
        for (Map.Entry<Integer, Character> m : map.entrySet()) {
            int spin_time = m.getKey();
            char c = m.getValue();
            while (time < spin_time) {
                time += 1;

                x += dxy[loc][0];
                y += dxy[loc][1];

                // 방문한 곳이 벗어났다면
                if (!(0 <= x && x < n && 0 <= y && y < n)) {
                    check = true;
                    break;
                }

                // 꼬리가 연결되어 있는 곳이라면
                if (graph[x][y] == 1) {
                    check = true;
                    break;
                }


                // 현재 위치에 사과가 없다면
                if (graph[x][y] != 2) {
                    graph[q.peek().x][q.peek().y] = 0;
                    q.poll();
                }
                graph[x][y] = 1;
                q.offer(new Node(x, y));

            }

            if (check) {
                break;
            }

            // 위치 변경
            if (c == 'L') {
                loc -= 1;
            } else {
                loc += 1;
            }

            if (loc < 0) {
                loc = 3;
            } else if (loc > 3) {
                loc = 0;
            }
        }

        if (!check) {
            // 이제 마지막 구간 돌리기
            while (0 <= x && x < n && 0 <= y && y < n) {
                time += 1;

                x += dxy[loc][0];
                y += dxy[loc][1];
//                System.out.println(dxy[loc][0] + " " + dxy[loc][1]);
//                System.out.println("time : " + time + " x, y : " + x + " " + y);

                // 방문한 곳이 벗어났다면
                if (!(0 <= x && x < n && 0 <= y && y < n)) {
                    check = true;
                    break;
                }

                // 꼬리가 연결되어 있는 곳이라면
                if (graph[x][y] == 1) {
                    check = true;
                    break;
                }


                // 현재 위치에 사과가 없다면
                if (graph[x][y] != 2) {
                    graph[q.peek().x][q.peek().y] = 0;
                    q.poll();
                }
                graph[x][y] = 1;
                q.offer(new Node(x, y));
            }
        }

        System.out.println(time);

        br.close();
    }
}
