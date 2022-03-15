import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1974_스도쿠검증 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= TC; tc++) {
            int N = 9; //스도쿠판 크기 NXN;
            int[][] board = new int[N][N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            /* 검증해야할거
            * 가로전체
            * 세로전체
            * 3X3부분
            */

            //가로
            boolean flag = true;
            for (int i = 0; i < N; i++) {
                int[] num = new int[10];
                for (int j = 0; j < N; j++) {
                    num[board[i][j]]++;
                }

                for (int j = 1; j < 10; j++) {
                    if(num[j] == 0){
                        flag = false;
                        break;
                    }
                }
            }

            //세로
            for (int i = 0; i < N; i++) {
                int[] num = new int[10];
                for (int j = 0; j < N; j++) {
                    num[board[j][i]]++;
                }

                for (int j = 1; j < 10; j++) {
                    if(num[j] == 0){
                        flag = false;
                        break;
                    }
                }         }

            //3X3
            for (int i = 0; i <= 6; i+=3) {
                for (int j = 0; j <= 6; j+=3) {
                    int[] num = new int[10];
                    int nexti = i + 3;
                    int nextj = j + 3;
                    for (int k = i; k < nexti; k++) {
                        for (int l = j; l < nextj; l++) {
                            num[board[k][l]]++;
                        }
                    }
                    for (int k = 1; k < 10; k++) {
                        if(num[k] == 0){
                            flag = false;
                            break;
                        }
                    }
                }
            }
            if(flag==true) System.out.println("#"+tc+" "+1);
            else System.out.println("#"+tc+" "+0);
        }
    }
}
