package level1;

import java.util.Arrays;

public class 체육복 {
    public static void main(String[] args) {
        int n1 = 5;
        int[] lost1 = {2, 4};
        int[] reserve1 = {1, 3, 5};
        System.out.println(solution(n1, lost1, reserve1));

        int n2 = 5;
        int[] lost2 = {2, 4};
        int[] reserve2 = {3};
        System.out.println(solution(n2, lost2, reserve2));

        int n3 = 3;
        int[] lost3 = {3};
        int[] reserve3 = {1};
        System.out.println(solution(n3, lost3, reserve3));

        int n4 = 4;
        int[] lost4 = {2, 3};
        int[] reserve4 = {3, 4};
        System.out.println(solution(n4, lost4, reserve4));
    }

    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;

        Arrays.sort(lost);
        Arrays.sort(reserve);

        for (int i = 0; i < lost.length ; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if(lost[i] == reserve[j]){
                    answer++;
                    reserve[j] = 31;
                    lost[i] = 31;
                    break;
                }
            }
        }

        for (int i = 0; i < lost.length ; i++) {
            if(lost[i] == 31) continue;
            int temp_small = lost[i] - 1;
            int temp_big = lost[i] + 1;
            for (int j = 0; j < reserve.length ; j++) {
                if(temp_small == reserve[j] || temp_big == reserve[j]){
                    answer++;
                    reserve[j] = 31;
                    break;
                }
            }
        }

        return answer;
    }
}
