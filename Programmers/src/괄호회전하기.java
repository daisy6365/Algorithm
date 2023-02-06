import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
        flag: for (int i = 0; i < s.length(); i++) {
            Queue<Character> queue = new LinkedList<>();
            String temp_s = "";
            temp_s += s.substring(i);
            temp_s += s.substring(0, i);

            boolean flag = true;
            System.out.println("!!검사시작!! = " + temp_s);
            int j = 0;
            while(true){
                if(queue.isEmpty()) break;
                if(j == temp_s.length()) j = 0;
                if(temp_s.charAt(j) == '('){
                    queue.add('(');
                }
                else if(temp_s.charAt(j) == '{'){
                    queue.add('{');
                }
                else if(temp_s.charAt(j) == '['){
                    queue.add('[');
                }
                else {
                    if(queue.isEmpty()) {
                        continue flag;
                    }
                    else {
                        char temp = queue.peek();
                        if(temp == '(' && temp_s.charAt(j) == ')'){
                            queue.poll();
                        }
                        else if(temp == '{' && temp_s.charAt(j) == '}'){
                            queue.poll();
                        }
                        else if(temp == '[' && temp_s.charAt(j) == ']'){
                            queue.poll();
                        }
                        else {
                            flag = false;
                        }
                    }
                }
            }
            System.out.println("queue = " + queue);
            if(queue.isEmpty() && flag){answer++;}
            System.out.println("answer = "+answer);
        }
        return answer;
    }
}
