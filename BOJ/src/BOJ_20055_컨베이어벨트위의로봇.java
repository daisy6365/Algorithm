import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_20055_컨베이어벨트위의로봇 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] belt = new int[N*2];
        boolean[] isSelected = new boolean[N*2];

        st = new StringTokenizer(br.readLine()," ");
        for (int j = 0; j < N; j++) {
            belt[j] = Integer.parseInt(st.nextToken());
        }
        for (int j = N*2-1; j >= N ; --j) {
            belt[j] = Integer.parseInt(st.nextToken());
        }

        int zeroCount = 0;
        int step = 1;
        flag : while (true){
            for (int j = 0; j < N*2; j++) {
                if(isSelected[j])continue;
                belt[j] = belt[j] - 1;
                if (belt[j] <= 0) {
                    isSelected[j] = true;
                    zeroCount = zeroCount+1;
                    if (zeroCount == K) {
                        break flag;
                    }
                    else{
                        j = 0;
                        continue;
                    }
                }
                step++;
            }
        }

        System.out.println(Arrays.toString(belt));
        System.out.println(step);
    }
}
