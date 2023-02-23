import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 다시 풀이
public class BOJ_1406_에디터 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine(); // 주어진 문자열
        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(br.readLine()); // 명령어

        Stack<Character> cursor_left = new Stack<>();
        Stack<Character> cursor_right = new Stack<>();

        for (int i = 0; i < word.length() ; i++) {
            cursor_left.push(word.charAt(i));
        }

        for (int i = 0; i < M; i++) {
            String command = br.readLine();

            switch (command.charAt(0)) {
                case 'L' :{ // 왼쪽
                    if (!cursor_left.isEmpty()){
                        cursor_right.push(cursor_left.pop());
                    }
                    break;
                }
                case 'D' :{ // 오른쪽
                    if (!cursor_right.isEmpty()){
                        cursor_left.push(cursor_right.pop());
                    }
                    break;
                }
                case 'B' :{ // 커서기준 왼쪽문자 삭제
                    if (!cursor_left.isEmpty()){
                        cursor_left.pop();
                    }
                    break;
                }
                case 'P' :{ // 문자 커서기준 왼쪽에 추가
                    cursor_left.push(command.charAt(2));
                    break;
                }
            }

        }
        for (char c: cursor_left) {
            sb.append(c);
        }

        while(true){
            if(cursor_right.isEmpty()) break;
            sb.append(cursor_right.pop());
        }

        System.out.println(sb);
    }
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//
//        String s = br.readLine();
//        int N = Integer.parseInt(br.readLine());
//        Stack<Character> left = new Stack<>();
//        Stack<Character> right = new Stack<>();
//
//
//        for (int i = 0; i < s.length(); i++) {
//            left.push(s.charAt(i));
//        }
//
//        for (int i = 0; i < N; i++) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            String cmd = st.nextToken();
//            if (cmd.equals("L")) { // 왼쪽 옮기기
//                if (!left.isEmpty()) {
//                    right.push(left.pop());
//                }
//            } else if (cmd.equals("D")) { // 오른쪽 옮기기
//                if (!right.isEmpty()) {
//                    left.push(right.pop());
//                }
//            } else if (cmd.equals("B")) { // 왼쪽 문자 삭제
//                if (!left.isEmpty()) {
//                    left.pop();
//                }
//            } else { // P -> P 다음 오는 문자 넣기
//                left.push(st.nextToken().charAt(0));
//            }
//        }
//
//        for (Character c : left) {
//            sb.append(c);
//        }
//        while (!right.isEmpty()) {
//            sb.append(right.pop());
//        }
//        System.out.println(sb);
//    }
}
