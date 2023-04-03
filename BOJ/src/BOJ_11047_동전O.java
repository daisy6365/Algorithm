import java.util.*;
import java.io.*;

public class BOJ_11047_동전O {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int money = Integer.parseInt(st.nextToken());
        int[] coins = new int[N];

        for(int i = 0 ; i < N ; i++){
            coins[i] = Integer.parseInt(br.readLine());
        }

        int answer = 0;
        for(int i = N-1 ; i >= 0 ; i--){
            if(money == 0) break;
            if((money / coins[i]) >= 1){
                answer += (money / coins[i]);
                money %= coins[i];
            }
        }
        System.out.println(answer);
    }
}
