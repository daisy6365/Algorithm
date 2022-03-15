import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_11315_오목판정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine()); //테스트케이스 수
        int[] di = {-1, -1, -1, 0, 1, 1, 1, 0}; //8방 탐색
        int[] dj = {-1, 0, 1, 1, 1, 0, -1, -1}; //8방 탐색

        for (int tc = 1; tc <= TC; tc++) {
            int N = Integer.parseInt(br.readLine()); // 판 크키 N X N
            char[][] board = new char[N][N];

            for (int i = 0; i < N; i++) {
                String s = br.readLine();
                for (int j = 0; j < N; j++) {
                    board[i][j] = s.charAt(j);
                }
            }


            boolean flag = false;
             for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(board[i][j] == '.') continue;
                    for (int d = 0; d < 8; d++) {
                        for (int k = 1; k < 5; k++) {
                            int nexti = i + di[d] * k;
                            int nextj = j + dj[d] * k;

                            if(nexti<0 || nexti>=N || nextj<0 || nextj>=N) break;
                             else if(board[nexti][nextj] != 'o') break;
                             if(k == 4) flag = true;
                        }
                    }
                }
            }
             if(flag) System.out.println("#"+tc+" YES");
             else{System.out.println("#"+tc+" NO");}
        }
    }
}
