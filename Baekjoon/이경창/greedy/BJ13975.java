import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ13975 {

    static int[] arr;

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T= Integer.parseInt(br.readLine());

        for(int tk = 1 ; tk <= T; tk++) {
            int K = Integer.parseInt(br.readLine());
            long result = 0;
            arr = new int[K];
            PriorityQueue<Long> pq = new PriorityQueue<>();
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int i = 0; i < K ; i++) {
                pq.offer(Long.parseLong(st.nextToken()));
            }

            while(pq.size() > 1) {
                long first = pq.poll();
                long second = pq.poll();

                result += (first + second);
                pq.offer(first + second);
            }

            System.out.println(result);

        }

        br.close();
    }

}