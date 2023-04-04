import java.util.*;
import java.io.*;

public class BOJ_20299_3대측정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());;
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        int answer = 0;

        for(int i =0; i< N ; i++){
            st = new StringTokenizer(br.readLine());
            int rating1 = Integer.parseInt(st.nextToken());
            int rating2 = Integer.parseInt(st.nextToken());
            int rating3 = Integer.parseInt(st.nextToken());
            int sum = rating1 + rating2 + rating3;
            if(rating1 >= L && rating2 >= L && rating3 >= L){
                if(sum >= K){
                    sb.append(rating1 + " ");
                    sb.append(rating2 + " ");
                    sb.append(rating3 + " ");
                    answer++;
                }
            }
        }

        System.out.println(answer);
        System.out.println(sb);

    }
}
