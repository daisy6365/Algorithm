package level1;

class 서울에서김서방찾기 {
    public String solution(String[] seoul) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        sb.append("김서방은 ");
        for(int i = 0; i < seoul.length ; i++){
            if(seoul[i].equals("Kim")){
                sb.append(i).append("에 있다");
                answer = sb.toString();
            }
        }
        return answer;
    }
}