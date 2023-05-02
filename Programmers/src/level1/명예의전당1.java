package level1;

import java.util.*;

public class 명예의전당1 {
    public static void main(String[] args){
        int[] score = {10, 100, 20, 150, 1, 100, 200};
        System.out.println(Arrays.toString(solution(3, score)));
    }
    public static int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        PriorityQueue<Integer> q = new PriorityQueue<>();

        for(int i = 0 ; i < score.length ; i++){
            if(q.size() == k){
                if(q.peek() < score[i]){
                    q.offer(score[i]);
                    q.poll();
                }
            }
            else{
                q.offer(score[i]);
            }
            answer[i] = q.peek();
        }

        return answer;
    }
}