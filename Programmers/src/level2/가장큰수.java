package level2;

import java.util.*;

public class 가장큰수 {
    public static void main(String[] args){
        int[] nums = {6, 10, 2};
        System.out.println(solution(nums));
    }

    public static String solution(int[] numbers) {
        String answer = "";
        String[] numbers_string = new String[numbers.length];

        for(int i = 0 ; i < numbers.length ; i++){
            numbers_string[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(numbers_string, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2){
                return (o2 + o1).compareTo(o1 + o2);
            }
        });

        if(numbers_string[0].equals("0")) return "0";

        for(int i = 0 ; i < numbers_string.length ; i++){
            answer += numbers_string[i];
        }

        return answer;
    }
}
