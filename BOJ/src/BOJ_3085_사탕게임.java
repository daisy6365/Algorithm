import java.util.*;
import java.io.*;

public class BOJ_3085_사탕게임 {
    static int N;
    static char[][] board;
    static int resultMax = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new char[N][N];
        StringTokenizer st;

        for(int i = 0; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            board[i] = s.toCharArray();
        }

        moveCandy();

        System.out.println(resultMax);

    }

    // 사탕 이동
    public static void moveCandy(){
        // 행
        for(int i = 0; i < N ; i++){
            for(int j = 0 ; j < N-1 ; j++){
                swap(i, j, i, j+1);

                resultMax = Math.max(saveCount(), resultMax);

                swap(i, j, i, j+1);
            }
        }

        // 열
        for(int i = 0; i < N ; i++){
            for(int j = 0 ; j < N-1 ; j++){
                swap(j, i, j+1, i);

                resultMax = Math.max(saveCount(), resultMax);

                swap(j, i, j+1, i);
            }
        }
    }

    // 사탕 갯수 세기 (최대갯수)
    private static int saveCount(){

        int max = 0;
        // 행
        for(int i = 0 ; i < N ; i++){
            int count = 1;
            for(int j = 0 ; j < N-1 ; j++){
                if(board[i][j] == board[i][j+1]){
                    count++;
                }
                else{
                    count = 1;
                }
                max = Math.max(count, max);
            }
        }


        // 열
        for(int i = 0 ; i < N ; i++){
            int count = 1;
            for(int j = 0 ; j < N-1 ; j++){
                if(board[j][i] == board[j+1][i]){
                    count++;
                }
                else{
                    count = 1;
                }
                max = Math.max(count, max);
            }
        }

        return max;
    }

    // 위치 바꾸기
    private static void swap(int i1, int j1, int i2, int j2){
        char temp = board[i1][j1];
        board[i1][j1] = board[i2][j2];
        board[i2][j2] = temp;
    }
}
