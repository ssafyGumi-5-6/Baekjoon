import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_Bj_1021_회전하는큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int cnt = 0;
        
        List<Integer> queue = new LinkedList<Integer>();
        for(int i = 1; i <= N; i++) {
            queue.add(i);
        }
        boolean front = true;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            int n = Integer.parseInt(st.nextToken());

            for(int q = 0; q < queue.size(); q++) {
                if(n == queue.get(q)) {
                    if(q <= queue.size() / 2) {
                        front = true;
                    }else {
                        front = false;
                    }
                }
            }

            if(front) {
                while(true) {
                    int tmp = queue.remove(0);
                    if(tmp == n) {
                        break;
                    }
                    cnt++;
                    queue.add(tmp);
                }
            }else {
                while(true) {
                    queue.add(0, queue.remove(queue.size() - 1));
                    cnt++;
                    if(queue.get(0) == n) {
                        queue.remove(0);
                        break;
                    }
                }
            }
        }

        System.out.println(cnt);


        
    }
}
