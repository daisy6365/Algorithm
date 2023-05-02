package level1;

class 나머지가1이되는수찾기 {
    public int solution(int n) {
        int answer = 0;
        while(true){
            answer++;
            if(n % answer == 1) break;
        }
        return answer;
    }
}