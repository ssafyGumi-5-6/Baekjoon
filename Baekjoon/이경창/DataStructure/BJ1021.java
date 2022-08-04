
import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int cnt = 0;
        st = new StringTokenizer(br.readLine());

        LinkedList<Integer> dq = new LinkedList<>();
        int[] arr = new int[m];

        for(int i =1; i<= n;i++){
            dq.add(i);
        }
        for(int i=0;i<m;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i< m ; i++){
            int idx = dq.indexOf(arr[i]);
            int mid = 0;


            if(dq.size() % 2 == 0){
                mid = dq.size() / 2 - 1;
            }else{
                mid = dq.size() / 2;
            }


            if(idx > mid){
                for(int j = dq.size() ; j > idx; j--){
                    int num = dq.pollLast();
                    cnt += 1;
                    dq.offerFirst(num);
                }
            }else{
                for(int j = 0; j < idx; j++){
                    int num = dq.pollFirst();
                    cnt += 1;
                    dq.offerLast(num);
                }
            }

            dq.pollFirst();
        }
        System.out.println(cnt);

        br.close();
    }
}
