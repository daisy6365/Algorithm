package level1;

import java.util.Arrays;

public class 예산 {
    public static int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        for (int i = 0; i < d.length; i++) {
            if(d[i] <= budget){
                budget -= d[i];
                answer++;
            }
        }
        int sum = 0;
        for (int i = 0; i < d.length; i++) {
            sum += d[i];
            if(sum <= budget){
                answer++;
            }
            else{ break;}
        }
        return answer;
    }

    public static void main(String[] args) {
        int [] d = {1,3,2,5,4};
        int budget = 9;
        solution(d, budget);
    }
}
