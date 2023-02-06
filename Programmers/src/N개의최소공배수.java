public class N개의최소공배수 {
    public static void main(String[] args) {
        int[] arr1 = {2, 6, 8, 14};
        int[] arr2 = {1, 2, 3};
        System.out.println(solution(arr1));
        System.out.println(solution(arr2));
    }
    public static int solution(int[] arr) {

        if(arr.length == 1) return arr[0];
        int gcd = GCD(arr[0], arr[1]);
        int answer = (arr[0] * arr[1]) / gcd;

        for (int i = 2; i < arr.length; i++) {
            gcd = GCD(answer, arr[i]);
            answer = (arr[i] * answer) / gcd;
        }

        return answer;
    }

    // GCD (최대공약수) 구하기
    private static int GCD(int a, int b){
        int mod_n = a % b;
        if(mod_n == 0) return b;
        else return GCD(b, mod_n);
    }
}
