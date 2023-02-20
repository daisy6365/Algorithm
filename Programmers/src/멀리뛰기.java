public class 멀리뛰기 {
    public static void main(String[] args) {
        System.out.println(solution(4)); // 5
        System.out.println(solution(3)); // 3
    }

    public static long solution(int n) {
        long[] jump = new long[n + 1]; // 칸수 + 1

        if (n == 1)
            return 1;
        if (n == 2)
            return 2;

        jump[0] = 0;
        jump[1] = 1L;
        jump[2] = 2L;

        for (int i = 3; i <= n; i++) {
            jump[i] = (jump[i - 1] + jump[i - 2]) % 1234567;
        }

        return jump[n];
    }
}
