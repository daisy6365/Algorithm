import java.util.HashMap;

public class 위장 {
    public static void main(String[] args) {
        String[][] clothes1 = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        String[][] clothes2 = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};
        System.out.println(solution(clothes1));
        System.out.println(solution(clothes2));
    }
    public static int solution(String[][] clothes) {
        int answer = 0;
        int temp_duplicate = 0;
        HashMap<String, String> hashMap = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            if(!hashMap.isEmpty() && !hashMap.containsValue(clothes[i][1])){
                temp_duplicate++;
            }

            hashMap.put(clothes[i][0], clothes[i][1]);
        }

        answer = hashMap.size() + temp_duplicate * (hashMap.size() - temp_duplicate);

        return answer;
    }
}
