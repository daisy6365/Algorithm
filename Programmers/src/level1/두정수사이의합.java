package level1;

class 두정수사이의합 {
    public long solution(int a, int b) {
        long answer = 0;
        answer = a;

        if(a != b){
            while(true){
                if(a == b) break;
                a = (a<=b) ? a+1 : a-1;
                answer += a;
            }
        }
        return answer;
    }
}