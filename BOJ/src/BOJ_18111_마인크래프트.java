import java.util.*;
import java.io.*;

public class BOJ_18111_마인크래프트 {
    static int N, M, B;
    static int[][] map;
    static int min = 256;
    static int max = 0;
    static int time = Integer.MAX_VALUE;
    static int height = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 행
        M = Integer.parseInt(st.nextToken()); // 열
        B = Integer.parseInt(st.nextToken()); // 인벤토리 저장된 땅
        map = new int[N][M];

        for(int i = 0; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                // 땅의 최소 높이와 최대높이를 구함
                min = Math.min(min, map[i][j]);
                max = Math.max(max, map[i][j]);
            }
        }

        minecraft();

        System.out.println(time + " " + height);

    }

    private static void minecraft(){
        // 땅을 최소부터 최대까지 만들 수 있음
        // 최대를 만들때에는 인벤토리에 저장된 땅의 수 생각하기

        for(int i = min ; i <= max ; i++){
            int timeT = 0; // 땅 1번 고르는데 걸리는 시간
            int block = B; // 땅 고르기 시작할때마다 땅의 수 초기화

            for(int j = 0 ; j < N ; j++){
                for(int k = 0; k < M ; k++){
                    if(map[j][k] > i){
                        // 땅 제거해서 인벤토리에 저장
                        timeT += (map[j][k] - i) * 2; // 시간
                        block += (map[j][k] - i);
                    }
                    else {
                        // 인벤토리에 꺼내서 땅 쌓기
                        timeT += (i - map[j][k]); // 시간
                        block -= (i - map[j][k]);

                    }
                }
            }
            if(block < 0) break; // 음수 이면 종료
            if(time >= timeT){
                // 최소시간 갱신
                time = timeT;
                height = i; // 어차피 최소부터 최대까지 반복문 돎
            }
        }
    }
}
