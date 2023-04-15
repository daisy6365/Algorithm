package level1;

class 수박수박수박수박수박수 {
    public String solution(int n) {
        String answer = "";
        int cnt = 0;
        while(true){
            if(cnt == n) break;
            if(cnt % 2 == 0) answer += "수";
            else if(cnt % 2 != 0) answer += "박";
            cnt++;
        }
        return answer;
    }
}