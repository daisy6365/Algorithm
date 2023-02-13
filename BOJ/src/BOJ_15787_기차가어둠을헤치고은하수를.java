import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// 비트마스킹
/*
* x << y : x의 각 비트를 y만큼 왼쪽으로 이동, 오른쪽 빈자리 = 0
* x >> y : x의 각 비트를 y만큼 오른쪽으로 이동, 왼쪽 빈자리 = x의 최상위 부호비트와 같음
* x >>> y : x의 각 비트를 y만큼 오른쪽으로 이동, 왼쪽 빈자리 = 0
* 원소 추가	A |= (1 << k);	k번째 비트 켜기
* 원소 삭제	A &= ~(1 << k);	k번째 비트 끄기
*
* 비트 논리 연산자
* &	AND	-> 두 비트 모두 1이면 1
* |	OR	-> 두 비트 중 1개만 1이면 1
* ^	XOR -> 두 비트가 서로 다르면 1
* ~	NOT -> 비트 반전(보수)
* */
public class BOJ_15787_기차가어둠을헤치고은하수를 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] train_seats = new int[N+1];
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int i = Integer.parseInt(st.nextToken());

            if(command == 1){
                // i번째 기차 x번좌석에 탑승
                int x = Integer.parseInt(st.nextToken()) - 1;
                train_seats[i] |= (1 << x);
            }
            else if(command == 2){
                // i번째 기차 x번좌석에 하차
                int x = Integer.parseInt(st.nextToken()) - 1;
                train_seats[i] &= ~(1 << x);
            }
            else if(command == 3){
                // i번째 기차 좌석 K+1
                // 20번째 하차
                train_seats[i] = train_seats[i] << 1;
                train_seats[i] &= ~(1 << 20);
            }
            else{
                // i번째 기차 좌석 K-1
                // 1번째 하차
                train_seats[i] = train_seats[i] >>> 1;
            }

        }

        Set<Integer> pass_train = new HashSet<>();
        for (int i = 1; i <= N; i++) {
            pass_train.add(train_seats[i]);
        }
        System.out.println(pass_train.size());
    }
}