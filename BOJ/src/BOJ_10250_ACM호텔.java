import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10250_ACM호텔 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= TC; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            //층수(열), 방수(행), N번째 손님
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            int [][] hotel = new int[W][H];
            int count = 0;
            flag : for (int i = 1; i <= W; i++) {
                for (int j = 1; j <= H; j++) {
                    count++;
                   if(count == N){
                       if(i > 9){
                           System.out.println(j+""+i);
                       }
                       else{
                           System.out.println(j+"0"+i);
                       }
                       break flag;
                   }
                }
            }
        }
    }
}
