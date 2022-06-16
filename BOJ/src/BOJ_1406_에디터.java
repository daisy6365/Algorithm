import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_1406_에디터 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();
        int N = Integer.parseInt(br.readLine());
        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();


        for (int i = 0; i < s.length(); i++) {
            left.push(s.charAt(i));
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if (cmd.equals("L")) { // 왼쪽 옮기기
                if (!left.isEmpty()) {
                    right.push(left.pop());
                }
            } else if (cmd.equals("D")) { // 오른쪽 옮기기
                if (!right.isEmpty()) {
                    left.push(right.pop());
                }
            } else if (cmd.equals("B")) { // 왼쪽 문자 삭제
                if (!left.isEmpty()) {
                    left.pop();
                }
            } else { // P -> P 다음 오는 문자 넣기
                left.push(st.nextToken().charAt(0));
            }
        }

        for (Character c : left) {
            sb.append(c);
        }
        while (!right.isEmpty()) {
            sb.append(right.pop());
        }
        System.out.println(sb);
    }
}
