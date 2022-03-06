import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_14889_스타트와링크 {
    static int N,min;
    static int[][] skills;
    static boolean[] isSelected;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        skills = new int[N][N];
        isSelected = new boolean[N];
        min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            StringTokenizer st= new StringTokenizer(br.readLine()," ");
            for (int j = 0; j < N; j++) {
                skills[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        soccer(0,0);
        System.out.println(min);
    }
    public static void soccer(int idx, int start){
        if(idx == N/2){
            System.out.println(Arrays.toString(isSelected));
            int startTeam=0, linkTeam =0;
            for (int i = 0; i < N-1; i++) {
                for (int j = i+1; j < N; j++) {
                    if(isSelected[i] && isSelected[j]){
                        startTeam += skills[i][j] + skills[j][i];
                    }
                    if(!isSelected[i] && !isSelected[j]){
                        linkTeam += skills[i][j] + skills[j][i];
                    }
                }
                
            }
            int result = Math.abs(startTeam-linkTeam);
            min = Math.min(min,result);
            return;
        }
        for (int i = start; i < N; i++) {
            isSelected[i] = true;
            soccer(idx+1,i+1);
            isSelected[i] = false;
        }
    }
}
