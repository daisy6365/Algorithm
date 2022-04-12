import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17281_야구 {
    static int N, maxScore; //이닝수 , 점수
    static int[] player; //선수 순서
    static int[][] play_arr; //이닝에 따른 선수 경기 결과 저장 배열
    static boolean[] visited; // 방문 처리
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        maxScore = Integer.MIN_VALUE;
        player = new int[9];
        play_arr = new int[N][9];
        visited = new boolean[9];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for (int j = 0; j < 9; j++) {
                play_arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        game(0);
        System.out.println(maxScore);
    }
    public static void game(int idx){
        if (idx == 3) {
            game(idx + 1);
            return;
        }
        if(idx == 9){
            //마지막 경기까지 다 돌았음
            int[] hitscore = new int[4];
            int taza, score =0, outCount=0;
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                while(true){
                    taza = player[cnt];
                    switch (play_arr[i][taza]){
                        case 0 : {
                            outCount++;
                            break;
                        }
                        case 1 : {
                            score += hitscore[3];
                            hitscore[3] = hitscore[2];
                            hitscore[2] = hitscore[1];
                            hitscore[1] = 1;
                            break;
                        }
                        case 2 : {
                            score += hitscore[3] + hitscore[2];
                            hitscore[3] = hitscore[1];
                            hitscore[2] = 1;
                            hitscore[1] = 0;
                            break;
                        }
                        case 3 : {
                            score += hitscore[3] + hitscore[2] + hitscore[1];
                            hitscore[3] = 1;
                            hitscore[2] = 0;
                            hitscore[1] = 0;
                            break;
                        }
                        case 4 : {
                            score += 1 + hitscore[3] + hitscore[2] + hitscore[1];
                            hitscore[3] = 0;
                            hitscore[2] = 0;
                            hitscore[1] = 0;
                            break;
                        }
                        default:
                            break;
                    }

                    cnt = (cnt % 8) +1;
                    if(outCount == 3) break;
                }
            }
            maxScore = Math.max(maxScore,score);
        }


        for(int i = 1; i<9;i++) {
            if(!visited[i]) {
                player[idx] = i;
                visited[i] = true;
                game(idx+1);
                visited[i] = false;
            }
        }
    }
}
