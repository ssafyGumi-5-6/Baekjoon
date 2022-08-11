
import java.io.*;
import java.util.*;

class Print{
    int idx;
    int loc;

    public Print(int idx, int number) {
        this.idx = idx;
        this.loc = number;
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public int getLoc() {
        return loc;
    }

    public void setLoc(int loc) {
        this.loc = loc;
    }
}

public class BJ1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tk = Integer.parseInt(br.readLine());

        for(int i =0 ; i< tk ;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] arr = new int[n];
            Queue<Print> queue = new ArrayDeque<>();
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < n;j++){
                int s = Integer.parseInt(st.nextToken());
                queue.add(new Print(j, s));
                arr[j] = -s;
            }

            Arrays.sort(arr);

            int idx = 0;

            while(idx < n){
                Print p = queue.poll();
//                System.out.println("p : " + p.idx + " " + p.getNumber() + " " + arr[idx] * -1);
                if(p.loc == arr[idx] * -1){
                    if(p.idx == m){
                        System.out.println(idx + 1);
                        break;
                    }
                    idx += 1;
//                    System.out.println(p.idx + " " + m);
                }else{
                    queue.add(p);
                }
            }


        }

        br.close();
    }
}
