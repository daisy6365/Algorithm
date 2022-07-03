import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1767_프로세서연결하기 {
    static int N,max,totalCnt,min,map[][];
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static ArrayList<int[]> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= TC; tc++) {
            N =  Integer.parseInt(br.readLine());
            map = new int[N][N];
            list = new ArrayList<>();
            max = 0;
            min = Integer.MAX_VALUE;
            totalCnt = 0;

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine()," ");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if ((i == 0 || i==N || j ==0 || j==N-1)&& map[i][j]==1) continue;
                    if(map[i][j] == 1){
                        list.add(new int[]{i,j});
                        totalCnt++;
                    }
                }
            }
            go(0,0);
            System.out.println("#" + tc + " " + min);
        }
    }
    static void go(int idx, int cCnt){
        if(idx == totalCnt){
            int res = getLength();
            if(max < cCnt){
                max = cCnt;
                min = res;
            }
            else if(max == cCnt){
                if(min > res) min = res;
            }
            return;
        }

        int[] core = list.get(idx);
        int r= core[0];
        int c = core[1];

        for (int d = 0; d < 4; d++) {
            if(isAvailable(r,c,d)){
                setStatus(r,c,d,2);
                go(idx+1,cCnt+1);
                setStatus(r,c,d,0);
            }
        }
        go(idx+1,cCnt);
    }
    static boolean isAvailable(int r, int c, int d){
        int nr = r, nc = c;
        while(true){
            nr += dr[d];
            nc += dc[d];
            if(nr < 0 || nr>=N || nc<0 || nc >= N) break;
            if(map[nr][nc]>=1) return false;
        }
        return true;
    }

    static void setStatus(int r, int c, int d, int s){
        int nr = r, nc = c;
        while (true){
            nr += dr[d];
            nc += dc[d];
            if(nr < 0 || nr>=N || nc<0 || nc >= N) break;
            map[nr][nc] = s;
        }
    }
    static int getLength(){
        int lCnt = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if(map[r][c] == 2) lCnt++;
            }
        }
        return lCnt;
    }
}
