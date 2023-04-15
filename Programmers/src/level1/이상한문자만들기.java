package level1;

class 이상한문자만들기 {
    public String solution(String s) {
        String answer = "";

        String[] arr = s.split("");
        int index = 0;
        for (int i = 0; i < arr.length ; i++) {
            if(arr[i].equals(" ")){
                index = 0;
                answer += " ";
            }

            else {
                answer += (index % 2 == 0) ? arr[i].toUpperCase() : arr[i].toLowerCase();
                index++;
            }
        }
        return answer;
    }
}