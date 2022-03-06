import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2605_줄세우기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //학생수
        Stack<Integer> studentNum = new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(st.nextToken());
            studentNum.add(num,i);
        }
        for (int i = 0; i < N; i++) {
            System.out.print(studentNum.pop()+" ");
        }
    }
}
