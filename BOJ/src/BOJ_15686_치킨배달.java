import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_15686_치킨배달 {
    static int N,M; //size, 뽑을 수
    static ArrayList<Point> homes;
    static ArrayList<Point> chickens;
    static boolean[] isSelected; //치킨집 뽑은 정보
    static int ans; //도시 치킨거리 최소값

    static class Point{
        int i,j;

        public Point(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        homes = new ArrayList<>();
        chickens = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int input = sc.nextInt();
                if(input == 1){ //가정집
                    homes.add(new Point(i,j));
                }
                else if(input == 2){ //치킨집
                    chickens.add(new Point(i,j));
                }
            }
        }
        ans = Integer.MAX_VALUE;
        //치킨집의 갯수만큼 배열 생성
        isSelected = new boolean[chickens.size()];
        combination(0,0);
        System.out.println(ans);
    }
    public static void combination(int idx, int cnt){
        if(cnt == M){
            int dist = 0; //현재 조합으로 도시치킨거리(모든집 치킨거리 누적)
            //뽑기 완료 -> 모든 가정집에 대해서 치킨집과의 거리 계산
            for (Point home : homes){
                int min = Integer.MAX_VALUE;
                for (int i = 0; i < chickens.size(); i++) {
                    if(isSelected[i]){
                        int tmp = Math.abs(chickens.get(i).i-home.i) + Math.abs(chickens.get(i).j-home.j);
                        min =  Math.min(tmp, min);
                    }
                }
                dist += min;
            }
            ans = Math.min(ans,dist);
            return;
        }
        if(idx == chickens.size()){
            return;
        }
        isSelected[idx] = true;
        combination(idx+1,cnt+1);
        isSelected[idx] = false;
        combination(idx+1,cnt);

    }
}
