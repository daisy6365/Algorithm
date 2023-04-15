package level2;

import java.util.Arrays;

public class 구명보트 {
    public static void main(String[] args) {
        int[] array = {70, 50, 80, 50};
        int[] array2 = {70, 80, 50};
        int[] array3 = {30, 40, 50, 60, 80};
        System.out.println(solution(array, 100));
        System.out.println(solution(array2, 100));
        System.out.println(solution(array3, 100));
    }

    public static int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);
        int i = 0;

        // 무거운 사람부터 확인
        for (int j = people.length - 1 ; j >= i ; j--) {
            int sum = people[i] + people[j];
            if(sum <= limit) {
                i++;
            }
            answer++;
        }
        return answer;
    }
}
