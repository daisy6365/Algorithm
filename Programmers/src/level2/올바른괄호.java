package level2;

import java.util.LinkedList;
import java.util.Queue;

public class 올바른괄호 {
    public static void main(String[] args) {
        String s = ")()(";
        System.out.println(solution(s));
    }
    public static boolean solution(String s) {
        boolean answer = true;

        Queue<Character> queue = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '('){
                queue.add('(');
            }
            else {
                if(queue.isEmpty()){
                    return false;
                }
                else{
                    queue.poll();
                }
            }
        }

        answer = (queue.isEmpty()) ? true : false;
        return answer;
    }
}
