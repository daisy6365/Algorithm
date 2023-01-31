public class 예상대진표 {
    public static void main(String[] args) {
        System.out.println(solution(8, 4, 7));
    }

    public static int solution(int n, int a, int b) {
        int answer = 1;

        while(true) {
            a = (a % 2 != 0) ? a/2+1 : a/2;
            b = (b % 2 != 0) ? b/2+1 : b/2;
            if(a == b) break;
            answer++;
        }

        return answer;
    }
}
