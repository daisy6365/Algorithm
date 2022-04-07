import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_4485_녹색옷입은애가젤다지_BFS {
    static int N;
    static int[] di= { 0, -1, 0, 1 };
    static int[] dj= { 1, 0, -1, 0 };
    static int[][] map,resultsum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc =1;
        while(true) {
            N = Integer.parseInt(br.readLine());
            if(N == 0) break;

            map = new int[N][N];
            resultsum = new int[N][N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    resultsum[i][j] = Integer.MAX_VALUE;
                }
            }
            resultsum[0][0] = map[0][0];
            bfs();

            System.out.println("Problem "+tc+": "+resultsum[N-1][N-1]);
            tc++;
        }
    }
    static void bfs(){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0,0));


        while(!q.isEmpty()){
            Point now = q.poll();
            for (int k = 0; k < 4; k++) {
                int nexti = now.i + di[k];
                int nextj = now.j + dj[k];

                if(nexti >= 0 && nexti<N && nextj >=0 && nextj < N ){

                    if(map[nexti][nextj] + resultsum[now.i][now.j] < resultsum[nexti][nextj]){
                        resultsum[nexti][nextj] = resultsum[now.i][now.j] + map[nexti][nextj];

                        q.add(new Point(nexti,nextj));

                    }
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
