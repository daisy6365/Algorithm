import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class SWEA_1247_최적경로 {
    static int N, sum;
    static int company[];
    static int home[];
    static int[][] client;
    static boolean[] isSelected;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= TC; tc++) {
            N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine()," ");

            company = new int[2];
            home = new int[2];
            client = new int[N][2];
            isSelected = new boolean[N];
            sum=0;

            company[0] = Integer.parseInt(st.nextToken());
            company[1] = Integer.parseInt(st.nextToken());
            home[0] = Integer.parseInt(st.nextToken());
            home[1] = Integer.parseInt(st.nextToken());
            for (int i = 0; i < N; i++) {
                client[i][0] = Integer.parseInt(st.nextToken());
                client[i][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(client,Comparator.comparingInt(o1 -> o1[0]));

            minRoute(0);
            System.out.println(sum);
        }
    }
    public static void minRoute(int idx){
        if(idx == N){
            return;
        }
        else{
            for (int i = idx; i < N; i++) {
                if(!isSelected[i]){
                    isSelected[i] = true;
                    //제일 가까운거리 -> 회사와 거리계산
                    if(i == 0){
                        sum += Math.abs(company[0]-client[i][0]) + Math.abs(company[1]-client[i][1]);
                        minRoute(i+1);
                    }
                    //제일 먼거리 -> 집과 거리계산
                    if(i == N-1){
                        sum += Math.abs(home[0]-client[i][0]) + Math.abs(home[1]-client[i][1]);
                        minRoute(i+1);
                    }
                    else{
                        sum += Math.abs(client[i+1][0]-client[i][0]) + Math.abs(client[i+1][1]-client[i][1]);
                        minRoute(i+1);
                    }
                    System.out.println(sum+" i : "+ i);
                }
            }
        }
    }
}
