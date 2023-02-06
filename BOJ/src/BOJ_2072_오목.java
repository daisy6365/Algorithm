import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2072_오목 {
    static char[][] board = new char[19][19];
    static int[][] direction = {{0, 1}, {1, 0}, {1, -1}, {1, 1}}; // -> 1, -1을 곱해야 양방 탐색
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int i = 0;
        for (i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()); // " " 없어도 됨
            int col = Integer.parseInt(st.nextToken()) - 1; // N수 돌의 행 위치
            int row = Integer.parseInt(st.nextToken()) - 1; // N수 돌의 열 위치
            // 해당위치에 돌 넣기
            board[col][row] = (i % 2 == 1) ? 'B' : 'W';

            // 1 2 5 3 4 순서라면? 돌을 두자마자 오목인지 확인 함
            // 오목 확인 -> direction대로 탐색
            if(isCondition(col, row)){
                // 오목 -> 끝냄
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);
    }

    // 오목 조건 완성 되는지 체크
    private static boolean isCondition(int i, int j){
        for (int d = 0; d < 4; d++) {
            int count = 1; // 자기자신 포함
            // 조건 만족된 갯수들을 총 카운트에 더함
            count += isCheck(i, j, direction[d][0], direction[d][1]); // 우, 하, 좌하, 우하
            count += isCheck(i, j, direction[d][0] * -1, direction[d][1] * -1); // 좌, 상, 우상, 좌상

            // 딱 5개
            if (count == 5) {
                return true;
            }
        }
        return false;
    }

    // 그 다음 방향으로 갈수 있고, 같은 색인지 확인
    private static int isCheck(int i, int j , int di, int dj){
        int nexti = i + di;
        int nextj = j + dj;
        // 조건 만족일때 카운트
        int count = 0;

        for (int k = 0; k < 19; k++) {
            // 갈수 있음
            if (nexti >= 0 && nexti < 19 & nextj >= 0 && nextj < 19 && board[nexti][nextj] == board[i][j]) {
                count++;
                // 한칸 또감
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
