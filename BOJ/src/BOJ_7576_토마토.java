import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7576_토마토 {
    static int N,M,result;
    static int[][] box;
    static int[] di = {-1,1,0,0};
    static int[] dj = {0,0,-1,1};
    static Queue<Point> q;
    static class Point{
        int point_i, point_j;

        public Point(int point_i, int point_j) {
            this.point_i = point_i;
            this.point_j = point_j;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        M = Integer.parseInt(st.nextToken()); //세로
        N = Integer.parseInt(st.nextToken()); //가로

        box = new int[N][M];
        q = new LinkedList<Point>();
        for (int i = 0; i <N; i++) {
            st = new StringTokenizer(br.readLine()," ");
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if(box[i][j] == 1){
                    //익은 토마토의 위치 저장
                    q.offer(new Point(i, j));
                }
            }
        }
        result =0;
        boolean flag = false;
        bfs();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] == 0) {
                    flag = true;
                }
            }
        }
        if (flag) {
            System.out.println(-1);
        } else {
            System.out.println(result-1);
        }

    }
    public static void bfs(){
        while(!q.isEmpty()){
            int nowi = q.peek().point_i;
            int nowj = q.peek().point_j;
            q.poll();

            for (int d = 0; d < 4; d++) {
                int nexti = nowi + di[d];
                int nextj = nowj + dj[d];

                if (nexti >= 0 && nextj >= 0 && nexti < N && nextj < M){
                    if(box[nexti][nextj] == 0){
                        box[nexti][nextj] = box[nowi][nowj] + 1;
                        q.offer(new Point(nexti, nextj));
                    }
                }
            }
            result = box[nowi][nowj];
        }
    }
}
