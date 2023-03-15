import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10972_다음순열 {
    static int N;
    static int[] num;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        num = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        if (nextPermutation()){
            for (int i = 0; i < N; i++) {
                System.out.print(num[i] + " ");
            }
        }
        else System.out.println(-1);
    }
    private static boolean nextPermutation(){
        int i = N - 2;
        while(i >= 0 && num[i] >= num[i+1]) --i;
        if(i < 0) return false;

        int j = N - 1;
        while(j >= 0 && num[i] >= num[j]) --j;

        swap(i, j);
        reverse(i + 1, N - 1);

        return true;
    }

    private static void swap(int i, int j){
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }

    private static void reverse(int i, int j){
        while(i < j){
            swap(i++, j--);
        }
    }
}
