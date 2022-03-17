import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16918_봄버맨 {
    static int[] di = {1,-1,0,0};
    static int[] dj = {0,0,1,-1};
    static int R,C,N;
    static int[][] map;

    static class Point{
        int i,j;
        public Point(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[R][C];

        for(int i=0; i<R; i++) {
            String s = br.readLine();
            for(int j=0; j<C; j++) {
                if(s.charAt(j) == 'O'){
                    //폭탄 있음 카운트 시작
                    map[i][j] = 1;
                }
            }
        }

        //2초부터 시작!! -> 0:초기 1:그대로 2:폭탄셋팅
        for (int i = 2; i <= N; i++) {
            //폭탄 시간
            for (int r = 0; r <R ; r++) {
                for (int c = 0; c < C; c++) {
                    map[r][c]++;
                }
            }

            // 짝수 초 : 폭탄이 설치됨
            if(i%2 == 0){
                for (int r = 0; r <R ; r++) {
                    for (int c = 0; c < C; c++) {
                        if(map[r][c] == 0){
                            map[r][c]++;
                        }
                    }
                }
            }

            //홀수 초: 폭탄이 터짐
            else{
//                for (int r = 0; r <R ; r++) {
//                    for (int c = 0; c < C; c++) {
//                        if(map[r][c] == 3){
//                            boom(r,c);
//                        }
//                    }
//                }
                //bfs?
                boom();

            }
        }

        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                if(map[i][j] == 0){
                    System.out.print('.');
                }
                else System.out.print('O');
            }
            System.out.println();
        }
    }

    static void boom() {
//        map[nowi][nowj] = 0;
//        for(int i=0; i<4; i++) {
//            int nexti = nowi + di[i];
//            int nextj = nowj + dj[i];
//
//            if(nexti < 0 || nextj < 0 || nexti >= R || nextj >= C || map[nexti][nextj] == 0) continue;
//            map[nexti][nextj] = 0;
//        }

        Queue<Point> q = new LinkedList<>();
        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                if(map[i][j] >= 3){
                    q.add(new Point(i,j));
                }
            }
        }

        while(!q.isEmpty()) {
            Point now = q.poll();
            map[now.i][now.j] = 0;

            for(int i=0; i<4; i++) {
                int nexti = now.i + di[i];
                int nextj = now.j + dj[i];

                if(nexti < 0 || nextj < 0 || nexti >= R || nextj >= C || map[nexti][nextj] == 0) continue;
                map[nexti][nextj] = 0;
            }
        }
    }
}