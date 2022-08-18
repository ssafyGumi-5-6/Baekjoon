import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ1260 {
    static int nV; // 정점의 수
    static int nE; // 간선의 수
    static int [][] arr2d;

    static boolean [] checkDFS;
    static boolean [] checkBFS;


    // dfs 정렬 메서드
    static void dfs(int i) {
        System.out.print(i + " ");
        //방문한 정점 출력
        checkDFS[i] = true;
        //해당 정점 방문했으니까 체크;

        for(int j = 1; j < nV + 1; j++) {
            if(arr2d[i][j] == 1 && checkDFS[j] == false) {
                dfs(j);
            }
        }
    }

    //	bfs 정렬 메서드
    static void bfs(int i) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(i);

        while(!q.isEmpty()) {
            int temp = q.poll();

            System.out.print(temp + " ");
            checkBFS[temp] = true;
            //해당 정점 방문했으니까 체크;

            for(int j = 1; j < nV + 1; j++) {
                if(arr2d[temp][j] == 1 && checkBFS[j] == false) {
                    q.offer(j);
                    checkBFS[j] = true;
                    //해당 정점 방문했으니까 체크;
                }
            }
        }
    }


    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        nV = scan.nextInt();
        nE = scan.nextInt();
        int start = scan.nextInt();
        arr2d = new int [nV + 1][nV + 1];
        checkDFS = new boolean [nV + 1];
        checkBFS = new boolean [nV + 1];


        for(int i = 0; i < nE; i++) {
            int temp1 = scan.nextInt();
            int temp2 = scan.nextInt();

            arr2d[temp1][temp2] = arr2d[temp2][temp1] = 1;

        }

        dfs(start);
        System.out.println();
        bfs(start);


    }

}
