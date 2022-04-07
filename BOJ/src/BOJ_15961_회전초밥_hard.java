import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_15961_회전초밥_hard {
    static int N, d, k, c;
    static int[] sushi;
    static int ans; // 먹을 수 있는 최대 초밥 가짓수
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); // 전체 접시
        d = sc.nextInt(); // 전체 초밥 가짓수
        k = sc.nextInt(); // 연속해서 먹을 수 있는 접시
        c = sc.nextInt(); // k랑 상관없이 무조건 먹을 수 있는 초밥 번호

        sushi = new int[N];
        for(int i=0; i<N; i++) {
//			sushi[i] =  Integer.parseInt(br.readLine());
            sushi[i] = sc.nextInt();
        }

        int[] eat = new int[d+1];
        eat[c]++; // 쿠폰 받은건 일단 무조건 먹어

        int cnt=1; // 쿠폰으로 하나 먹고 시작
        for(int i=0; i<k; i++) { // 맨 처음 k개를 일단 먹어서 기록해보자
            if(eat[sushi[i]]==0) // 처음 보는 초밥이면 가짓수 증가
                cnt++;
            eat[sushi[i]]++;
        }

        for(int start=0; start<N; start++) { // 먹기시작하는 접시의 번호가 달라짐.
            eat[sushi[start]]--; // 맨앞에 있는 접시 초밥 카운트 빼기
            if(eat[sushi[start]]==0) // 해당 초밥 카운트 0되면
                cnt--; // 가짓수 하나 감소

            if(eat[sushi[(start+k)%N]]==0) // 끝에 초밥 먹기전에 처음 보는거면
                cnt++;
            eat[sushi[(start+k)%N]]++; // 초밥 먹었음.
            ans = Math.max(ans, cnt);
        }
        System.out.println(ans);
    }
}
