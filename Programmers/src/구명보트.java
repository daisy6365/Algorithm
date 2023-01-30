import java.util.Arrays;

public class 구명보트 {
    public static void main(String[] args) {
        int[] array = {70, 50, 80, 50};
        int[] array2 = {70, 80, 50};
        System.out.println(solution(array, 100));
        System.out.println(solution(array2, 100));
    }

    public static int solution(int[] people, int limit) {
        int answer = 0;
        for (int i = 0; i < people.length; i++) {
            boolean flag = false;
            for (int j = i+1; j < people.length; j++) {
                int sum = people[i] + people[j];
                if(sum <= limit){
                    System.out.println("jjjjjj i = "+ i);
                    flag = true;
                    answer++;
                }
            }
            if (!flag){
                System.out.println("dddd i = "+ i);
                answer++;
            }
        }
        return answer;
    }
}
