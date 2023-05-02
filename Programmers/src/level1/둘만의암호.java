package level1;

public class 둘만의암호 {
    public static void main(String[] args) {
        System.out.println(solution("aukks" , "wbqd", 	5));
        System.out.println(solution("zzzzz" , "a", 	1));
    }

    public static String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();

        for(int i = 0; i < s.length() ; i++){
            char change_s = s.charAt(i);
            int count = 0;
            while(true){
                if(count == index) break;
                // change_s 바꾸기
                if(change_s == 'z'){
                    change_s = 'a';
                }
                else {
                    change_s += 1;
                }
                if(skip.indexOf(change_s) < 0){
                    count++;
                }
            }
            answer.append(change_s);
        }

        return answer.toString();
    }
}
