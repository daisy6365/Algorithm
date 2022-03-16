import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_18512_점프점프 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int startX = Integer.parseInt(st.nextToken());
        int startY = Integer.parseInt(st.nextToken());

        int result = Math.abs(startX-startY);

        if(startX == startY){
            System.out.println(startX);
            return;
        }

        List<Integer> arrX = new ArrayList<>();
        List<Integer> arrY = new ArrayList<>();

        for (int i = 0; i < 10000; i++) {
            arrX.add(startX);
            arrY.add(startY);

            startX += X;
            startY += Y;
        }

        for (int i = 0; i < 1000; i++) {
            if(arrX.contains(arrY.get(i))){
                System.out.println(arrY.get(i));
                return;
            }
        }
        System.out.println(-1);
    }
}
