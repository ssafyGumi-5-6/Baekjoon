package Baekjoon;

import java.util.*;
import java.io.*;

public class BJ8979 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int a = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);
        int[] result = new int[a+1];
        Map<Integer, Integer> m = new HashMap<>();

        for(int i = 0 ; i< a; i++) {
            s = br.readLine().split(" ");
            int[] arr = new int[s.length];
            for (int j = 0; j < s.length; j++) {
                arr[j] = Integer.parseInt(s[j]);
            }

            result[arr[0]] = arr[1] * 3 + arr[2] * 2 + arr[3];
            m.put(arr[0], result[arr[0]]);
        }

        List<Map.Entry<Integer, Integer>> entryList = new LinkedList<>(m.entrySet());
        entryList.sort(((o1 ,o2) -> m.get(o2.getKey()) - m.get(o1.getKey())));
        int cnt = 0;
        int before = -1, check_idx = 0;
        for(int i = 0; i < entryList.size();i++){
            if(before == entryList.get(i).getValue()){
                check_idx += 1;
            }
            else{
                cnt += check_idx;
                check_idx = 0;
                cnt += 1;
            }

            before = entryList.get(i).getValue();

            if(entryList.get(i).getKey() == k){
                break;
            }
        }
        System.out.println(cnt);

        br.close();
    }
}
