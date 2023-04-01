import java.util.*;
import java.io.*;

public class BOJ_1946_신입사원 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < TC ; tc++){
            int N = Integer.parseInt(br.readLine());
            int[][] intern = new int[N][2];

            for(int i = 0 ; i < N ; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                intern[i][0] = Integer.parseInt(st.nextToken());
                intern[i][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(intern, Comparator.comparingInt(o -> o[0]));

            int count = 1;
            int temp = intern[0][1];
            for(int i = 1; i < N ; i++){
                if(temp > intern[i][1]){
                    temp = intern[i][1];
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
