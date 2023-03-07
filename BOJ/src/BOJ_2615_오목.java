import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2615_오목 {
    static int[][] board = new int[19][19];
    // 우 하 우하 우상
    static int[][] direction = {{0, 1}, {1, 0}, {1, 1}, {-1, 1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 19; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 19; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // *@*@ 이게 키 포인트. *@*@
        // 발견하려는것의 가장 왼쪽의 있는것을 확인 & 출력
        for (int j = 0; j < 19; j++) {
            for (int i = 0; i < 19; i++) {
                // 1,2를 만나면 오목 체크 (탐색)
                if(board[i][j] != 0){
                    // 오목 맞을 때
                    if(is_condition(i, j)){
                        System.out.println(board[i][j]);
                        System.out.println((i+1) + " " + (j+1));
                        return;
                    }

                }
            }
        }
        System.out.println(0);
    }

    private static boolean is_condition(int nowi, int nowj){
        for(int d = 0; d < 4; d++){
            int count = 1;
            count += check_omock(nowi, nowj, direction[d][0], direction[d][1]);
            count += check_omock(nowi, nowj, direction[d][0] * -1, direction[d][1] * -1);

            if(count == 5){
                return true;
            }
        }
        return false;
    }

    private static int check_omock(int nowi, int nowj, int di, int dj){
        int nexti = nowi + di;
        int nextj = nowj + dj;
        int count = 0;

        for(int i = 0; i < 19 ; i++){
            if(nexti >= 0 && nexti < 19 & nextj >= 0 && nextj < 19 && board[nowi][nowj] == board[nexti][nextj]){
                count++;
                nexti += di;
                nextj += dj;
            }
            else{
                return count;
            }
        }
        return count;
    }
}