import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_4012_요리사 {
    static int N, min;
    static int[][] ingredients;
    static boolean[] isSelected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= TC; tc++) {
            N = Integer.parseInt(br.readLine());
            ingredients = new int[N][N];
            isSelected = new boolean[N];
            min = Integer.MAX_VALUE;

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine()," ");
                for (int j = 0; j < N; j++) {
                    ingredients[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            cook(0,0);
            System.out.print("#"+tc+" ");
            System.out.println(min);
        }
    }
    public static void cook(int idx,int starti){
        if(idx == N/2){
            int tasteA=0,tasteB=0;
            for (int i = 0; i < N-1; i++) {
                for (int j= i+1; j < N; j++) {
                    if(isSelected[i] && isSelected[j]) {
                        tasteA +=ingredients[i][j]+ingredients[j][i];
                    }
                    if(!isSelected[i] && !isSelected[j]){
                        tasteB += ingredients[i][j]+ingredients[j][i];
                    }
                }
            }
            int result = Math.abs(tasteA-tasteB);
            min = Math.min(min,result);
            return;
        }
        else{
            for (int i = starti; i < N; i++) {
                isSelected[i] = true;
                cook(idx+1,i+1);
                isSelected[i] = false;
            }
        }
    }
}
