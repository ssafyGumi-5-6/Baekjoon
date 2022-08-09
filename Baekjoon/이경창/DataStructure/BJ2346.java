import java.io.*;
import java.util.*;

class NodeClass {
    int idx;
    int loc;

    public NodeClass(int idx, int number) {
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

public class BJ2346 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Deque<NodeClass> dequeue = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            dequeue.add(new NodeClass(i + 1, Integer.parseInt(st.nextToken())));
        }

        StringBuilder sb = new StringBuilder();


        while (true) {

            int cnt = dequeue.peekFirst().loc;
            sb.append(dequeue.pollFirst().idx + " ");

            if (dequeue.size() == 0) {
                break;
            } else {
                if (cnt > 0) {
                    for (int k = 0; k < cnt - 1; k++) {
                        dequeue.addLast(dequeue.pollFirst());
                    }
                } else {
                    for (int k = cnt; k < 0; k++) {
                        dequeue.addFirst(dequeue.pollLast());
                    }

                }
            }
        }
        System.out.println(sb);

        br.close();
    }
}
