import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class 괄호회전하기 {
    public static void main(String[] args) {
        System.out.println(solution("[](){}")); // 3
        System.out.println(solution("}]()[{")); // 2
        System.out.println(solution("[)(]")); // 0
        System.out.println(solution("}}}")); // 0

    }
    public static int solution(String s) {
        int answer = 0;


        // Si만큼 회전
        for (int i = 0; i < s.length(); i++) {
            Stack<Character> stack = new Stack<>();

            String temp_s = "";
            temp_s += s.substring(i);
            temp_s += s.substring(0, i);

            for (int j = 0; j < temp_s.length() ; j++) {
                if(temp_s.charAt(j) == '(' || temp_s.charAt(j) == '{' || temp_s.charAt(j) == '[') {
                    stack.push(temp_s.charAt(j));
                }
                else {
                    if(!stack.isEmpty()){
                        if(temp_s.charAt(j) == ')'){
                            checkCharactor(stack, '(');
                        }
                        else if(temp_s.charAt(j) == '}'){
                            checkCharactor(stack, '{');
                        }
                        else if(temp_s.charAt(j) == ']'){
                            checkCharactor(stack, '[');
                        }
                    }
                    else{
                        stack.push(s.charAt(j));
                    }
                }
            }
            if(stack.isEmpty()){answer++;}
        }
        return answer;
    }

    private static void checkCharactor(Stack<Character> stack, char check_char){
        if(check_char == stack.peek()){
            stack.pop();
        }
    }
}
