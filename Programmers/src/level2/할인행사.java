package level2;

import java.util.*;

public class 할인행사 {
    public static void main(String[] args){
        String[] want1 = {"banana", "apple", "rice", "pork", "pot"};
        int[] number1 = {3, 2, 2, 2, 1};
        String[] discount1 = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};
        System.out.println(solution(want1, number1, discount1));

        String[] want2 = {"apple"};
        int[] number2 = {10};
        String[] discount2 = {"banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana"};
        System.out.println(solution(want2, number2, discount2));
    }

    public static int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();
        for(int i =0; i < want.length ; i++){
            map.put(want[i], number[i]);
        }

        for(int i = 0; i <= discount.length - 10 ; i++){
            // 해당 날짜 할인 목록을 새로 저장
            Map<String, Integer> discountMap = new HashMap<>();
            for(int j = 0; j < 10 ; j++){
                // 시작일 + 10일까지
                String item = discount[i + j];
                if(discountMap.containsKey(item)){
                    discountMap.replace(item, discountMap.get(item)+1);
                }
                else{
                    discountMap.put(item, 1);
                }
            }

            boolean flag = true;
            for(String wantItem : map.keySet()){
                if(discountMap.containsKey(wantItem)){
                    // 원하는 항목이라면? -> 비교
                    if(discountMap.get(wantItem) < map.get(wantItem)){
                        flag = false;
                        break;
                    }
                }
                else{
                    flag = false;
                }
            }

            if(flag){
                answer++;
            }
        }

        return answer;
    }
}
