import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class IM {
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());//테스트 케이스

//		int[] di = {-1,1,0,0};
//		int[] dj = {0,0,-1,1};

        for(int tc =1;tc<=TC;tc++) {
            int N = Integer.parseInt(br.readLine()); //map 크기
            int[][] map = new int[N][N]; //크기만큼 지도 배열 생성
            int count =0;

            int guard_i=0, guard_j=0;
            for(int i =0; i<N;i++) {
                StringTokenizer st = new StringTokenizer(br.readLine()," ");
                for(int j =0; j<N;j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if(map[i][j] == 2) {
                        guard_i = i;
                        guard_j = j;
                    }
                }
            }

            //상 : 열바뀜 행고정
            for (int i = guard_i; i > 0 ; i--){
                if(map[i][guard_j] == 0){
                    map[i][guard_j] = 2;
                }
                if(map[i][guard_j] == 1){
                    break;
                }
            }

            //하 : 열바뀜 행고정
            for (int i = guard_i; i < N ; i++) {
                if(map[i][guard_j] == 0){
                    map[i][guard_j] = 2;
                }
                if(map[i][guard_j] == 1){
                    break;
                }
            }

            //좌 : 열고정 행바뀜
            for (int j = guard_j; j > 0 ; j--){
                if(map[guard_i][j] == 0){
                    map[guard_i][j] = 2;
                }
                if(map[guard_i][j] == 1){
                    break;
                }
            }

            //우 : 열고정 행바뀜
            for (int j = guard_j; j < N ; j++) {
                if(map[guard_i][j] == 0){
                    map[guard_i][j] = 2;
                }
                if(map[guard_i][j] == 1){
                    break;
                }
            }



            for(int i =0; i<N;i++) {
                for(int j =0; j<N;j++) {
                    System.out.print(map[i][j]);
                    if(map[i][j] == 0) {
                        count++;
                    }
                }
                System.out.println();
            }
            System.out.println("#"+tc+" "+count);

        }//end TC
    }
}

