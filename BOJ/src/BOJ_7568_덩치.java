import java.util.*;
import java.io.*;

public class BOJ_7568_덩치 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] WH = new int[N][3];
        StringTokenizer st;

        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            WH[i][0] = Integer.parseInt(st.nextToken());
            WH[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0 ; i < N ; i++){
            int tempW = WH[i][0];
            int tempH = WH[i][1];
            int rank = 1;
            for(int j = 0; j < N ; j++){
                if(tempW < WH[j][0] && tempH < WH[j][1]){
                    rank++;
                }
            }
            WH[i][2] = rank;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < N ; i++){
            sb.append(WH[i][2]).append(" ");
        }

        System.out.println(sb);
    }

}
