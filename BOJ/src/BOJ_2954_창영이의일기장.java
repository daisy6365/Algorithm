import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2954_창영이의일기장 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        String s = st.nextToken();

        while(true){
            s = s.replaceAll("apa","a").replaceAll("epe","e").replaceAll("ipi","i")
                    .replaceAll("opo","o").replaceAll("upu","u");

            System.out.println(s);
            if(!st.hasMoreTokens()){break;}
            s = st.nextToken();
        }
    }
}
