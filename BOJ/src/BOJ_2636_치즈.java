import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2636_치즈 {
    static int[] di = {-1, 0, 0, 1};
    static int[] dj = {0, -1, 1, 0};
    static int[][] map;
    static int R,C,count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine()," ");
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1){
                    count++;
                }
            }
        }

        int time =0;
        int remainCount =0;
        while(count != 0){
            time++;
            remainCount = count;
            bfs(0,0);
        }

        System.out.println(time);
        System.out.println(remainCount);
    }

    public static void bfs(int i, int j){
        Queue<Point> q = new LinkedList<>();
        boolean[][] isSelected = new boolean[R][C];
        isSelected[i][j] = true;
        q.offer(new Point(i,j));

        while(!q.isEmpty()){
            Point now = q.poll();

            for (int k = 0; k < 4; k++) {
                int nexti = now.i + di[k];
                int nextj = now.j + dj[k];

                if(nexti >= 0 && nexti < R && nextj>=0 && nextj < C && !isSelected[nexti][nextj]){
                    if(map[nexti][nextj] == 1) {
                        map[nexti][nextj] = 0;
                        count--;
                    }
                    else{
                        q.offer(new Point(nexti,nextj));
                    }
                    isSelected[nexti][nextj] = true;
                }

            }
        }

    }

    static class Point{
        int i,j;
        public Point(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
