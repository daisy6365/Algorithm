public class 점프와순간이동 {
    public static void main(String[] args) {
        System.out.println(solution(5));
        System.out.println(solution(6));
        System.out.println(solution(5000));
    }
    public static int solution(int n) {
        int ans = 0;

        while(true){
            if(n == 0) break;
            // 짝수라면? -> 나눌때 정수가 됨
            if(n % 2 == 0){
                n /= 2;
            }
            // 정수가 안됨 -1(점프)해야함
            else{
                n = (n-1) / 2;
                ans++;
            }
        }
        return ans;
    }
}
