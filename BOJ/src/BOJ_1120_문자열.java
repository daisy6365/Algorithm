import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1120_문자열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        //A <= B
        String A = st.nextToken();
        String B = st.nextToken();

        int min = A.length();
        for (int i = 0; i <= B.length()-A.length() ; i++) {
            int count=0;
            for (int j = 0; j < A.length(); j++) {
                if(A.charAt(j) != B.charAt(i+j)){
                    count++;
                }
            }
            min = Math.min(min,count);
        }
        System.out.println(min);
    }
}
