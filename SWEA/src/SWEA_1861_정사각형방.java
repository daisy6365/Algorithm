import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1861_정사각형방 {
    static int [] di = {-1,0,1,0}; //U,L,D,R
    static int [] dj = {0,-1,0,1};
    static int N;
    static int [][] room;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <=TC; tc++) {
            N = Integer.parseInt(br.readLine());
            int result_num =Integer.MAX_VALUE;
            int move_max = 0;

            room = new int[N][N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    room[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int val = room_DFS(i, j);
                    if (move_max < val || move_max == val&&result_num>room[i][j]) {
                        move_max = val;
                        result_num = room[i][j];
                    }
                }
            }

            System.out.println("#"+tc+" "+result_num+" "+move_max);
        }
    }

     static int room_DFS(int x, int y){
        for (int i = 0; i < 4; i++) {
            int nextx = x + di[i];
            int nexty = y + dj[i];

            //if(nexti<0 || nexti>4 || nextj <0 || nextj>4 || visit[nexti][nextj] || map[nexti][nextj]==1) continue;
            //다른 방향으로 감

            if( nextx>=0 && nextx<N && nexty>=0 && nexty<N && room[nextx][nexty] == (room[x][y]+1)){
                //continue되지 않았을때
                //move += 1;
                return room_DFS(nextx,nexty)+1;
            }

        }
        return 1;
    }
}
