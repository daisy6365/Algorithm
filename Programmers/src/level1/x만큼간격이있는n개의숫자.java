package level1;

public class x만큼간격이있는n개의숫자 {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        for (int i = 0; i < answer.length - 1; i++) {
            answer[i] += x;
            answer[i + 1] = answer[i];
        }
        answer[n - 1] += x;
        return answer;
    }
}
