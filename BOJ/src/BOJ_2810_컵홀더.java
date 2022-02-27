import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2810_컵홀더 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();
        String newString = "*";

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'S'){
                newString += "S*";
            }
            else if(s.charAt(i) == 'L'){
                newString += "LL*";
                i++;
            }
        }

        int count =0;
        int max_num = 0;
        for (int i = 0; i < newString.length(); i++) {
            if(newString.charAt(i) == '*'){
                count++;
            }
        }
        count = Math.min(count,N);
        System.out.println(count);
    }
}
