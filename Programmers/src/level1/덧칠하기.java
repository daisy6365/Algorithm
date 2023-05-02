package level1;

public class 덧칠하기 {
    public int solution(int n, int m, int[] section) {
        int answer = 0;

        int max_temp = 0;
        for(int i = 0 ; i < section.length ; i++){
            if(section[i] >= max_temp){
                max_temp = section[i] + m;
                answer++;
            }
        }

        return answer;
    }
}
