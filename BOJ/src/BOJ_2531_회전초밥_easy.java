import java.util.Scanner;

public class BOJ_2531_회전초밥_easy {
    static int N,d,k,c;
    static int[] sushi;
    static int ans; //먹을수 있는 최대 초밥 가짓수
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); // 전체 접시
        d = sc.nextInt(); // 초밥 가짓수
        k = sc.nextInt(); // 연속해서 먹을 수 있는 접시
        c = sc.nextInt(); // 쿠폰번호

        sushi = new int[N];
        for (int i = 0; i < N; i++) {
            sushi[i] = sc.nextInt();
        }

        ans = Integer.MIN_VALUE;
        for (int start = 0; start < N; start++) {
            // 먹기 시작하는 접시의 번호가 달라짐
            int[] eat = new int[d+1]; //먹은거 기록하기
            eat[c]++; //쿠폰 받은건 무조건 먹기

            int count = 1; // 쿠폰으로 한가지 먹고 시작
            for (int i = start; i < start+k ; i++) {
                // 같은 초밥을 여러개 먹으면 계속 늘어남, 종류를 세어야 하므로 처음 먹는거만 세어야함
                if(eat[sushi[i % N]] == 0) count++;
                eat[sushi[i % N]]++; // i 인덱스가 마지막 접시를 넘어가는 경우가 생기므로 다시 0번 접시로 돌아갈 수 있게 모듈러 수행
            }
            ans = Math.max(count,ans);
        }
        System.out.println(ans);
    }
}
