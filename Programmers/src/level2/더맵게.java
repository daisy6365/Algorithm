package level2;

import java.util.*;

public class 더맵게 {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>();

        for(int i = 0 ; i < scoville.length ; i++){
            q.offer(scoville[i]);
        }

        while(true){
            if(q.peek() >= K) break;
            if(q.peek() < K && q.size() == 1) return -1;
            int food1 = q.poll();
            int food2 = q.poll();

            int result = food1 + (food2 * 2);
            q.offer(result);
            answer++;
        }
        return answer;
    }
}