package level1;

public class 정수제곱근판별 {
    public long solution(long n) {
        long answer = 0;
        Double x = Math.sqrt(n);
        answer = (x == x.intValue())? (long)Math.pow(x+1,2) : -1;
        return answer;
    }
}
