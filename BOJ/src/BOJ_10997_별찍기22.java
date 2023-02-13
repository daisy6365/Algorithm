import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10997_별찍기22 {
    static char[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        if(N == 1){
            System.out.println("*");
            return;
        }

        int col = N * 4 - 1;
        int row = N * 4 - 3;
        board = new char[col][row];
        init_board();

        // 별찍기
        draw_star(N, 0, row - 1);

        // 출력
        out_start();
    }

    private static void init_board(){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = ' ';
            }
        }
    }

    private static void draw_star(int n, int start_i, int start_j){
        int draw_width = n * 4 - 3;
        int draw_height = n * 4 - 1;

        // 상
        for (int i = 1; i < draw_width; i++) {
            board[start_i][start_j--] = '*';
        }


        // 좌
        for (int i = 1; i < draw_height; i++) {
            board[start_i++][start_j] = '*';
        }

        // 하
        for (int i = 1; i < draw_width; i++) {
            board[start_i][start_j++] = '*';
        }

        // 우
        // 2개 아래까지만 찍어야함
        for (int i = 0; i < draw_height - 2; i++) {
            board[start_i--][start_j] = '*';
        }

        if(n == 1){
            return;
        }

        // 재귀 시작점을 찍음
        board[++start_i][--start_j] = '*';
        draw_star(n-1, start_i, start_j-1);
    }

    private static void out_start(){
        for (int i = 0; i < board.length ; i++) {
            if(i == 1){
                System.out.print("*\n");
                continue;
            }
            else{
                for (int j = 0; j < board[0].length ; j++) {
                    System.out.print(board[i][j]);
                }
                System.out.println();
            }
        }
    }
}
