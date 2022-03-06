import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2309_일곱난쟁이 {
    static int[] dwarfs9;
    static int[] dwarfs7;
    static boolean isSelected;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        dwarfs9 = new int[9];
        dwarfs7 = new int[7];
        for (int i = 0; i < 9; i++) {
            dwarfs9[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(dwarfs9);
        combination(0,0);
    }

    public static void combination(int idx,int start){
        if(isSelected) return;
        if(idx == 7){
            int sum=0;
            for (int i = 0; i < 7; i++) {
                sum += dwarfs7[i];
            }
            if(sum == 100){
                isSelected = true;
                for (int i = 0; i < 7; i++) {
                    System.out.println(dwarfs7[i]);
                }
            }
            return;
        }

        for(int i=start; i<9; i++) {
            dwarfs7[idx] = dwarfs9[i];
            combination(idx+1, i+1);
        }
    }
}
