import java.util.Arrays;

public class 이상한문자만들기 {
    public static String solution(String s) {
        String answer = "";

        String[] arr = s.split("");
        int index = 0;
        for (int i = 0; i < arr.length ; i++) {
            if(arr[i].equals(" ")){
                index = 0;
                answer += " ";
            }

            else {
                answer += (index % 2 == 0) ? arr[i].toUpperCase() : arr[i].toLowerCase();
                index++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(" aBc   aBc   aBc "));
    }
}
