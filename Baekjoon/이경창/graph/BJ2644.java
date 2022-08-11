
import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Node2644{
    int number;
    int cnt;

    public Node2644() {
    }

    public Node2644(int number, int cnt) {
        this.number = number;
        this.cnt = cnt;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }
}

public class BJ2644 {

    static int[][] arr;
    static boolean[] visited;
    static int num, num2;

    public static int bfs(){
        int result = -1;
        Queue<Node2644> queue = new ArrayDeque<>();
        queue.add(new Node2644(num, 0));
        visited[num] = true;
        while(!queue.isEmpty()){
            Node2644 node = queue.poll();

            if(node.number == num2){
                result = node.cnt;
                break;
            }

            for(int i = 0; i < arr.length; i++){
                if(!visited[i] && arr[node.number][i] == 1){
                    visited[i] = true;
                    queue.add(new Node2644(i, node.cnt + 1));
                }
            }
        }
        return result;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        num = Integer.parseInt(st.nextToken());
        num2 = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visited = new boolean[n];
        for(int i =0 ;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            arr[x][y] = arr[y][x] = 1;
        }

        System.out.println(bfs());


        br.close();
    }
}
