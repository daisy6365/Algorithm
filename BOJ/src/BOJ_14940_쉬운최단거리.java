import java.util.*;
import java.io.*;

public class BOJ_14940_쉬운최단거리 {
    static int N, M;
    static int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상 하 좌 우
    static int[][] map;
    static boolean[][] isSelected;
    static int endi, endj;

    static class Point{
        int i,j;

        public Point(int i,int j){
            this.i = i;
            this.j = j;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        isSelected = new boolean[N][M];

        for(int i =0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < M ; j++){
                int temp = Integer.parseInt(st.nextToken());
                if(temp == 2){
                    endi = i;
                    endj = j;
                }
                map[i][j] = temp;
            }
        }

        map[endi][endj] = 0;
        bfs(endi,endj);
        print();

    }

    private static void bfs(int nowi, int nowj){
        Queue<Point> q = new LinkedList<>();
        isSelected[nowi][nowj] = true;
        q.offer(new Point(nowi, nowj));

        while(!q.isEmpty()){
            Point p = q.poll();
            for(int d = 0; d< 4 ; d++){
                int nexti = p.i + direction[d][0];
                int nextj = p.j + direction[d][1];

                if(nexti >= 0 && nexti < N && nextj >= 0 && nextj < M && !isSelected[nexti][nextj] && map[nexti][nextj] != 0){
                    isSelected[nexti][nextj] = true;
                    q.offer(new Point(nexti, nextj));
                    map[nexti][nextj] += map[p.i][p.j];
                }
            }
        }
    }

    private static void print(){
        for(int i = 0; i < N ; i++){
            for(int j = 0; j < M ; j++){
                if(!isSelected[i][j] && map[i][j] != 0){
                    System.out.print(-1 + " ");
                }
                else{
                    System.out.print(map[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
