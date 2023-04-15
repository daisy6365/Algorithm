package level2;
import java.util.*;

public class 주식가격 {
    public static void main(String[] args){
        int[] prices = {1, 2, 3, 2, 3};
        System.out.println(Arrays.toString(solution(prices)));

    }

    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for(int i = 0 ; i < prices.length ; i++){
            int temp = prices[i];
            for(int j = i ; j < prices.length ; j++){
                answer[i] = j - i;
                if(prices[j] < temp){
                    // 주식이 떨어졌을때
                    break;
                }
            }
        }

        return answer;
    }
}
