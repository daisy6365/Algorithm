import java.util.Scanner;

public class SWEA_2805_농작물수확하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();

        for (int tc = 1; tc <= TC; tc++) {
            int N = sc.nextInt();
            int[][] farm = new int[N][N];

            int center = N/2;


            for(int i=0;i< N;i++){
                String s = sc.next();
                for(int j=0;j< N;j++){
                    int num = s.charAt(j) - '0';
                    farm[i][j] = num;
                }
            }

            int sum = 0;
            for(int i =0; i < farm.length;i++){
                if(i == center){
                    for(int j = 0 ; j< farm.length; j++){
                        sum += farm[i][j];

                    }
                }
                else if(i<center){
                    for(int j = (center-i); j<=(center+i); j++ ){
                        sum += farm[i][j];

                    }
                }
                else if(i > center){
                    for(int j = (i-center);j<(farm.length-(i-center));j++){
                        sum += farm[i][j];
                    }
                }
            }
            System.out.println("#"+tc+" "+sum);
        }
    }
}
