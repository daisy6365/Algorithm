package level1;

public class 푸드파이트대회 {
    public static void main(String[] args) {
        int[] food1 = {1, 3, 4, 6}; // 1223330333221
        int[] food2 = {1, 7, 1, 2}; // 111303111
        int[] food3 = {1, 1, 2, 3};
        System.out.println(solution(food1));
        System.out.println(solution(food2));
        System.out.println(solution(food3));
    }

    public static String solution(int[] food) {
        StringBuilder answer = new StringBuilder();

        int i = 1;
        while(true){
            if(food[food.length-1] == 0 || i == food.length) break;
            if(food[i] <= 1) {
                i++;
                continue;
            }
            answer.append(i);
            food[i] -= 2;
        }

        StringBuilder temp_answer = new StringBuilder();
        for (int j = answer.length() - 1 ; j >= 0 ; j--) {
            char c = answer.charAt(j);
            temp_answer.append(c);
        }
        answer.append(0).append(temp_answer);

        return answer.toString();
    }
}
