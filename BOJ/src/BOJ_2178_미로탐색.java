import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 처음엔 count변수를 두고 최적의 경우의 수를 셌지만
 * 오만걸 다 count++해서 map[i][j]의 칸마다 +1 하도록 구현함
 * [결과]
 * map[N][M]에는 최소의 칸수만 계산 됨
 **/
public class BOJ_2178_미로탐색 {
    static int N, M;
    static int[][] map;
    static int[][] direction = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}}; // 하 우 상 좌
    static boolean[][] isSelected;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N+1][M+1];
        isSelected = new boolean[N+1][M+1];

        for (int i = 1; i <= N; i++) {
            String s = br.readLine();
            for (int j = 1; j <= M; j++) {
                map[i][j] = s.charAt(j-1) - '0';
            }
        }

        bfs();
        System.out.println(map[N][M]);
    }
    private static void bfs(){
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(1, 1));
        isSelected[1][1] = true;

        while(!queue.isEmpty()){
            Point now = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nexti = now.i + direction[d][0];
                int nextj = now.j + direction[d][1];

                if(nexti >= 1 && nexti <= N && nextj >= 1 && nextj <= M && !isSelected[nexti][nextj] && map[nexti][nextj] == 1) {
                    queue.add(new Point(nexti, nextj));
                    isSelected[nexti][nextj] = true;
                    map[nexti][nextj] = map[now.i][now.j] + 1;
                }
            }
        }

        return;
    }

    static class Point{
        int i,j;
        public Point(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
