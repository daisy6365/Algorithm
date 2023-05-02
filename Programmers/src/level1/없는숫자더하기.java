package level1;

class 없는숫자더하기 {
    public int solution(int[] numbers) {
        int answer = 0;
        boolean arr[] = new boolean[10];
        for(int i = 0 ; i < numbers.length ; i++){
            arr[numbers[i]] = true;
        }
        for(int i = 1 ; i < 10 ; i ++){
            answer += (!arr[i]) ? i : 0;
        }
        return answer;
    }
}