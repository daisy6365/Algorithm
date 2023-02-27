import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 다시 풀이
public class BOJ_14889_스타트와링크 {
    static int N;
    static int[][] map;
    static int min = Integer.MAX_VALUE;
    static boolean[] isSelected;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        isSelected = new boolean[N];

        // 스타트링크 정보 받음
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 재귀 탐색 시작
        startlinkMinValue(0 , 0);
        System.out.println(min);
    }

    private static void startlinkMinValue(int idx, int start){
        // 절반 -> 절반만 탐색할거잖어
        if(idx == N/2){
            int startTeam=0, linkTeam =0;
            for (int i = 0; i < N-1; i++) {
                for (int j = i+1; j < N; j++) {
                    if(isSelected[i] && isSelected[j]){
                        startTeam += map[i][j] + map[j][i];
                    }
                    if(!isSelected[i] && !isSelected[j]){
                        linkTeam += map[i][j] + map[j][i];
                    }
                }

            }
            int result = Math.abs(startTeam-linkTeam);
            min = Math.min(min,result);
            return;
        }

        for (int i = start; i < N; i++) {
            isSelected[i] = true;
            startlinkMinValue(idx + 1, i + 1);
            isSelected[i] = false;
        }
    }
}