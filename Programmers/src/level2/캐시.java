package level2;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;

public class 캐시 {
    public static void main(String[] args) {
        String[] cities1 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        String[] cities2 = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};
        String[] cities3 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
        String[] cities4 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
        String[] cities5 = {"Jeju", "Pangyo", "NewYork", "newyork"};
        String[] cities6 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        String[] cities7 = {"A","B","A"};
        String[] cities8 = {"a", "b", "c", "a"};
        System.out.println(solution(3, cities1));
        System.out.println(solution(3, cities2));
        System.out.println(solution(2, cities3));
        System.out.println(solution(5, cities4));
        System.out.println(solution(2, cities5));
        System.out.println(solution(0, cities6));
        System.out.println(solution(3, cities7));
        System.out.println(solution(5, cities8));
    }
    public static int solution(int cacheSize, String[] cities) {
        int answer = 0;
        String temp_s = "";
        Queue<String> queue = new LinkedList<>();

        if (cacheSize == 0) {
            return cities.length * 5;
        }

        for (int i = 0; i < cities.length; i++) {
            temp_s = cities[i].toLowerCase();

            if(queue.contains(temp_s)){
                // queue안에 같은게 있는지 확인하고
                // 같은게 있으면 넣지 않기 -> cache hit : answer + 1
                queue.remove(temp_s);
                queue.add(temp_s);
                answer += 1;
            }
            else{
                // 같은게 없으면 맨앞(참조값) 빼고 맨뒤에 넣기 -> cache miss : answer + 5
                if(queue.size() < cacheSize){
                    queue.add(temp_s);
                }
                else{
                    queue.poll();
                    queue.add(temp_s);
                }
                answer += 5;
            }
        }
        return answer;
    }
}
