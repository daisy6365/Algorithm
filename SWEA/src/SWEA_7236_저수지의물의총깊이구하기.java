import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_7236_저수지의물의총깊이구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());//테스트케이스 수
        int[] di = {-1, -1, -1, 0, 1, 1, 1, 0}; //8방 탐색
        int[] dj = {-1, 0, 1, 1, 1, 0, -1, -1}; //8방 탐색

        for (int tc = 1; tc <= TC; tc++) {
            int N =   Integer.parseInt(br.readLine());//저수지의 크기 N X N
            char[][] map = new char[N][N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine()," ");
                for (int j = 0; j < N; j++) {
                    //배열에 값 넣기
                    map[i][j] = st.nextToken().charAt(0);
                }
            }

            int maxCount = Integer.MIN_VALUE; //저수지의 최대깊이 넣을 변수
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(map[i][j] == 'G') continue; //물이 아니면 넘기기
                    int count = 0; //주변의 W갯수 count할 변수
                    for (int d = 0; d < 8; d++) { //8방 탐색 시작
                        int nexti = i + di[d];
                        int nextj = j + dj[d];

                        if(nexti>=0 && nexti<N && nextj>=0 && nextj<N && map[nexti][nextj] == 'W') {
                            count++;
                        }
                    }
                    maxCount = Math.max(maxCount,count);

                }
            }
            if(maxCount == 0){
                //최대값이 0 -> w를 감싸는 곳이 모두 G임
                System.out.println("#"+tc+" "+1);
            }
            else{
                System.out.println("#"+tc+" "+maxCount);
            }
        }
    }
}