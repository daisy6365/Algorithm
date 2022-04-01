import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1629_곱셈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());
        long C = Integer.parseInt(st.nextToken());


        System.out.println(calculation(A, B, C));
    }
    public static long calculation(long A, long B, long C){
        if(B == 1){
            return A % C;
        }
        long div = calculation(A,B/2, C);
        if(B % 2 == 0){
            //짝수 일때
            return (div*div) % C;
        }
        else{
            //홀수 일때
            return ((div*div)% C) * A % C ;
        }
    }
}
