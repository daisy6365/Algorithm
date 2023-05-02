package level1;

import java.util.ArrayList;
import java.util.Arrays;

public class 두개뽑아서더하기 {
    public static void main(String[] args) {
        int[] numbers1 = {2,1,3,4,1};
        int[] numbers2 = {5,0,2,7};
        System.out.println(Arrays.toString(solution(numbers1)));
        System.out.println(Arrays.toString(solution(numbers2)));
    }

    public static int[] solution(int[] numbers) {
        ArrayList<Integer> temp_arr = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length ; j++) {
                int num = numbers[i] + numbers[j];
                if(!temp_arr.contains(num)){
                    temp_arr.add(num);
                }
            }
        }

        int[] answer = new int[temp_arr.size()];
        for (int i = 0; i < answer.length ; i++) {
            answer[i] = temp_arr.get(i);
        }
        Arrays.sort(answer);

        return answer;
    }
}
