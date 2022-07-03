import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_5607_조합 {
    static final int mod = 1234567891;
    static int N,R;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= TC; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");

            N = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());



            System.out.println("#"+tc+" ");
        }
    }
}
