import java.util.Scanner;

public class SWEA_1954_달팽이숫자 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();

        for(int tc = 1 ; tc<=TC;tc++){
            int N = sc.nextInt();
            int [][] snail = new int[N][N];

            int r = 0;
            int c = 0;
            int count = 1;
            int size = N-1;

            while (size > 0) {
                for (int i =0;i< size;i++){
                    snail[r][c] = count++;
                    c++;
                }
                for (int i =0;i< size;i++){
                    snail[r][c] = count++;
                    r++;
                }
                for (int i =0;i< size;i++){
                    snail[r][c] = count++;
                    c--;
                }
                for (int i =0;i< size;i++){
                    snail[r][c] = count++;
                    r--;
                }
                //겉부분 채웠으면 -> 안쪽으로 넘어가게하기
                size -= 2;

                //덮어씌워지는거 방지
                r++;
                c++;

            }

            //홀수 일때 -> 한가운데 숫자 적기
            if (N % 2 != 0) {
                snail[r][c] = count;
            }

            System.out.println("#"+tc);
            for(int i =0; i< snail.length;i++){
                for(int j =0;j< snail.length;j++){
                    System.out.print(snail[i][j]+" ");
                }
                System.out.println();
            }
        }
    }
}
