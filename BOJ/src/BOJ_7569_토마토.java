import java.io.*;
import java.util.*;

public class BOJ_7569_토마토 {
    static Queue<Point> queue = new LinkedList<>();
    static int[][] direction = new int[][]{{-1, 0, 0}, {1, 0, 0}, {0, -1, 0}, {0, 1, 0}, {0, 0, 1}, {0, 0, -1}};;
    static int M, N, H;
    static int[][][] boxes;
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); // 가로
        N = Integer.parseInt(st.nextToken()); // 세로
        H = Integer.parseInt(st.nextToken()); // 높이
        boxes = new int[H][N][M];

        for (int i = 0; i < H ; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    boxes[i][j][k] = Integer.parseInt(st.nextToken());
                    if(boxes[i][j][k] == 1){
                        queue.offer(new Point(i, j, k));
                    }
                }
            }
        }
        bfs();
        System.out.println(saveDay());

    }
    private static void bfs(){
        while(!queue.isEmpty()){
            Point p = queue.poll();
            for (int d = 0; d < 6; d++) {
                int next_i = p.i + direction[d][0];
                int next_j = p.j + direction[d][1];
                int next_k = p.k + direction[d][2];

                if(next_i >= 0 && next_i < H && next_j >= 0 && next_j < N && next_k >= 0 && next_k < M && boxes[next_i][next_j][next_k] == 0){
                    queue.offer(new Point(next_i, next_j, next_k));
                    boxes[next_i][next_j][next_k] = boxes[p.i][p.j][p.k] + 1;
                }
            }

        }
    }

    private static int saveDay(){
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if(boxes[i][j][k] == 0){
                        return -1;
                    }
                    else{
                        max = Math.max(max, boxes[i][j][k]);
                    }
                }
            }
        }

        if(max == 1) return 0;
        else return max-1;
    }

    static class Point{
        int i, j, k;

        public Point(int i, int j, int k) {
            this.i = i;
            this.j = j;
            this.k = k;
        }
    }
}
