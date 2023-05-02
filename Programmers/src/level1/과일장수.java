package level1;

import java.util.*;

public class 과일장수 {
    public static void main(String[] args){
        int[] score = {1, 2, 3, 1, 2, 3, 1};
        System.out.println(solution(3, 4, score));
    }
    public static int solution(int k, int m, int[] score) {
        int answer = 0;
        Integer[] score1 = Arrays.stream(score).boxed().toArray(Integer[] :: new);
        Arrays.sort(score1, Collections.reverseOrder());

        for(int i = m-1 ; i < score.length ; i = i + m){
            answer += (score1[i] * m);
        }
        return answer;
    }
}
