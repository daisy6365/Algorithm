public class 삼총사 {
    public static void main(String[] args) {
        int[] arr1 = {-2, 3, 0, 2, -5};
        int[] arr2 = {-3, -2, -1, 0, 1, 2, 3};
        int[] arr3 = {-1, 1, -1, 1};
        System.out.println(solution(arr1));
        System.out.println(solution(arr2));
        System.out.println(solution(arr3));
    }
    public static int solution(int[] number) {
        int answer = 0;
        for (int i = 0; i < number.length; i++) {
            for (int j = i+1; j < number.length; j++) {
                for (int k = j+1; k < number.length; k++) {
                    if (number[i] + number[j] + number[k] == 0) {
                        answer++;
                    }
                }
            }
        }
        return answer;
    }
}
