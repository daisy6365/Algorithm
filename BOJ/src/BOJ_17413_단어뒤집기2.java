import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_17413_단어뒤집기2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        Stack<Character> stack = new Stack<>();
        boolean check = false;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(0) == '<'){
                while(!stack.isEmpty()){
                    char c = stack.pop();
                    System.out.print(c);
                }
                check = true;
                System.out.print(s.charAt(i));
            }
            else if(s.charAt(i) == '>'){
                check = false;
                System.out.print(s.charAt(i));
            }
            else if (check) {
                System.out.print(s.charAt(i));
            }
            else{
                if(s.charAt(i) == ' '){
                    while(!stack.isEmpty()){
                        char c = stack.pop();
                        System.out.print(c);
                    }
                    System.out.print(s.charAt(i));
                }
                else{
                    stack.push(s.charAt(i));
                }
            }

        }
        while(!stack.isEmpty()){
            char c = stack.pop();
            System.out.print(c);
        }
    }
}
