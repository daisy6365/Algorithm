package level2;

import java.util.Arrays;

public class N2배열자르기 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(3, 2, 5))); // [3,2,2,3]
        System.out.println(Arrays.toString(solution(4, 7, 14))); // [4,3,3,3,4,4,4,4]
    }
    public static int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left + 1)];

        long count = left;
        for (int i = 0; i < answer.length; i++) {
            int temp_a = (int) (count / n + 1);
            int temp_b = (int) (count % n + 1);
            answer[i] = Math.max(temp_a, temp_b);
            count++;
        }

        return answer;
    }
}
