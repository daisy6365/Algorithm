import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SWEA_9229_한빈이와SpotMart {
    static int N,M,over_weight;
    static int[] snack_list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());


        for(int tc =1; tc<=TC;tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); //과자 갯수
            M = Integer.parseInt(st.nextToken()); //제한 무게
            over_weight = -1;
            snack_list = new int[N];

            st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++){
                snack_list[i] = Integer.parseInt(st.nextToken());
            }
            snack(0,0,0);
            System.out.println("#"+tc+" "+over_weight);
        }
    }

    static void snack(int sum, int cnt, int select_cnt){
        if(sum>M) {
            return;
        } if(select_cnt==2||cnt == N) {
            if(M>=sum && select_cnt>=2) {
                over_weight = Math.max(over_weight, sum);
            }
            return;
        }
        snack(sum+snack_list[cnt], cnt+1, select_cnt+1);
        snack(sum, cnt+1, select_cnt);

    }
}
