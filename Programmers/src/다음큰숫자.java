import java.util.Arrays;

public class 다음큰숫자 {
    public static void main(String[] args) {
        System.out.println(solution(78));
    }

    public static int solution(int n) {
        int count_n = 0;
        String string_n = Integer.toBinaryString(n);
        for (int i = 0; i < string_n.length() ; i++) {
            if(string_n.charAt(i) == '1'){
                count_n++;
            }
        }

        while(true){
            n++;
            String string_temp = Integer.toBinaryString(n);
            int count_temp = 0;
            for (int i = 0; i < string_temp.length() ; i++) {
                if(string_temp.charAt(i) == '1'){
                    count_temp++;
                }
            }
            if(count_temp == count_n) {
                break;
            }
        }
        return n;
    }
}
