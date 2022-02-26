import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1987_알파벳 {
    static int[] di = {-1,0,1,0};
    static int[] dj = {0,-1,0,1};
    static char[][] alpabet;
    static boolean[][] isSelected;
    static int R,C,count;
    static String record;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        alpabet = new char[R][C];
        isSelected = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for (int j = 0; j < C; j++) {
                alpabet[i][j] = s.charAt(j);
            }
        }

        //System.out.println(move(0,0));
        count =1;
        record = String.valueOf(alpabet[0][0]);
        move(0,0,record);
        System.out.println(count);
    }

    static void move(int nowi, int nowj, String record) {
        for (int i = 0; i < 4; i++) {
            int nexti = nowi + di[i];
            int nextj = nowj + dj[i];

            if(nexti >= 0 && nexti < R && nextj >=0 && nextj < C && !isSelected[nexti][nextj]){
                String s = String.valueOf(alpabet[nexti][nextj]);
                if(!record.contains(s)){
                    count = Math.max(count,record.length()+1);
                    move(nexti,nextj,record+s);
                }
            }
        }
        return;
    }
}