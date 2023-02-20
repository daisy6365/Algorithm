import java.util.HashMap;

public class 위장 {
    public static void main(String[] args) {
        String[][] clothes1 = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        String[][] clothes2 = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};
        String[][] clothes3 = {{"a", "headgear"}, {"b", "headgear"}, {"c", "eyewear"}, {"d", "eyewear"}, {"e", "face"}, {"f", "face"}}; /// 26
        System.out.println(solution(clothes1));
        System.out.println(solution(clothes2));
        System.out.println(solution(clothes3));
    }
    public static int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) {
            if(hashMap.containsKey(clothes[i][1])){
                // 중복 -> 값++
                int temp_value = hashMap.get(clothes[i][1]);
                hashMap.replace(clothes[i][1], temp_value+1);
            }
            else{
                hashMap.put(clothes[i][1], 1);
            }
        }

        // 키의 갯수 + 1(아무것도 안하는 것의 경우의 수)
        for (String s: hashMap.keySet()) {
            answer *= (hashMap.get(s) + 1);
        }

        // 걍 모든걸 안한는 것의 경우 1--
        answer--;

        return answer;
    }
}
