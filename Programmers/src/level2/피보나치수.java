package level2;

public class 피보나치수 {
    public static void main(String[] args) {
        System.out.println(solution(3));
    }
    public static int solution(int n) {
        int answer = 0;
        if(n == 1 || n == 0) return 1;
        int num_1 = 0;
        int num_2 = 1;

        for (int i = 2; i <= n; i++) {
            answer = (num_1 + num_2) % 1234567;
            num_1 = num_2;
            num_2 = answer;
        }
        return answer;
    }

}
