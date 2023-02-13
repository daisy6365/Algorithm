import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2615_오목 {
    static int[][] board = new int[19][19];
    // 우 하 우하 우상
    static int[][] direction = {{0, 1}, {1, 0}, {1, 1}, {-1, 1}}; // -> 1, -1을 곱해야 양방 탐색
    static int result_color, result_col, result_row;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 19; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 19; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                // 1,2를 만나면 오목 체크 (탐색)
                if(board[i][j] != 0){
                    // 오목 맞을 때
                    if(is_condition(i, j)){
                        System.out.println(result_color);
                        System.out.println(result_col + " " + result_row);
                        return;
                    }

                }
            }
        }
        System.out.println(0);
    }
    private static boolean is_condition(int i, int j){
        for(int d = 0; d < 4; d++) {
            int count = 1;
            count += isCheck(i, j, direction[d][0], direction[d][1]);
            count += isCheck(i, j, direction[d][0] * -1, direction[d][1] * -1);

            if(count == 5) {
                result_color = board[i][j];
                result_col = i + 1;
                result_row = j + 1;
                return true;
            }
        }
        return false;
    }

    private static int isCheck(int i, int j , int di, int dj){
        int nexti = i + di;
        int nextj = j + dj;
        int count = 0;

        for (int k = 0; k < 19; k++) {
            if (nexti >= 0 && nexti < 19 && nextj >= 0 && nextj < 19 && board[nexti][nextj] == board[i][j]) {
                count++;
                nexti += di;
                nextj += dj;
            }
            else {
                return count;
            }
        }
        return count;
    }
}