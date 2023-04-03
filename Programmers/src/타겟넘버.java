import java.util.Arrays;

public class 타겟넘버 {
    public static void main(String[] args){
        int[] numbers = {5, 10, 1, 3};
        System.out.println(solution(numbers, 3)); //[1, 3]
    }

    public static int solution(int[] numbers, int target) {
        int answer = 0;

        answer = dfs(numbers, target, 0, 0);

        return answer;
    }
    private static int dfs(int[] numbers, int target, int index, int cal){
        int answer = 0;
        if(index == numbers.length){
            if(cal == target){
                return 1;
            }
            return 0;
        }

        answer += dfs(numbers, target, index+1, cal+numbers[index]);
        answer += dfs(numbers, target, index+1, cal + (numbers[index] * -1));

        return answer;
    }
}
