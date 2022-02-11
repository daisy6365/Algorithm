import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2999_비밀이메일 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String s = st.nextToken();

        int max_num=0;
        int sqrt = (int) Math.sqrt(s.length());
        for (int i = 1; i <= sqrt; i++) {
            if(s.length() % i == 0){
                max_num = Math.max(max_num,i);
            }
        }

        int cnt=0;
        char [][] wordArr = new char[max_num][s.length()/max_num];
        for (int i = 0; i < s.length()/max_num; i++) {
            for (int j = 0; j < max_num; j++) {
                wordArr[j][i] = s.charAt(cnt++);
            }
        }

        for (int i = 0; i < max_num; i++) {
            for (int j = 0; j < s.length()/max_num; j++) {
                System.out.print(wordArr[i][j]);
            }

        }

    }
}
