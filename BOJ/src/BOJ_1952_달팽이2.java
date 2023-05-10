import java.util.*;
import java.io.*;

public class BOJ_1952_달팽이2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // 우 하 좌 상
        int[][] map = new int[M][N];

        int count = 0;
        int last = 1;

        int i = 0, j = 0, d = 0;
        map[i][j] = 1;
        while(true){
            if(d >= 4) {
                d = 0;
            }
            int nexti = i + direction[d][0];
            int nextj = j + direction[d][1];
            if(last == N * M) break;
            if(nexti >= 0 && nexti < M && nextj >= 0 && nextj < N && map[nexti][nextj] != 1){
                // 갈수 있는 곳이라면
                map[nexti][nextj] = 1;
                i = nexti;
                j = nextj;
                last++;
            }
            else{
                // 막힌 곳이라면 -> 꺾여야한다면
                d++; // 방향 전환
                count++; // 꺾임!
            }
        }

        System.out.println(count);
    }
}
