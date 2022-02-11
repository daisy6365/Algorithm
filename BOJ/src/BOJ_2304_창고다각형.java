import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2304_창고다각형 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int left_area=0;
        int right_area=0;
        int total_area =0;
        int start =1000;
        int end = 0;
        int top_y =0;


        int[][] charts = new int[N][2];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            charts[i][0] = x;
            charts[i][1] = y;

            //지붕 시작
            start = Math.min(x,start);
            //자붕 끝
            end = Math.max(x,end);
            //지붕의 제일 높은 곳
            top_y = Math.max(y,top_y);
        }
        total_area = ((end+1)-start) * top_y;

        //x좌표기준으로 정렬
        Arrays.sort(charts, Comparator.comparingInt(o1 -> o1[0]));
        int top_x =0;
        //제일 높은길이의 x위치 찾기
        for(int i=0; i<N;i++){
            if(charts[i][1] == top_y){
                top_x = i;
            }
        }
        //제일 높은곳 x의 왼쪽
        int n=0;
        while(true){
            for(int i =0; i<=top_x;i++){
                if(charts[n][1] < charts[i][1]){
                    int width=charts[i][0]-charts[0][0];
                    int height=charts[i][1]-charts[n][1];
                    left_area += width * height;
                    n = i;
                    break;
                }
            }

            if(n >= top_x){break;}
        }

        //제일 높은곳 x의 오른쪽
        int m=N-1;
        while(true){
            for(int i=N-1;i>top_x;i--){
                if(charts[m][1] < charts[i][1]){
                    int width=charts[N-1][0]-charts[i][0];
                    int height=charts[i][1]-charts[m][1];
                    right_area += width * height;
                    m = i;
                    break;
                }
            }
            if(m >= top_x){break;}
        }
        System.out.println(total_area-left_area-right_area);
    }
}
