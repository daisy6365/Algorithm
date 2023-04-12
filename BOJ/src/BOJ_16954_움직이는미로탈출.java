import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_16954_움직이는미로탈출 {
    static class Point{
        int i, j;
        public Point(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
    static char[][] board;
    static int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {-1, -1}, {-1, 1}, {1, -1}, {0, 0}};
    // { {-1, 1}, {-1, 0}, {0, 1}, {-1, -1}, {0, -1}};
    public static void main(String[] args) throws IOException  {
        Scanner sc = new Scanner(System.in);
        board = new char[8][8];

        for (int i = 0; i < 8; i++) {
            board[i] = sc.nextLine().toCharArray();
        }

        if(bfs(7, 0)){
            System.out.println(1);
        }
        else{
            System.out.println(0);
        }
    }
    private static boolean bfs(int nowi, int nowj) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(nowi, nowj));

        while(!queue.isEmpty()){
            int s = queue.size();
            for (int i = 0; i < s; i++) {
                Point p = queue.poll();

                // 가야할곳에 현재 벽이있음 -> 다음 방향
                if(checkWall(p.i, p.j)) continue;
                for (int d = 0; d < 9; d++) {
                    int nexti  = p.i + direction[d][0];
                    int nextj  = p.j + direction[d][1];

                    // 갈수 있는 곳인지 확인
                    if(!checkGo(nexti, nextj)) continue; // 갈수 없음 -> 다음방향

                    // 현재 벽도 없고 1초후에 벽도 안생김 갈 수 있음
                    if(nexti == 0 && nextj == 7) return true;

                    // 가야할곳에 1초후에 역시 있음 -> 다음 방향
                    if(!checkWall(nexti, nextj)) {
                        queue.add(new Point(nexti, nextj));
                    }
                }
            }
            // 벽 이동
            moveWall();
        }
        return false;
    }
    
    // 가야할곳에 현재 벽이 있는지
    private static boolean checkWall(int nexti, int nextj){
        if(board[nexti][nextj] == '#') return true;
        return false;
    }

    // 찐 벽인지 확인
    private static boolean checkGo(int nexti, int nextj){
        if(nexti < 0 || nexti >= 8 || nextj < 0 || nextj >= 8) return false;
        return true;
    }
    
    // 1초후 벽 이동
    private static void moveWall(){
        for (int i = 6; i >= 0; i--) {
            for (int j = 0; j < 8; j++) {
                board[i + 1][j] = board[i][j];
            }
        }
        for (int i = 0; i < 8; i++) {
            board[0][i] = '.';
        }
    }
}
