import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3109_빵집_Boolean {
    static char map[][];
    static int R,C,count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            String s= st.nextToken();
            for (int j = 0; j < C; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < R; i++) {
            if(pipe(i,0)){
                count++;
            }
        }
        System.out.println(count);
    }
    public static boolean pipe(int nowi, int nowj){
        map[nowi][nowj] = '@';
        //빵집에 도착
        if(nowj == C-1){
            return true;
        }

        //오른쪽에 방해물이 있다면 -> 차후 순위인 오른쪽위로 감
        if(nowi >0 && map[nowi-1][nowj+1] == '.'){
            if(pipe(nowi-1,nowj+1)) return true;
        }

        //빵집을 향해 감 -> 일단 오른쪽
        if(map[nowi][nowj+1] == '.'){
            if(pipe(nowi,nowj+1)) return true;
            //오른쪽에 방해물이 없다면
        }

        //오른쪽 아래로 감
        if((nowi+1) < R && map[nowi+1][nowj+1] == '.'){
            if(pipe(nowi+1,nowj+1))return true;
        }
        return false;
    }
}
