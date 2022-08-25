import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Node2141 implements Comparable<Node2141> {
    int village;
    int peopleCnt;

    public Node2141(int village, int peopleCnt) {
        super();
        this.village = village;
        this.peopleCnt = peopleCnt;
    }

    @Override
    public int compareTo(Node2141 o) {
        // TODO Auto-generated method stub
        if(this.village == o.village) return (int)(this.peopleCnt - o.peopleCnt);
        return (int)(this.village - o.village);
    }

}

public class BJ2141 {

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Node2141[] node = new Node2141[N];
        long howmanyPeople = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int X = Integer.parseInt(st.nextToken());
            int A = Integer.parseInt(st.nextToken());

            node[i] = new Node2141(X, A);
            howmanyPeople += A;
        }

        Arrays.sort(node);

        long villagePeopleCheck = 0;
        for (int i = 0; i < N; i++) {
            villagePeopleCheck += node[i].peopleCnt;
            if (villagePeopleCheck >= (howmanyPeople+1) / 2) {
                System.out.println(node[i].village);
                break;
            }
        }
    }

}