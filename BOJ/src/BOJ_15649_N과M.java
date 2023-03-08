import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15649_N과M {
    static int N,M;
    static int[] result;
    static boolean[] isSelected;
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        result = new int[N+1];
        isSelected = new boolean[N+1];

        backtracking(0);
    }

    private static void backtracking(int index){
        if(index == M){
            for (int i = 0; i < M; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
        }

        for (int i = 1; i <= N; i++) {
            if(!isSelected[i]){
                isSelected[i] = true;
                result[index] = i;
                backtracking(index + 1);
                isSelected[i] = false;
            }
        }
    }
}
