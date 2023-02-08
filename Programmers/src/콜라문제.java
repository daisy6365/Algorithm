public class 콜라문제 {
    public static void main(String[] args) {
        System.out.println(solution(2, 1, 20));
        System.out.println(solution(3, 1, 20));
    }
    public static int solution(int a, int b, int n) {
        int answer = 0;

        while(true){
            if(n <= (n % a)) break;
            answer += (n / a) * b;
            n = (n % a) + ((n / a) * b);
        }

        return answer;
    }
}
