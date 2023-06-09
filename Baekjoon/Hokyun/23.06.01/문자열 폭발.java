import java.util.Scanner;
import java.util.Stack;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String originalStr = sc.nextLine();
        String tnt = sc.nextLine();

        char tntLastCharacter = tnt.charAt(tnt.length() - 1); // 폭발 문자열의 마지막 단어
        Stack<Character> postBlastStack = new Stack<>(); // 폭발 이후 남을 문자

        for(int i = 0; i < originalStr.length(); i++) {
            // 모든 문자를 스택에 넣는다.
            postBlastStack.push(originalStr.charAt(i));

            // 스택에 들어가는 문자가 폭발 문자열의 마지막 문자와 동일하고 폭발 이후 남을 문자 수가 폭발 문자열의 길이보다 길면
            if (originalStr.charAt(i) == tntLastCharacter && postBlastStack.size() >= tnt.length()) {
                boolean isSame = true;
                // 뒤에서부터 폭발 문자열 길이 만큼이 폭발 문자열과 같은 문자열인지 확인한다.
                for (int j = 0; j < tnt.length(); j++) {
                    if (postBlastStack.get(postBlastStack.size() - tnt.length() + j) != tnt.charAt(j)) {
                        isSame = false;
                        break;
                    }

                }

                // 폭발 문자열과 같은 문자열이면 폭발 문자열 길이만큼 스택에서 제거한다.
                if(isSame) {
                    for (int j = 0; j < tnt.length(); j++) {
                        postBlastStack.pop();
                    }
                }
            }
        }

        // 이후 StringBuilder를 이용해 스택의 값을 문자열로 변경해준다.
        StringBuilder sb = new StringBuilder();
        postBlastStack.forEach(sb::append);
        System.out.println(sb.length() == 0 ? "FRULA" : sb.toString());
        sc.close();
    }
}
