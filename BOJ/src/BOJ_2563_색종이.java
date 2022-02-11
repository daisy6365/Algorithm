import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2563_색종이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int area = 100;
        int [][] paper = new int[N][4];
        int [][] visit = new int[area][area];
        int count=0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x= Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            paper[i][0] = x-1;
            paper[i][1] = y-1;
            paper[i][2] = x+10;
            paper[i][3] = y+10;
        }


        for (int i = 0; i < area; i++) {
            for (int j = 0; j < area; j++) {
                for (int k = 0; k < N; k++) {
                    if(paper[k][0]<i && paper[k][1]<j && i<paper[k][2] && j<paper[k][3]){
                        visit[i][j] = 1;
                    }
                }
            }
        }
        for (int i = 0; i < area; i++) {
            for (int j = 0; j < area; j++) {
                if(visit[i][j] == 1){
                   count += 1;
                }
            }
        }

        System.out.println(count);
    }
}
