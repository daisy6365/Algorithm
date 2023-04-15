package level2;

public class 카펫 {
    public static void main(String[] args) {
        System.out.println(solution(10, 2));
    }

    public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = brown + yellow;

        for (int i = 3; i < sum; i++) {
            int j = sum / i;
            if(sum % i == 0 && j >= 3){
                int x = Math.max(i, j);
                int y = Math.min(i, j);
                if((x-2) * (y-2) == yellow){
                    answer[0] = x;
                    answer[1] = y;
                    return answer;
                }
            }
        }
        return answer;
    }
}
