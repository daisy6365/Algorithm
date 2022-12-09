public class 삼진법뒤집기 {
    public static int solution(int n) {
        int answer = 0;
        String temp = "";
        while (true){
            if(n <= 0) break;
            temp += n%3;
            n /= 3 ;
        }

        int count = 0;
        for (int i = temp.length() - 1 ; i >= 0; i--) {
            answer += (Math.pow(3, count)* (temp.charAt(i) - '0'));
            count++;
        }
        //Integer.parseInt(temp,3);
        return answer;
    }

    public static void main(String[] args) {
        solution(125);
    }
}
