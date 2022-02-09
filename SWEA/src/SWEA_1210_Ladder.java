import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SWEA_1210_Ladder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = 10;
        final int U = 1;
        final int L = 2;
        final int R = 3;
        int dir = 1;


        for(int tc =1;tc<=TC;tc++){
            int num = sc.nextInt();
            int [][] ladder = new int[100][100];

            for(int i =0 ; i<100;i++){
                for (int j =0;j<100;j++){
                    ladder[i][j] = sc.nextInt();
                }
            }

            int r = 99;
            int c = 0;
            for(int i = 0 ;i<100;i++){
                if(ladder[99][i] == 2){
                    c = i;
                }
            }
            while (r > 0) {
                if ((c-1)>=0 && dir != R && ladder[r][c-1] == 1) {
                    dir = L;
                    c--;

                } else if ((c+1)<100 && dir != L && ladder[r][c+1] == 1) {
                    dir = R;
                    c++;

                } else {
                    dir = U;
                    r--;
                }

            }
            System.out.println("#" + tc + " " + (c));
        }
    }
}
