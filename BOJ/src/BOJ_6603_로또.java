import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_6603_로또 {
    static int [] lotto;
    static boolean[] isSelected;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = -1;

        while(N != 0){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            N = Integer.parseInt(st.nextToken());
            lotto = new int[N];
            isSelected = new boolean[N];

            for (int i = 0; i <N; i++) {
                lotto[i] = Integer.parseInt(st.nextToken());
            }
            recursion(0,0);
            System.out.println();
            if(N == 0){
                break;
            }
        }

    }

    public static void recursion(int cnt,int idx) {
        //cnt가 6개를 다 채우면 끝남
        if(cnt == 6){
            for (int i = 0; i < lotto.length; i++) {
                if(isSelected[i]){
                    System.out.print(lotto[i]+" ");
                }
            }
            System.out.println();
            return;}
        else{
            for (int i = idx; i < lotto.length; i++) {
                if (!isSelected[i]){
                    isSelected[i] = true;
                    recursion(cnt+1,i);
                    isSelected[i] = false;
                }
            }
        }

    }
}
