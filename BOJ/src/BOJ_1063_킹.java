import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1063_킹 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int king_col = 0; // 킹의 행 위치
        int king_row = 0; // 킹의 열 위치
        int rock_col = 0; // 돌의 행 위치
        int rock_row = 0; // 돌의 열 위치
        String[][] board = { // 체스판
                {"A8", "B8", "C8", "D8", "E8", "F8", "G8", "H8"},
                {"A7", "B7", "C7", "D7", "E7", "F7", "G7", "H7"},
                {"A6", "B6", "C6", "D6", "E6", "F6", "G6", "H6"},
                {"A5", "B5", "C5", "D5", "E5", "F5", "G5", "H5"},
                {"A4", "B4", "C4", "D4", "E4", "F4", "G4", "H4"},
                {"A3", "B3", "C3", "D3", "E3", "F3", "G3", "H3"},
                {"A2", "B2", "C2", "D2", "E2", "F2", "G2", "H2"},
                {"A1", "B1", "C1", "D1", "E1", "F1", "G1", "H1"},
        };

        String king = st.nextToken();
        String rock = st.nextToken();
        int N = Integer.parseInt(st.nextToken());
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j].equals(king)) {
                    king_col = i;
                    king_row = j;
                } else if (board[i][j].equals(rock)) {
                    rock_col = i;
                    rock_row = j;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            String move = br.readLine();

            switch (move) {
                case "R": { // row + 1
                    // 킹이 가야할 곳이 돌의 위치랑 같은지 확인
                    if(position_check(king_col, king_row + 1, rock_col, rock_row)){
                        // 같이 움직여야함

                        // 돌이 갈 수 있는 곳인지 확인
                        if(board_check(rock_col, rock_row + 1)){
                            // 둘 다 움직여
                            king_row++;
                            rock_row++;
                        }
                        else{
                            // 넘어가
                            break;
                        }

                    }
                    else {
                        // 킹만 움직여

                        // 킹이 갈 수 있는 곳인지 확인
                        if(board_check(king_col, king_row + 1)){
                            // 움직여
                            king_row++;
                        }
                        else {
                            // 넘어가
                            break;
                        }
                    }
                    break;
                }
                case "L": { // row - 1
                    if(position_check(king_col, king_row - 1, rock_col, rock_row)){
                        if(board_check(rock_col, rock_row - 1)){
                            king_row--;
                            rock_row--;
                        }
                        else{
                            break;
                        }
                    }
                    else {
                        if(board_check(king_col, king_row - 1)){
                            king_row--;
                        }
                        else {
                            break;
                        }
                    }
                    break;
                }
                case "B": { // col + 1
                    if(position_check(king_col + 1, king_row, rock_col, rock_row)){
                        if(board_check(rock_col + 1, rock_row)){
                            king_col++;
                            rock_col++;
                        }
                        else{
                            break;
                        }
                    }
                    else {
                        if(board_check(king_col + 1, king_row)){
                            king_col++;
                        }
                        else {
                            break;
                        }
                    }
                    break;

                }
                case "T": { // col - 1
                    if(position_check(king_col - 1, king_row, rock_col, rock_row)){
                        if(board_check(rock_col - 1, rock_row)){
                            king_col--;
                            rock_col--;
                        }
                        else{
                            break;
                        }
                    }
                    else {
                        if(board_check(king_col - 1, king_row)){
                            king_col--;
                        }
                        else {
                            break;
                        }
                    }
                    break;
                }
                case "RT": { // col - 1, row + 1
                    if(position_check(king_col - 1, king_row + 1, rock_col, rock_row)){
                        if(board_check(rock_col - 1, rock_row + 1)){
                            king_col--;
                            king_row++;
                            rock_col--;
                            rock_row++;
                        }
                        else{
                            break;
                        }
                    }
                    else {
                        if(board_check(king_col - 1, king_row + 1)){
                            king_col--;
                            king_row++;
                        }
                        else {
                            break;
                        }
                    }
                    break;
                }
                case "LT": { // col - 1, row - 1
                    if(position_check(king_col - 1, king_row - 1, rock_col, rock_row)){
                        if(board_check(rock_col - 1, rock_row - 1)){
                            king_col--;
                            king_row--;
                            rock_col--;
                            rock_row--;
                        }
                        else{
                            break;
                        }
                    }
                    else {
                        if(board_check(king_col - 1, king_row - 1)){
                            king_col--;
                            king_row--;
                        }
                        else {
                            break;
                        }
                    }
                    break;
                }
                case "RB": { // col + 1, row + 1
                    if(position_check(king_col + 1, king_row + 1, rock_col, rock_row)){
                        if(board_check(rock_col + 1, rock_row + 1)){
                            king_col++;
                            king_row++;
                            rock_col++;
                            rock_row++;
                        }
                        else{
                            break;
                        }
                    }
                    else {
                        if(board_check(king_col + 1, king_row + 1)){
                            king_col++;
                            king_row++;
                        }
                        else {
                            break;
                        }
                    }
                    break;
                }
                case "LB": { // col + 1, row - 1
                    if(position_check(king_col + 1, king_row - 1, rock_col, rock_row)){
                        if(board_check(rock_col + 1, rock_row - 1)){
                            king_col++;
                            king_row--;
                            rock_col++;
                            rock_row--;
                        }
                        else{
                            break;
                        }
                    }
                    else {
                        if(board_check(king_col + 1, king_row - 1)){
                            king_col++;
                            king_row--;
                        }
                        else {
                            break;
                        }
                    }
                    break;
                }
            }
        }

        System.out.println(board[king_col][king_row]);
        System.out.println(board[rock_col][rock_row]);
    }

    // 킹의 다음 행선지가 돌의 위치랑 같은지 확인 -> true면 같은 위치 (돌도 같이 움직여야함), false면 다른 위치 (킹만 움직임)
    public static boolean position_check(int king_col, int king_row, int rock_col, int rock_row){
        boolean position_check = false;

        if((king_col == rock_col) && (king_row == rock_row)){
            position_check = true;
        }

        return position_check;
    }

    // 체스판의 끝인지 확인 -> true면 갈 수 있음, false면 밖으로 나가서 못감
    public static boolean board_check(int col, int row){
        boolean move_check = false;

        // (col >= 0 && row >= 0 && col < 8 && row < 8)
        if (col >= 0 && row >= 0 && col < 8 && row < 8){
            move_check = true;
        }
        return move_check;
    }
}
