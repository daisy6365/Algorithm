import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1174_줄어드는수 {
    static int N;
    static int[] number = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
    static boolean[] isSelected;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        isSelected = new boolean[10];

        backtracking(0, number.length-1);
    }

    public static void backtracking(int cnt, int start){
        if(cnt == N) {
            String s="";
            for (int i = 0; i < number.length; i++) {
                if(isSelected[i]) {
                    s = s + number[i];
                    for (int j = i+1; j < number.length; j++) {
                        if(s != ""){
                            if(s.charAt(s.length()-1) > number[i]){
                                s = s + number[j];
                            }
                        }
                    }
                }
            }
            System.out.print(s);
            return;
        }

        for(int i=start; i>=0; i--) {
            isSelected[i] = true;
            backtracking(cnt+1, i);
            isSelected[i] = false;
        }
    }
}
