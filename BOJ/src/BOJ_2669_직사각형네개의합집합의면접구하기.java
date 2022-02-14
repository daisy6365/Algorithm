import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2669_직사각형네개의합집합의면접구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int [][] chart = new int[100][100];
        int count =0; //넓이

        for (int tc = 0; tc < 4; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int [] square = new int[4];

            for (int i = 0; i < 4; i++) {
                square[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    if((square[0]-1)<i && i<square[2] && (square[1]-1)<j && j<square[3]){
                        chart[i][j] = 1;
                    }
                }
            }
        }

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if(chart[i][j] == 1){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
