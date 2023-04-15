package level1;

class 가운데글자가져오기 {
    public String solution(String s) {
        String answer = "";
        if(s.length() % 2 != 0){
            answer += s.substring(s.length()/2,s.length()/2+1);
        }
        else{
            answer += s.substring(s.length()/2-1 , s.length()/2+1);
        }
        return answer;
    }
}