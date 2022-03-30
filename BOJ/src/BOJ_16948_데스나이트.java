import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16948_데스나이트 {
    static int[] di={-2,-2,0,0,2,2};
    static int[] dj={-1,1,-2,2,-1,1};
    static int[][] board;
    static boolean[][] isSelected;
    static int N, rs, cs, rd, cd;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        board = new int[N][N];
        isSelected = new boolean[N][N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        rs = Integer.parseInt(st.nextToken()); //시작 r
        cs = Integer.parseInt(st.nextToken()); //시작 c
        rd = Integer.parseInt(st.nextToken()); //도착 r
        cd = Integer.parseInt(st.nextToken()); //도착 c


        System.out.println(bfs());
    }
    static int bfs(){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(rs,cs,0));
        isSelected[rs][cs] = true;

        while(!q.isEmpty()) {
            Point now = q.poll();
            for(int i=0; i<6; i++) {
                int nexti = now.i + di[i];
                int nextj = now.j + dj[i];

                if(nexti < 0 || nextj < 0 || nexti >= N || nextj >= N || isSelected[nexti][nextj]) continue;
                if (nexti == rd && nextj == cd) return now.count + 1;
                q.add(new Point(nexti, nextj, now.count + 1));
                isSelected[nexti][nextj] = true;
            }
        }
        return -1;
    }
    static class Point{
        int i,j,count;
        public Point(int i, int j,int count) {
            this.i = i;
            this.j = j;
            this.count = count;
        }
    }
}