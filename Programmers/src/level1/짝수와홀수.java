package level1;

public class 짝수와홀수 {
    public String solution(int num) {
        String answer = (num % 2 == 0)? "Even" : "Odd";
        return answer;
    }
}
