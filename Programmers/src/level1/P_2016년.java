package level1;

public class P_2016년 {
    public static void main(String[] args) {
        System.out.println(solution(5, 24));

        // 추가 테스트 케이스
        System.out.println(solution(1, 1));
        System.out.println(solution(2, 29));
        System.out.println(solution(7, 31));
        System.out.println(solution(12, 31));

    }
    public static String solution(int a, int b) {
        String[] week = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        int[] month_day = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int week_num = 5;

        for (int i = 1; i <= a; i++) {
            for (int j = 1; j <= month_day[i-1] ; j++) {
                if(i == a && j == b) break;
                week_num++;
                if(week_num == 7) week_num = 0;
            }
        }
        return week[week_num];
    }
}
