package level2;

import java.util.Stack;

public class 짝지어제거하기 {
    public static void main(String[] args) {
        System.out.println(solution("cdcd"));
    }

    public static int solution(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = chars[i];

            if(stack.isEmpty()) stack.push(c);
            else{
                if(stack.peek() == c){
                    stack.pop();
                }
                else stack.push(c);
            }

        }

        if(stack.isEmpty()){
            return 1;
        }
        return 0;

    }
}
