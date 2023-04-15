import java.io.*;
import java.util.*;

public class BOJ_10799_쇠막대기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Stack<Character> stack = new Stack<>();
        int result = 0;

        for(int i = 0 ; i < s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push('(');
            }
            else{
                stack.pop();
                if (s.charAt(i - 1) == '(') { // 레이저
                    result += stack.size(); //
                } else { // 막대기
                    result++;
                }
            }

        }

        System.out.println(result);

    }
}
