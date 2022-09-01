import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Stree implements Comparable<Stree>{
    int y;
    int x;
    int age;
    public Stree(int y, int x) {
        this.y = y;
        this.x = x;
        this.age = 1;
    }
    public Stree(int y, int x, int age) {
        this.y = y;
        this.x = x;
        this.age = age;
    }
    @Override
    public int compareTo(Stree o) {
        return this.age - o.age;
    }
    
}

public class Main_Bj_16235_나무재테크 {
    static int N;
    static int[] se = { -1, -1, -1, 0, 0, 1, 1, 1 };
    static int[] ga = { -1, 0, 1, 1, 1, 0, -1, -1 };
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(map[i], 5);
        }
        int[][] pan = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                pan[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        List<Stree> trees = new ArrayList<Stree>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            trees.add(new Stree(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1));
        }

        for (int i = 0; i < K; i++) {
            aYear(map, trees, pan);
            if (trees.size() == 0)
                break;
        }

        System.out.println(trees.size());

    }
    
    static void aYear (int[][] map, List<Stree> trees, int[][] pan) {
        Collections.sort(trees);
        int[][] dead = new int[N][N];
        for (int i = 0; i < trees.size(); i++) {
            Stree tree = trees.get(i);
            int y = tree.y;
            int x = tree.x;
            int age = tree.age;
            if (map[y][x] >= age) {
                map[y][x] -= age;
                tree.age++;
            } else {
                dead[y][x] += age / 2;
                trees.remove(tree);
                i--;
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] += dead[i][j];
            }
        }
        for (int i = 0, size = trees.size(); i < size; i++) {
            Stree tree = trees.get(i);
            if (tree.age % 5 == 0) {
                for (int j = 0; j < 8; j++) {
                    int ys = tree.y + se[j];
                    int xg = tree.x + ga[j];
                    if (ys < 0 || xg < 0 || ys >= N || xg >= N)
                        continue;
                    trees.add(new Stree(ys, xg));
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] += pan[i][j];
            }
        }

    }
}
