import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ20365 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int BCnt = 0;
        int RCnt = 0;

        String s = br.readLine();
        boolean check = false;
        for(int i =0; i<s.length();i++){
            if(check && s.charAt(i) == 'B'){
                // 선택된 상태이므로 continue
                continue;
            }else if(!check && s.charAt(i) == 'B'){
                // 선택된 상태가 아니므로 변경
                BCnt += 1;
                check = true;
            }else{
                check = false;
            }
        }


        check = false;
        for(int i =0; i<s.length();i++){
            if(check && s.charAt(i) == 'R'){
                // 선택된 상태이므로 continue
                continue;
            }else if(!check && s.charAt(i) == 'R'){
                // 선택된 상태가 아니므로 변경
                RCnt += 1;
                check = true;
            }else{
                check = false;
            }
        }

        int result = Math.min(BCnt, RCnt);
        System.out.println(result + 1);

        br.close();
    }
}
