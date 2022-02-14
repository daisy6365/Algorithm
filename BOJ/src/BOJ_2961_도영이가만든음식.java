import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2961_도영이가만든음식 {
    static int N;
    static int [][] ingredients;
    static int subValue, minValue;
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        ingredients = new int[N][2];//S,B
        subValue = 0;
        minValue = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            ingredients[i][0] = Integer.parseInt(st.nextToken());
            ingredients[i][1] = Integer.parseInt(st.nextToken());
        }

        cook(0,1,0);
        System.out.println(minValue);

    }

    public static void cook(int idx, int totalS, int totalB){
        if(idx == N){
            if (totalB == 0) {// 재료를 사용하지 않으면 리턴
                return;
            }
            subValue = Math.abs(totalS - totalB);
            minValue = Math.min(subValue,minValue);

            return;
        }
        else {
            cook(idx+1, totalS*ingredients[idx][0],totalB+ingredients[idx][1]);
            cook(idx+1, totalS,totalB);
        }
    }
}
