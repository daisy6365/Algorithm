import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1592_영식이와친구들 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken()); //총 명수
        int M = Integer.parseInt(st.nextToken()); //M번째에 게임 끝
        int L = Integer.parseInt(st.nextToken()); //L번째 사람에게 공 넘김

        int[] arr = new int[N+1]; //사람들이 공을 받은 횟수 저장
        int nowBall = 1; //공을 갖고있는 사람번호 (초기화)
        int count=0;

        arr[nowBall] = 1;
        while(true){
            if(arr[nowBall] == M) break;
            if(arr[nowBall] % 2 != 0){
                //받은 횟수홀수 일때
                nowBall = nowBall + L;}
            else{
                nowBall = nowBall - L;}

            if(nowBall > N) nowBall %= N;
            else if(nowBall < 1) nowBall +=N;
            arr[nowBall]++;
            count++;
        }

        System.out.println(count);
    }
}
