import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ11866 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);


        int n = sc.nextInt();
        int k = sc.nextInt();
        Queue<Integer> q = new LinkedList<Integer>();

        for(int i=1;i<=n;i++) {
            q.offer(i);  // 해당 큐 맨 뒤에 값 삽입
        }


        int cnt = 1;
        String ans = "<";
        while(q.size() > 1 ){
            if(cnt == k) {
                ans += (q.poll() + ", ");
                cnt = 1;
            }else {
                q.offer(q.poll());
                cnt += 1;
            }
        }

        ans += q.poll();
        System.out.println(ans + ">");


    }

}