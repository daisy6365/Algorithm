import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class SWEA_1954_달팽이숫자 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());

        for(int tc = 1 ; tc<=TC; tc++){
            //배열의 크기 받음
            int N = Integer.parseInt(br.readLine());

            // N X N크기의 2차원 배열 생성
            int [][] snail = new int[N][N];
            boolean[][] isSelected = new boolean[N][N];

            int r = 0;
            int c = 0;
            int size = N-1; //모양을 만들기 위해 제한 사이즈 생성
            int count = 1; // 배열에 넣을 숫자 카운트 변수

            while(size > 0){

                //위에 부분 채우기
                for (int i = 0; i < size; i++) {
                    snail[r][c] = count++;
                    c++;
                }

                //오른면 채우기
                for (int i = 0; i < size; i++) {
                    snail[r][c] = count++;
                    r++;
                }
                //아래부분 채우기
                for (int i = 0; i < size; i++) {
                    snail[r][c] = count++;
                    c--;
                }

                //왼면 채우기
                for (int i = 0; i < size; i++) {
                    snail[r][c] = count++;
                    r--;
                }


                //겉부분 채웠으면 -> 안쪽으로 넘어가게하기
                size -= 2;

                //덮어씌워지는거 방지
                r++;
                c++;
            }
            //홀수일때 한가운데에 값 넣기
            if(N % 2 ==1){
                snail[r][c] = count;
            }

            System.out.println("#"+tc+" ");
            for (int i = 0; i < snail.length; i++) {
                for (int j = 0; j < snail.length; j++) {
                    System.out.print(snail[i][j]+" ");
                }
                System.out.println();
            }
        }
    }
}