import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SWEA_5215_햄버거다이어트 {
    static int N;
    static int L;
    static int[][] list;
    static boolean[] selected;
    static int result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();

        for(int tc = 1; tc<=TC;tc++){
            N = sc.nextInt(); // 재료 갯수
            L = sc.nextInt(); // 제한 칼로리
            list = new int[N][2];
            for(int i=0;i<N;i++){
                list[i][0] = sc.nextInt();
                list[i][1] = sc.nextInt();
            }
            result = 0;
            selected = new boolean[N];
            hamburger(0);
            System.out.println("#"+tc+" "+result);
        }
    }

    static void hamburger(int cnt){
        if(cnt == N){
            int sum_scores=0;
            int sum_calories=0;
            for(int i =0; i< N;i++){
                if(selected[i]){
                    sum_scores += list[i][0];
                    sum_calories += list[i][1];
                }
                if(sum_calories <= L){result = Math.max(sum_scores,result);}
                else{return;}
            }
        }
        else{
            selected[cnt] = true;
            hamburger(cnt+1);

            selected[cnt] = false;
            hamburger(cnt+1);
        }
    }
}

//스택구조
