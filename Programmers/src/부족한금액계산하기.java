public class 부족한금액계산하기 {
    public static void main(String[] args) {
        System.out.println(solution(3, 20, 4));
    }
    public static long solution(int price, int money, int count) {
        long total = 0;
        for (int i = 0; i < count; i++) {
            total += (price + (price * i));

        }
        return (total - money > 0) ? total - money : 0;
    }
}
