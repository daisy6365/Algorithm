import java.util.ArrayList;
import java.util.Arrays;

public class 가장가까운같은글자 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("banana"))); // -1, -1, -1, 2, 2, 2
        System.out.println(Arrays.toString(solution("foobar"))); // -1, -1, 1, -1, -1, -1
    }
    public static int[] solution(String s) {
        int[] answer = new int[s.length()];
        ArrayList<Character> characters = new ArrayList<>();

        for (int i = 0; i < s.length() ; i++) {
            char temp_c = s.charAt(i);
            if(!characters.isEmpty() && characters.contains(temp_c)){
                int temp_num = characters.indexOf(temp_c);
                characters.set(temp_num, '#');
                characters.add(temp_c);
                answer[i] = i - temp_num;
            }
            else{
                characters.add(temp_c);
                answer[i] = -1;
            }
        }

        return answer;
    }
}
